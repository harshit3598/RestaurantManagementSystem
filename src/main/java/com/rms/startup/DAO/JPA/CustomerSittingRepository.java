package com.rms.startup.DAO.JPA;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rms.startup.Entities.CustomerSittingEntity;

@Repository
public interface CustomerSittingRepository extends JpaRepository<CustomerSittingEntity, Integer>{

	@Query("select customerSittingId from CustomerSittingEntity where tableid=?1 order by customersittingid desc")
	List<Integer> findTable(Integer tableId); 
	
}
