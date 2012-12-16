package org.fabrelab.guokr.web.components.user;

import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.fabrelab.sitefactory.dal.dataobject.UserDO;

public class ViewBlock {
	@Property
	@Parameter(required = true, allowNull=false)
	private UserDO targetUser;
}
