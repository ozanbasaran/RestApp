package com.finartz.RestApp.repository;
import com.finartz.RestApp.model.Branch;
import com.finartz.RestApp.model.enumerated.Status;

import java.util.List;


public interface BranchRepository extends BaseRepository<Branch>{
    List<Branch> findByStatus(Status status);

    List<Branch> findByAddress_County_Id(Long county_id);
}
