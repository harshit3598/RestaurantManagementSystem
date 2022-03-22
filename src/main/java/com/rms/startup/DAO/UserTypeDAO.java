package com.rms.startup.DAO;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rms.startup.Bean.UserTypeBean;
import com.rms.startup.DAO.JPA.UserTypeRepository;
import com.rms.startup.Entities.UserTypeEntity;

@Repository
public class UserTypeDAO {

	@Autowired
	UserTypeRepository repo;

	public List<UserTypeBean> getAllUserTypes() {
		List<UserTypeEntity> lst = repo.findAll();
		List<UserTypeBean> returnlst = new ArrayList<UserTypeBean>();
		for(UserTypeEntity UserType : lst)
			returnlst.add(UserType.convertToBean());
		return returnlst;
	}
	
	
	public void addUserType(UserTypeBean userType)
	{
		repo.save(new UserTypeEntity(userType));
	}
	
	public void deleteUserType(Integer userTypeId)
	{
		repo.deleteById(userTypeId);
	}
	
	public void updateUserType(UserTypeBean userType)
	{
		repo.save(new UserTypeEntity(userType));
	}
	
	public UserTypeBean getUserType(Integer userTypeId)
	{
		if(repo.existsById(userTypeId))
			return repo.findById(userTypeId).get().convertToBean();
		return null;
	}
}