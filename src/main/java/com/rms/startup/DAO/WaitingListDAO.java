package com.rms.startup.DAO;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rms.startup.Bean.CustomerBean;
import com.rms.startup.Bean.WaitingListBean;
import com.rms.startup.DAO.JPA.WaitingListRepository;
import com.rms.startup.Entities.CustomerEntity;
import com.rms.startup.Entities.WaitingListEntity;

@Repository
@Transactional
public class WaitingListDAO {

	@Autowired
	WaitingListRepository repo;

	public List<WaitingListBean> getAllWaitingList() {
		List<WaitingListEntity> lst = repo.findAll();
		List<WaitingListBean> returnLst = new ArrayList<>();
		for (WaitingListEntity list : lst)
			returnLst.add(list.convertToBean());
		return returnLst;
	}

	public void addWaitingList(WaitingListBean bean) {
		WaitingListEntity entity = new WaitingListEntity(bean);
		repo.save(entity);
	}

	public void deleteWaitingList(Integer waitingNumber) {
		repo.deleteById(waitingNumber);
	}

	public WaitingListBean getWaitingList(Integer waitingNumber) {
		if (repo.existsById(waitingNumber))
			return repo.findById(waitingNumber).get().convertToBean();
		return null;
	}

	public void updateWaitingList(WaitingListBean bean) {
		WaitingListEntity u = new WaitingListEntity(bean);
		repo.save(u);
	}
	
	public List<WaitingListBean> findCustomer(CustomerBean customerBean)
	{
		CustomerEntity customerEntity = new CustomerEntity(customerBean);
		List<WaitingListEntity> lst = repo.findByCustomer(customerEntity);
		List<WaitingListBean> returnLst = new ArrayList<>();
		for (WaitingListEntity list : lst)
			returnLst.add(list.convertToBean());
		return returnLst;
	}

}
