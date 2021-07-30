package com.finartz.RestApp.service;

import com.finartz.RestApp.model.Branch;
import com.finartz.RestApp.repository.BranchRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BranchService {

    private final BranchRepository branchRepository;

    public BranchService(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    public List<Branch> findAll(){
        return branchRepository.findAll();
    }

    public Branch findById(Long id) {
        return branchRepository.getById(id);
    }

    public Branch create(Branch branch) {
        return branchRepository.save(branch);
    }

    public Branch update(Branch branch){
        Branch foundBranch = branchRepository.getById(branch.getId());
        if (branch.getStatus() != null) {
            foundBranch.setStatus(branch.getStatus());
        }
        if (branch.getName() != null) {
            foundBranch.setName(branch.getName());
        }
        return branchRepository.save(branch);
    }

    public void deleteById(Long id){
        branchRepository.deleteById(id);
    }
}
