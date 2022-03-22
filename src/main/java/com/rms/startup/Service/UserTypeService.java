package com.rms.startup.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rms.startup.Messages;
import com.rms.startup.Bean.UserTypeBean;
import com.rms.startup.DAO.UserTypeDAO;

@Service
public class UserTypeService {

	@Autowired
	UserTypeDAO userTypeDAO;

	public List<UserTypeBean> getAllUserTypes() {
		return userTypeDAO.getAllUserTypes();
	}
	
	
	public String addUserType(UserTypeBean userType){
		if(userTypeDAO.getUserType(userType.getUserTypeId()) == null)
		{
			userTypeDAO.addUserType(userType);
			return Messages.added;
		}
		return Messages.alreadyExist;
			
	}
	
	public String updateUserType(UserTypeBean userType){
		if(userTypeDAO.getUserType(userType.getUserTypeId()) != null)
		{
			userTypeDAO.updateUserType(userType);
			return Messages.updated;
		}
		return Messages.doesNotExist;
	}
	
	public String deleteUserType(Integer userTypeId){
		if(userTypeDAO.getUserType(userTypeId) != null)
		{
			try{
				userTypeDAO.deleteUserType(userTypeId);
			}
			catch(Exception e){
				return Messages.error;
			}
			return Messages.deleted;
		}
		return Messages.doesNotExist;
	}
	
	public UserTypeBean getUserType(Integer userTypeId)
	{
		return userTypeDAO.getUserType(userTypeId);
	}
}