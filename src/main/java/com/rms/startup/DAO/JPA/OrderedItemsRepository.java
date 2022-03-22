package com.rms.startup.DAO.JPA;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rms.startup.Entities.OrderedItemsEntity;

@Repository
public interface OrderedItemsRepository extends JpaRepository<OrderedItemsEntity, Integer>{
	
	@Query("select o from OrderedItemsEntity o where orderid = ?1")
	List<OrderedItemsEntity> findOrder(String orderId);
	
	List<OrderedItemsEntity> findByStatus(int status);
	
}
