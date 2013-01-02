package org.fabrelab.guokr.web.pages.user.post;

import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.fabrelab.pagekit.PageInfo;
import org.fabrelab.sitefactory.constants.RelationConstants;
import org.fabrelab.sitefactory.dal.dataobject.PostDO;
import org.fabrelab.sitefactory.dal.dataobject.PostRelationDO;
import org.fabrelab.sitefactory.dal.dataobject.UserDO;
import org.fabrelab.sitefactory.service.PostService;
import org.fabrelab.sitefactory.service.UserService;

public class Follow
{
	@Inject 
	private PostService postService;

	@Inject 
	private UserService userService;
	
	@Property
	private UserDO targetUser;

	@Property
	private Integer pageNo;

	@Property
	private PostDO post;

	private Boolean onActivate(EventContext context) {
		Long targetUserId = context.get(Long.class, 0);
		targetUser = userService.getUserById(targetUserId);
		this.pageNo = context.get(Integer.class, 1);
		return true;
	}
	
	public java.util.List<PostDO> getPosts() {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageSize(20);
		pageInfo.setPageStart(20 * pageNo);
		PostRelationDO relation = new PostRelationDO();
		relation.setRelatedId(targetUser.getId());
		relation.setRelatedType("User");
		relation.setRelation(RelationConstants.FOLLOW);
		return postService.pageByRelation(relation, pageInfo);
	}
}


