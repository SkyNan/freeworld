package com.freeworld.share.controller;

import javax.inject.Inject;
import javax.inject.Named;

import com.freeworld.share.session.SessionManager;

@Named
public class LoginController {

	@Inject
	private SessionManager manager;
	
	public String toLogin(){
		manager.logoff();
		return "/faces/main/home.xhtml?faces-redirect=true";
	}
}
