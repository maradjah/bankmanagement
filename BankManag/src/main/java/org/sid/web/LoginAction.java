package org.sid.web;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.sid.entities.User;
import org.sid.metier.IUserMetier;
import org.springframework.beans.factory.annotation.Autowired;

import com.opensymphony.xwork2.ActionSupport;

public class LoginAction extends ActionSupport implements SessionAware {

	private static final long serialVersionUID = -8551102461214426956L;
	@Autowired
	private IUserMetier userMetier;
	private User user = new User();
	private Map<String, Object> sessionAttributes = null;
	private String username;
	private String password;

	@Override
	public String execute() {

		System.out.println("inside execute");
		System.out.println("username : " + username);
		System.out.println("password : " + password);
		System.out.println("userMetier.login(username, password) : "+userMetier.login(username, password));
		if (userMetier.login(username, password) == password) {
			user.setUsername(username);
			sessionAttributes.put("USER", user);
			return SUCCESS;
		} else
			return INPUT;
	}

	@Override
	public void setSession(Map<String, Object> sessionAttributes) {
		this.sessionAttributes = sessionAttributes;
	}

	public Map<String, Object> getSessionAttributes() {
		return sessionAttributes;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setSessionAttributes(Map<String, Object> sessionAttributes) {
		this.sessionAttributes = sessionAttributes;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	// @Override
	// public User getModel() {
	// return user;
	// }

}
