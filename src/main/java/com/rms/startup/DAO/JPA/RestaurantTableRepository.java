package com.rms.startup.DAO.JPA;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rms.startup.Entities.RestaurantTableEntity;

@Repository
public interface RestaurantTableRepository extends JpaRepository<RestaurantTableEntity, Integer>{
	List<RestaurantTableEntity> findByOccupied(byte occupied);
}
