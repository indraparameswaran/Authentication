package com.hcl.repository;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hcl.model.User;

@Repository
public class UserRepository {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	EntityManager em;
	
    public User findById(int id) {
    	return em.find(User.class, id);
    }
    
//    public User findByName(String name) {
//    	return em.findfind(User.class, name);
//    }
    
    public boolean userAuthentication(String name, String pwd) {
    	try {
	    	TypedQuery<User> query = em.createQuery("Select u From User u where username = :uname",User.class);
			User user = query.setParameter("uname", name).getSingleResult();
			if(user != null && user.getPassword().equals(pwd)) {
					return true;
				
			} 
    	} catch (NoResultException e) {
    		return false;
    	}
    	return false;
    }

}
