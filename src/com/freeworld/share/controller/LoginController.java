package com.freeworld.share.controller;

import javax.inject.Named;

@Named
public class LoginController {

	public String toLogin(){
		return "/faces/main/home.xhtml?faces-redirect=true";
	}
}
