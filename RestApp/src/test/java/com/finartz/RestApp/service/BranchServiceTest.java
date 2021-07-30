package com.finartz.RestApp.service;

import com.finartz.RestApp.model.Branch;
import com.finartz.RestApp.model.Branch;
import com.finartz.RestApp.model.enumerated.Status;
import com.finartz.RestApp.repository.BranchRepository;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class BranchServiceTest {
    private static final Status InitStatus = Status.WAITING ;
    private static final Status NewStatus= Status.APPROVED;
    @InjectMocks
    private BranchService branchService;

    @Mock
    private BranchRepository branchRepository;


    @Test
    public void whenFetchAll_thenReturnAllBranch() {
        Branch branch1 = Branch.builder().id(1l).name("So Big Güzelyalı").build();
        Branch branch2 = Branch.builder().id(2l).name("So Big Cemalpaşa").build();
        List<Branch> branchList = Arrays.asList(branch1, branch2);

        Mockito.when(branchRepository.findAll()).thenReturn(branchList);

        List<Branch> fetchedList = branchService.findAll();

        assertEquals(branchList.size(), fetchedList.size());
    }

    @Test
    public void whenFetchById_thenReturnBranch() {
        Branch branch = Branch.builder().name("So Big Güzelyalı").build();

        Mockito.when(branchRepository.getById(1L)).thenReturn(branch);

        Branch fetchedBasket = branchService.findById(1L);

        assertEquals(branch.getId(), fetchedBasket.getId());
    }

    @Test
    public void whenAddBranch_thenReturnSavedBranch() {
        Branch branch = Branch.builder().name("So Big Güzelyalı").build();

        Mockito.doReturn(branch).when(branchRepository).save(branch);

        Branch returnedBranch = branchService.create(branch);

        assertEquals(branch.getName(), returnedBranch.getName());
    }

    @Test
    public void whenUpdateBranch_thenReturnUpdatedBranch(){
        Branch existBranch = Branch.builder().id(1L).status(InitStatus).build();
        Branch newBranch = Branch.builder().id(1L).status(NewStatus).build();
        Mockito.when(branchRepository.getById(1L)).thenReturn(existBranch);
        Mockito.when(branchRepository.save(newBranch)).thenReturn(newBranch);
        Branch updatedBasket = branchService.update(newBranch);
        Assertions.assertEquals(existBranch.getStatus(), InitStatus);
        Assertions.assertNotEquals(existBranch.getStatus(), NewStatus);
    }

}