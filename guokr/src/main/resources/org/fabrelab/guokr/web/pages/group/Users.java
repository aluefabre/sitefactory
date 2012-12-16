package org.fabrelab.guokr.web.pages.group;

import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.fabrelab.guokr.web.services.MyCookieManager;
import org.fabrelab.sitefactory.dal.dataobject.GroupDO;
import org.fabrelab.sitefactory.service.GroupService;
import org.fabrelab.sitefactory.service.UserService;

public class Users {
	@Inject
	private GroupService groupService;

	@Inject
	private UserService userService;
	
	@Property
	private GroupDO targetGroup;

	@Inject
	private MyCookieManager cookieManager;

	@Inject
	private PageRenderLinkSource pageRenderLinkSource;
	
	private Boolean onActivate(EventContext context) {
		Long groupId = context.get(Long.class, 0);
		targetGroup = groupService.findByPrimaryKey(groupId);
		return true;
	}

	Long onPassivate() {
		return  targetGroup.getId();
	}
	
}
