package org.fabrelab.guokr.web.pages.group;

import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.fabrelab.guokr.web.constants.RelationConstants;
import org.fabrelab.guokr.web.services.MyCookieManager;
import org.fabrelab.pagekit.PageInfo;
import org.fabrelab.sitefactory.dal.dataobject.GroupDO;
import org.fabrelab.sitefactory.dal.dataobject.PostDO;
import org.fabrelab.sitefactory.dal.dataobject.PostRelationDO;
import org.fabrelab.sitefactory.service.GroupService;
import org.fabrelab.sitefactory.service.PostService;
import org.fabrelab.sitefactory.service.UserService;

public class Posts {
	
	@Inject 
	private UserService userService;
	
	@Inject
	private GroupService groupService;
	
	@Property
	private GroupDO targetGroup;

	@Property
	private PostDO post;
	
	@Inject
	private PostService postService;

	@Inject
	private MyCookieManager cookieManager;

	@Inject
	private PageRenderLinkSource pageRenderLinkSource;
	
	@Property
	private Integer pageNo;
	
	private Boolean onActivate(EventContext context) {
		Long groupId = context.get(Long.class, 0);
		if(context.getCount()>1){
			this.pageNo =  context.get(Integer.class, 1);
		}else{
			pageNo = 0;
		}
		targetGroup = groupService.findByPrimaryKey(groupId);	
		return true;	
	}
	
	Object[] onPassivate() {
		return new Object[] {targetGroup.getId(), pageNo};
	}
	
	public java.util.List<PostDO> getPosts() {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageSize(20);
		pageInfo.setPageStart(20 * pageNo);
		PostRelationDO relation = new PostRelationDO();
		relation.setRelatedId(targetGroup.getId());
		relation.setRelatedType("Group");
		relation.setRelation(RelationConstants.REGULAR);
		return  postService.pageByRelation(relation, pageInfo);
	}
	
}
