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
import org.fabrelab.guokr.web.constants.AppConstants;
import org.fabrelab.guokr.web.formobjcet.GroupCreate;
import org.fabrelab.guokr.web.pages.Login;
import org.fabrelab.guokr.web.services.MyCookieManager;
import org.fabrelab.sitefactory.constants.RelationConstants;
import org.fabrelab.sitefactory.dal.dataobject.GroupDO;
import org.fabrelab.sitefactory.dal.dataobject.GroupRelationDO;
import org.fabrelab.sitefactory.dal.dataobject.TagDO;
import org.fabrelab.sitefactory.dal.dataobject.TagRelationDO;
import org.fabrelab.sitefactory.service.GroupService;
import org.fabrelab.sitefactory.service.TagService;

public class Create {
	@Inject
	private ComponentResources resources;

	@Inject
	private GroupService groupService;
	
	@Inject
	private MyCookieManager cookieManager;
	
	@Inject
	private PageRenderLinkSource pageRenderLinkSource;
	
	@Component(id = "createGroupForm")
	private BeanEditForm createGroupForm; 
	
	@Property
	private GroupCreate bean;
	
	@Component
	private TextArea description;
	
	@Property
	private SelectModel tagSelectModel;
	
	@Inject
	private SelectModelFactory selectModelFactory;
	
	@Inject
	private TagService tagService;
	
	@Property
	private TagDO selectedTag;
	
	void setupRender() {
	    java.util.List<TagDO> tagDOs = tagService.listTagByExample(new TagDO());
	    tagSelectModel = selectModelFactory.create(tagDOs, "name");
	}
	
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
		GroupDO group = new GroupDO();
		group.setStatus(AppConstants.STATUS_PENDING);
		group.setTitle(bean.getTitle());
		group.setDescription(bean.getDescription());
		groupService.createGroup(cookieManager.getCurrentUserId(), group);
		
		GroupRelationDO groupRelation = new GroupRelationDO();
		groupRelation.setGroupId(group.getId());
		groupRelation.setRelatedId(selectedTag.getId());
		groupRelation.setRelatedType("Tag");
		groupRelation.setRelation(RelationConstants.REGULAR);
		groupService.createGroupRelation(cookieManager.getCurrentUserId(), groupRelation );
		
		TagRelationDO tagRelation = new TagRelationDO();
		tagRelation.setTagId(selectedTag.getId());
		tagRelation.setRelatedId(group.getId());
		tagRelation.setRelatedType("Group");
		tagRelation.setRelation(RelationConstants.REGULAR);
		tagService.createTagRelation(tagRelation);
				
		Link link = pageRenderLinkSource.createPageRenderLinkWithContext(Approve.class, 0);
		return link;
	}
}
