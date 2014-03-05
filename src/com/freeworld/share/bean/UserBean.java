package com.freeworld.share.bean;

import javax.ejb.Stateless;

import com.freeworld.share.entity.User;

@Stateless
public class UserBean extends BaseBean{

	public UserBean(){
		
	}
	
	public User findById(String id){
		return em.find(User.class, id);
	}
	
	public void save(User user){
		em.persist(user);
	}
	
	public void del(User user){
		em.remove(user);;
	}
	
	public void update(User user){
		em.merge(user);
	}
}
