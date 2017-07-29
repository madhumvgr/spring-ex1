package com.cognisoft.login.service;


import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cognisoft.login.dao.LoginDao;
import com.cognisoft.login.model.Member;

@Component
public class LoginService {

	@Autowired
	private LoginDao loginDao;

	@Transactional
	public void add(Member mem) {
		loginDao.persist(mem);
	}
	
	@Transactional(readOnly = true)
	public boolean verifyLogin(Member mem) {
		List<Member> memSuccess=loginDao.verifyLogin(mem);
		if(memSuccess.size()>=1) return true;
		else return false;

	}

}
