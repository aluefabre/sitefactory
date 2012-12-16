package org.fabrelab.guokr.web.pages.group;

import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.Link;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.fabrelab.guokr.web.constants.AppConstants;
import org.fabrelab.guokr.web.constants.RelationConstants;
import org.fabrelab.guokr.web.pages.Login;
import org.fabrelab.guokr.web.services.MyCookieManager;
import org.fabrelab.pagekit.PageInfo;
import org.fabrelab.sitefactory.dal.dataobject.GroupDO;
import org.fabrelab.sitefactory.dal.dataobject.GroupRelationDO;
import org.fabrelab.sitefactory.exception.NoPermissionException;
import org.fabrelab.sitefactory.service.GroupService;
import org.fabrelab.sitefactory.service.UserService;

public class Tag {
	@Inject
	private GroupService groupService;

	@Inject
	private UserService userService;
	
	@Property
	private GroupDO group;

	@Property
	private Integer pageNo;
	
	@Property
	private Long tagId;
	
	private Boolean onActivate(EventContext context) {
		this.tagId = context.get(Long.class, 0);
		this.pageNo = context.get(Integer.class, 1);
		if(pageNo==null){
			pageNo=0;
		}
		return true;
	}

	Object[] onPassivate() {
		return new Object[]{tagId, pageNo};
	}
	
	public java.util.List<GroupDO> getGroups(){
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageSize(20);
		pageInfo.setPageStart(20 * pageNo);

		GroupDO example = new GroupDO();
		example.setStatus(AppConstants.STATUS_REGULAR);
		
		GroupRelationDO relation = new GroupRelationDO();
		relation.setRelatedId(tagId);
		relation.setRelatedType("Tag");
		relation.setRelation(RelationConstants.REGULAR);
		
		return groupService.pageByRelationAndExample(relation, example, pageInfo);
	}
	
}
