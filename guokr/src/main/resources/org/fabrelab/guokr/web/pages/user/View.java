package org.fabrelab.guokr.web.pages.user;

import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.fabrelab.sitefactory.dal.dataobject.UserDO;
import org.fabrelab.sitefactory.service.UserService;

public class View {
	@Inject 
	private UserService userService;
	
	@Property
	private UserDO targetUser;
	
	private Boolean onActivate(Long userBId) {
		targetUser = userService.getUserById(userBId);
		return true;
	}
	
	Long onPassivate() {
		return targetUser.getId();
	}
}
