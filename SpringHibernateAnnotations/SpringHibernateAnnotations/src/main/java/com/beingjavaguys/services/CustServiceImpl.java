package com.beingjavaguys.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.beingjavaguys.dao.CustDao;
import com.beingjavaguys.domain.Customer;

public class CustServiceImpl implements CustService {
	
	@Autowired
	CustDao custDao;

	@Override
	public List<Customer> getCustomer() {
		return custDao.getCustomer();
	}

}
