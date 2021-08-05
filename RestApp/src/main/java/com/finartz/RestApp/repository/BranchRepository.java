package com.finartz.RestApp.repository;

import com.finartz.RestApp.model.entity.AddressEntity;
import com.finartz.RestApp.model.entity.BranchEntity;
import com.finartz.RestApp.model.enumerated.Status;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BranchRepository extends BaseRepository<BranchEntity> {

    List<BranchEntity> findByStatus(Status status);

    List<BranchEntity> findByAddressEntity(AddressEntity addressEntity);

}
