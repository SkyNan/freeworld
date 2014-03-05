package com.freeworld.share.controller;

import java.io.Serializable;

import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.freeworld.free.utils.PasswordHash;
import com.freeworld.share.bean.RoleBean;
import com.freeworld.share.bean.UserBean;
import com.freeworld.share.entity.Role;
import com.freeworld.share.entity.User;
import com.freeworld.share.session.SessionManager;

@Named
@SessionScoped
@Stateful
public class RegisterController implements Serializable{

	private static final long serialVersionUID = -5861814876269811143L;

	private static final String COMPONENT_ID = "registerForm";
	
	@Inject
	private UserBean userBean;
	
	@Inject
	private RoleBean roleBean;
	
	@Inject
	private SessionManager manager;
	
	private User user = new User();
	
	public RegisterController(){
		
	}
	
	public String toRegister(){
		return "/faces/auth/register.xhtml?faces-redirect=true";
	}
	
	public void register(){
		String userId = user.getId();
		String password = user.getPassword();
		String passwordAgain = user.getPasswordAgain();
		if(userId.equals("")){
			manager.addComponentMessageWarn(COMPONENT_ID,"用户名不可为空","用户名不可为空");
		}else if(password.equals("")&&passwordAgain.equals("")){
			manager.addComponentMessageWarn(COMPONENT_ID,"密码不可为空","密码不可为空");
		}else if(!password.equals(passwordAgain)){
			manager.addComponentMessageWarn(COMPONENT_ID,"两次输入密码不一致，请重新输入","两次输入密码不一致，请重新输入");
			user.setPassword("");
			user.setPasswordAgain("");
		}else{
			User existuser = userBean.findById(userId);
			if(existuser!=null){
				manager.addComponentMessageWarn(COMPONENT_ID,"该用户名已存在,请重新输入","该用户名已存在,请重新输入");
			}else{
				try{
					user.setPassword(PasswordHash.makePasswordHash(password));
					Role role = roleBean.findById("teacher");
					user.getRoles().add(role);
					userBean.save(user);
					manager.addComponentMessageInfo(COMPONENT_ID, "注册成功，返回登陆界面登陆","注册成功，返回登陆界面登陆");
				}catch(Exception ex){
					manager.addComponentMessageWarn(COMPONENT_ID,"注册失败，网络故障","注册失败，网络故障");
				}
			}
		}
		
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
