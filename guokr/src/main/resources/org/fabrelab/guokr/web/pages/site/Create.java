package org.fabrelab.guokr.web.pages.site;

import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.Link;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.BeanEditForm;
import org.apache.tapestry5.corelib.components.TextArea;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.fabrelab.guokr.web.constants.AppConstants;
import org.fabrelab.guokr.web.pages.Login;
import org.fabrelab.guokr.web.services.MyCookieManager;
import org.fabrelab.sitefactory.dal.dataobject.SiteDO;
import org.fabrelab.sitefactory.service.SiteService;

public class Create {
	@Inject
	private ComponentResources resources;

	@Inject
	private SiteService siteService;
	
	@Inject
	private MyCookieManager cookieManager;
	
	@Inject
	private PageRenderLinkSource pageRenderLinkSource;
	
	@Component(id = "createSiteForm")
	private BeanEditForm createSiteForm; 
	
	@Property
	private SiteDO bean;
	
	@Component
	private TextArea description;
	
	private Link onActivate(EventContext context) {
		if(cookieManager.getCurrentUserId()==null){
			return pageRenderLinkSource.createPageRenderLink(Login.class);
		}
		return null;
	}
	
	public void onValidateForm() {
		
	}
	
	public Link onSuccess() {
		if(cookieManager.getCurrentUserId()==null){
			return pageRenderLinkSource.createPageRenderLink(Login.class);
		}
		bean.setStatus(AppConstants.STATUS_REGULAR);
		siteService.createSite(cookieManager.getCurrentUserId(), bean);
		Link link = pageRenderLinkSource.createPageRenderLinkWithContext( List.class, 0);
		return link;
	}
}
