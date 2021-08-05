package com.finartz.RestApp.service;

import com.finartz.RestApp.model.Branch;
import com.finartz.RestApp.model.enumerated.Status;

import java.util.List;

public interface BranchService {

    public Branch create(Branch branch);

    public List<Branch> findAll();

    public Branch findById(Long id);

    public List<Branch> findByStatus(Status status);

    public List<Branch> findByAddress_County_Id(Long county_id);

    public Branch update(Branch branch);

    public Branch deleteById(Long id);
}