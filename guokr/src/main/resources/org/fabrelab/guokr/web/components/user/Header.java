package org.fabrelab.guokr.web.components.user;

import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.fabrelab.sitefactory.dal.dataobject.UserDO;
import org.fabrelab.sitefactory.service.UserService;

public class Header {
	@Property
	@Parameter(required = true, allowNull=false)
	private Long targetUserId;
	
	@Inject 
	private UserService userService;
	
	public UserDO getTargetUser(){
		return userService.getUserById(targetUserId);
	}
}
