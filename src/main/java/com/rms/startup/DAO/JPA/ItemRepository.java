package com.rms.startup.DAO.JPA;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rms.startup.Entities.ItemEntity;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Integer>{

	public List<ItemEntity> findByCategoryCategoryId(Integer categoryId);
}
