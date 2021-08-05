package com.finartz.RestApp.service.impl;

import com.finartz.RestApp.model.Branch;
import com.finartz.RestApp.model.enumerated.Status;
import com.finartz.RestApp.repository.BranchRepository;
import com.finartz.RestApp.service.BranchService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;

    public BranchServiceImpl(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    @Override
    public Branch create(Branch branch) {
        return branchRepository.save(branch);
    }

    @Override
    public List<Branch> findAll() {
        return branchRepository.findAll();
    }

    @Override
    public Branch findById(Long id) {
        return branchRepository.getById(id);
    }

    @Override
    public List<Branch> findByStatus(Status status) {
        return branchRepository.findByStatus(status);
    }

    @Override
    public List<Branch> findByAddress_County_Id(Long county_id) {
        return branchRepository.findByAddress_County_Id(county_id);
    }

    @Override
    public Branch update(Branch branch) {
        Branch foundBranch = branchRepository.getById(branch.getId());

        if (branch.getName() != null)
            foundBranch.setName(branch.getName());
        if (branch.getAddress() != null)
            foundBranch.setAddress(branch.getAddress());
        if (branch.getStatus() != null)
            foundBranch.setStatus(branch.getStatus());
        if (branch.getMenu() != null)
            foundBranch.setMenu(branch.getMenu());
        if (branch.getRestaurant() != null)
            foundBranch.setRestaurant(branch.getRestaurant());

        return branchRepository.save(foundBranch);

    }

    @Override
    public Branch deleteById(Long id) {
        Branch branch = branchRepository.getById(id);
        if (branch != null) {
            branchRepository.deleteById(id);
            return branch;
        }
        return branch;
    }
}
