package com.finartz.RestApp.service;

import com.finartz.RestApp.model.entity.AddressEntity;
import com.finartz.RestApp.model.entity.BranchEntity;
import com.finartz.RestApp.model.enumerated.Status;

import java.util.List;

public interface BranchService {

    List<BranchEntity> getBranches();

    BranchEntity getBranch(Long id);

    List<BranchEntity> getBranches(Status status);

    List<BranchEntity> getBranches(AddressEntity addressEntity);

    BranchEntity createBranch(BranchEntity branchEntity);

    BranchEntity updateBranch(BranchEntity branchEntity);

    BranchEntity deleteBranch(Long id);
}
