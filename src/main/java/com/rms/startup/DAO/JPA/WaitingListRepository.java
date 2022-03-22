package com.rms.startup.DAO.JPA;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rms.startup.Entities.CustomerEntity;
import com.rms.startup.Entities.WaitingListEntity;

@Repository
public interface WaitingListRepository extends JpaRepository<WaitingListEntity, Integer>{
	List<WaitingListEntity> findByCustomer(CustomerEntity customerEntity);
}
