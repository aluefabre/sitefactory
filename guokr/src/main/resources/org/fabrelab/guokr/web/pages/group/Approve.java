package org.fabrelab.guokr.web.pages.group;

import java.util.List;

import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.Link;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.fabrelab.guokr.web.constants.AppConstants;
import org.fabrelab.guokr.web.pages.Login;
import org.fabrelab.guokr.web.services.MyCookieManager;
import org.fabrelab.pagekit.PageInfo;
import org.fabrelab.sitefactory.dal.dataobject.GroupDO;
import org.fabrelab.sitefactory.exception.NoPermissionException;
import org.fabrelab.sitefactory.service.GroupService;
import org.fabrelab.sitefactory.service.UserService;

public class Approve {
	@Inject
	private GroupService groupService;

	@Inject
	private UserService userService;
	
	@Property
	private GroupDO group;

	@Property
	private Integer pageNo;
	
	@Inject
	private MyCookieManager cookieManager;

	@Inject
	private PageRenderLinkSource pageRenderLinkSource;
	
	private Boolean onActivate(EventContext context) {
		this.pageNo = context.get(Integer.class, 0);
		if(pageNo==null){
			pageNo = 0;
		}
		return true;
	}
	
	Integer onPassivate() {
		return  pageNo;
	}
	
	public List<GroupDO> getGroups(){
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageSize(20);
		pageInfo.setPageStart(20 * pageNo);

		GroupDO example = new GroupDO();
		example.setStatus(AppConstants.STATUS_PENDING);
		return groupService.pageByExample(example, pageInfo);
	}
	
	private Link onActionFromObject(EventContext context) throws NoPermissionException {
		if(cookieManager.getCurrentUserId()==null){
			return pageRenderLinkSource.createPageRenderLink(Login.class);
		}
		Long groupId =  context.get(Long.class, 0);
		Long currentUserId = cookieManager.getCurrentUserId();
		groupService.deleteGroupById(currentUserId, groupId);
		return null;
	}
	
	private Link onActionFromAccept(EventContext context) throws NoPermissionException {
		if(cookieManager.getCurrentUserId()==null){
			return pageRenderLinkSource.createPageRenderLink(Login.class);
		}
		Long groupId =  context.get(Long.class, 0);
		Long currentUserId = cookieManager.getCurrentUserId();
		GroupDO group =groupService.findByPrimaryKey(groupId);
		group.setStatus(AppConstants.STATUS_REGULAR);
		groupService.updateGroup(currentUserId, group);
		return null;
	}
}
