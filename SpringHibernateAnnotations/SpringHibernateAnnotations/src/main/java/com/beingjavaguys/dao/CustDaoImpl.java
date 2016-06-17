package com.beingjavaguys.dao;

import java.io.Serializable;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import com.beingjavaguys.domain.Customer;

public class CustDaoImpl implements CustDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public List<Customer> getCustomer() {
		Session session = sessionFactory.openSession();
		@SuppressWarnings("unchecked")
		List<Customer> customerList = session.createQuery("from Customer")
				.list();
		session.close();
		return customerList;
	}

}


