package com.rudra.aks.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Service;

import com.rudra.aks.bo.TestBO;

@Service
public class UserServiceImpl implements UserService {

	/**
	 * Logger
	 */
	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
	
	@Autowired
	HibernateTemplate	template;
	
	@Override
	public int saveUser(TestBO testBO) {
		return  (int) template.save(testBO);
	}

}
