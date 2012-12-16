package org.fabrelab.guokr.web.components.users;

import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.fabrelab.sitefactory.dal.dataobject.UserDO;

public class ListBlock {
	
	@Property
	@Parameter(required = true, allowNull=false)
	private java.util.List<UserDO> users;
	
	@Property
	private UserDO user;
}
