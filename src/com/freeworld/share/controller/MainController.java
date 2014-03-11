package com.freeworld.share.controller;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

@Named
@SessionScoped
public class MainController implements Serializable{

	private static final long serialVersionUID = -2571394477506415641L;
	
	private String currentURL="../auth/login.xhtml";
	
	public static final String NEWSTUDENTURL = "student/studentinfo.xhtml";
	
	public MainController(){
		
	}

	public void toNewStudent(){
		this.currentURL=NEWSTUDENTURL;
	}
	
	public String getCurrentURL() {
		return currentURL;
	}

	public void setCurrentURL(String currentURL) {
		this.currentURL = currentURL;
	}

}
