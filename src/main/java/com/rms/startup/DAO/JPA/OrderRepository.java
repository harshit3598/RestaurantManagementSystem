package com.rms.startup.DAO.JPA;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rms.startup.Entities.OrderEntity;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, String>{

	@Query("select orderId from OrderEntity where customerSittingId = ?1")
	String findCustomerSitting(Integer customerSittingId);
	
	List<OrderEntity> findByIsComplete(int isComplete);
}
