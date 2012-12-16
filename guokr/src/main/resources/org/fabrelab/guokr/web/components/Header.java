package org.fabrelab.guokr.web.components;

import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.fabrelab.guokr.web.services.MyCookieManager;
import org.fabrelab.sitefactory.dal.dataobject.UserDO;
import org.fabrelab.sitefactory.service.UserService;


public class Header {
	
	@Inject
	private ComponentResources resources;

	@Inject
	private MyCookieManager cookieManager;
	
	@Inject 
	private UserService userService;
	
	public String getHeaderClass() {
		String pageName = resources.getPageName(); 
		String parts[] = pageName.split("/");
		if(parts.length>=1){
			return parts[0].toLowerCase();
		}		
		return pageName.toLowerCase();
		
	}
	
	public Long getCurrentUserId(){
		return cookieManager.getCurrentUserId();
	}
	
	public boolean getIsLoggedIn(){
		return cookieManager.getCurrentUserId()!=null;
	}
	
	public UserDO getCurrentUser(){
		Long currentUserId = getCurrentUserId();
		return userService.getUserById(currentUserId);
	}
}
