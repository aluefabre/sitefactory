package org.fabrelab.guokr.web.components.user;

import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.fabrelab.sitefactory.dal.dataobject.UserDO;
import org.fabrelab.sitefactory.service.UserService;

public class ArticleSidebar {
	@Inject
	private ComponentResources resources;

	@Inject 
	private UserService userService;
	
	public String getNavClass() {
		String pageName = resources.getPageName(); 
		String parts[] = pageName.split("/");
		if(parts.length>1){
			return parts[1].toLowerCase();
		}		
		return pageName.toLowerCase();
	}

	@Property
	@Parameter(required = true, allowNull=false)
	private Long targetUserId;
	
	public UserDO getTargetUser(){
		return userService.getUserById(targetUserId);
	}
}
