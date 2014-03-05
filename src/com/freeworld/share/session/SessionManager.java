package com.freeworld.share.session;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import com.freeworld.share.bean.UserBean;
import com.freeworld.share.entity.User;
import com.sun.xml.ws.developer.Stateful;

@Stateful
@SessionScoped
public class SessionManager implements Serializable{

	private static final long serialVersionUID = 14622711455943025L;
	
	@Inject
	private UserBean userBean;

	private User user = null;

	public User getLoginUser() throws Exception {		
		if(user == null){
			ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
			user = userBean.findById(externalContext.getUserPrincipal().getName());
		}
		return user;
	}

	public boolean hasUserRole(String role){
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		return externalContext.isUserInRole(role);
	}

	public void logoff() {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		HttpSession session = (HttpSession)externalContext.getSession(false);
		if(session != null){
			session.invalidate();
		}
	}

	public void redirect(String url)  throws IOException {
		ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();
		externalContext.redirect(url);
	}

	public void addGlobalMessageFatal(String summary, String detail){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, summary, detail));
	}

	public void addGlobalMessageWarn(String summary, String detail){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, summary, detail));
	}

	public void addGlobalMessageInfo(String summary, String detail){
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail));
	}

	public void addComponentMessageFatal(String id, String summary,
			String detail) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.addMessage(id, new FacesMessage(FacesMessage.SEVERITY_FATAL, summary, detail));
	}

	public void addComponentMessageWarn(String id, String summary, String detail) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.addMessage(id, new FacesMessage(FacesMessage.SEVERITY_WARN, summary, detail));
	}

	public void addComponentMessageInfo(String id, String summary, String detail) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		facesContext.addMessage(id, new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail));
	}

}
