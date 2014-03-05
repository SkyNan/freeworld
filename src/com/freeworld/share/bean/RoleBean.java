package com.freeworld.share.bean;

import javax.ejb.Stateless;

import com.freeworld.share.entity.Role;

@Stateless
public class RoleBean extends BaseBean{

	public RoleBean(){
		
	}
	
	public Role findById(String id){
		return em.find(Role.class, id);
	}
}
