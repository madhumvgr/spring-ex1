package com.cognisoft.login.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;

import com.cognisoft.login.model.Member;



@Component
public class LoginDao {

	@PersistenceContext
	private EntityManager em;

	public void persist(Member mem) {
		em.persist(mem);
	}

	public List<Member> verifyLogin(Member mem) { 
		return em.createQuery("FROM Member m WHERE m.email=:email and m.password=:password").setParameter("email",mem.getEmail()).setParameter("password",mem.getPassword()).getResultList();
	}

}
