package org.fabrelab.guokr.web.pages.admin.tag;

import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.Link;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.fabrelab.guokr.web.pages.Login;
import org.fabrelab.guokr.web.services.MyCookieManager;
import org.fabrelab.pagekit.PageInfo;
import org.fabrelab.sitefactory.dal.dataobject.TagDO;
import org.fabrelab.sitefactory.exception.NoPermissionException;
import org.fabrelab.sitefactory.service.TagService;
import org.fabrelab.sitefactory.service.UserService;

public class List {
	@Inject
	private TagService tagService;

	@Inject
	private UserService userService;
	
	@Property
	private TagDO tag;

	@Property
	private Integer pageNo;

	@Inject
	private MyCookieManager cookieManager;

	@Inject
	private PageRenderLinkSource pageRenderLinkSource;
	
	private Boolean onActivate(EventContext context) {
		this.pageNo = context.get(Integer.class, 0);
		if(pageNo==null){
			pageNo=0;
		}
		return true;
	}

	Integer onPassivate() {
		return  pageNo;
	}
	
	public java.util.List<TagDO> getTags(){
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageSize(20);
		pageInfo.setPageStart(20 * pageNo);

		TagDO example = new TagDO();
		example.setType("TAG_COMMON");
		return tagService.listTagByExample(pageInfo, example);
	}
	
	Link onActionFromDelete(EventContext context) throws NoPermissionException {
		if(cookieManager.getCurrentUserId()==null){
			return pageRenderLinkSource.createPageRenderLink(Login.class);
		}
		Long groupId =  context.get(Long.class, 0);
		Long currentUserId = cookieManager.getCurrentUserId();
		tagService.deleteTagById(currentUserId, groupId);
		return null;
	}
	
}
