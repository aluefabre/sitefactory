package org.fabrelab.guokr.web.formobjcet;

import org.apache.tapestry5.beaneditor.Validate;

public class UserLogin {
	
	@Validate("required")
	private String email;
	
	@Validate("required")
	private String password;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
