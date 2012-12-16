package org.fabrelab.guokr.web.pages.group;


import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.Link;
import org.apache.tapestry5.SelectModel;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.BeanEditForm;
import org.apache.tapestry5.corelib.components.TextArea;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.apache.tapestry5.services.SelectModelFactory;
import org.fabrelab.guokr.web.pages.Login;
import org.fabrelab.guokr.web.services.MyCookieManager;
import org.fabrelab.sitefactory.dal.dataobject.TagDO;
import org.fabrelab.sitefactory.service.TagService;

public class CreateTag {
	@Inject
	private ComponentResources resources;

	@Inject
	private TagService tagService;
	
	@Inject
	private MyCookieManager cookieManager;
	
	@Inject
	private PageRenderLinkSource pageRenderLinkSource;
	
	@Component(id = "createTagForm")
	private BeanEditForm createTagForm; 
	
	@Property
	private TagDO bean;
	
	@Component
	private TextArea description;
	
	@Property
	private SelectModel tagSelectModel;
	
	@Inject
	private SelectModelFactory selectModelFactory;
	
	
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
		bean.setType("TAG_FOR_GROUP");
		tagService.createTag(cookieManager.getCurrentUserId(), bean);
		Link link = pageRenderLinkSource.createPageRenderLinkWithContext(Tags.class, 0);
		return link;
	}
}
