package org.fabrelab.guokr.web.services;

import org.apache.tapestry5.ioc.annotations.Inject;
import org.fabrelab.sitefactory.dal.dataobject.UserDO;
import org.fabrelab.sitefactory.service.UserService;

public class MyCookieManager {
	
	static ThreadLocal<UserDO> currentUser = new ThreadLocal<UserDO>();
	
	@Inject 
	org.apache.tapestry5.services.Cookies cookie;

	@Inject
	private UserService userService;
	
	public UserDO getCurrentUser(){
		return currentUser.get();
	}
	
	public Long getCurrentUserId(){
		try {
			String str = cookie.readCookieValue("careerbus:uid");
			return Long.parseLong(str);
		} catch (NumberFormatException e) {
		}
		return null;
	}
	
	public void setCurrentUserId(Long userId){
		cookie.writeCookieValue("careerbus:uid", userId+"");
	}

	public void cleanCurrentUser() {
		currentUser.set(null);
	}

	public void initCurrentUser() {
		Long userId = getCurrentUserId();
		if(userId!=null){
			UserDO user = userService.getUserById(userId);
			currentUser.set(user);
		}
	}

}
