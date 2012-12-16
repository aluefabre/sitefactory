package org.fabrelab.guokr.web.pages.site;

import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.fabrelab.guokr.web.services.MyCookieManager;
import org.fabrelab.sitefactory.dal.dataobject.SiteDO;
import org.fabrelab.sitefactory.service.SiteService;
import org.fabrelab.sitefactory.service.UserService;

public class Member {
	@Inject
	private SiteService siteService;

	@Inject
	private UserService userService;
	
	@Property
	private SiteDO targetSite;

	@Inject
	private MyCookieManager cookieManager;

	@Inject
	private PageRenderLinkSource pageRenderLinkSource;
	
	private Boolean onActivate(EventContext context) {
		Long siteId = context.get(Long.class, 0);
		targetSite = siteService.findByPrimaryKey(siteId);
		return true;
	}

	Long onPassivate() {
		return  targetSite.getId();
	}
	
}
