package org.fabrelab.guokr.web.pages.user.post;

import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.Link;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.fabrelab.guokr.web.pages.Login;
import org.fabrelab.guokr.web.services.MyCookieManager;
import org.fabrelab.pagekit.PageInfo;
import org.fabrelab.sitefactory.dal.dataobject.PostDO;
import org.fabrelab.sitefactory.dal.dataobject.UserDO;
import org.fabrelab.sitefactory.exception.NoPermissionException;
import org.fabrelab.sitefactory.service.PostService;
import org.fabrelab.sitefactory.service.UserService;

public class Publish {
	
	@Inject
	private PostService postService;

	@Inject
	private UserService userService;
	
	@Property
	private PostDO post;
	
	@Property
	private UserDO targetUser;

	@Property
	private Integer pageNo;

	private Boolean onActivate(EventContext context) {
		Long targetUserId = context.get(Long.class, 0);
		targetUser = userService.getUserById(targetUserId);
		pageNo=0;
		if(context.getCount()>1){
			this.pageNo = context.get(Integer.class, 1);
		}
		return true;
	}

	Object[] onPassivate() {
		return new Object[]{targetUser.getId(), pageNo};
	}
	
	public java.util.List<PostDO> getPosts(){
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageSize(20);
		pageInfo.setPageStart(20 * pageNo);
		
		PostDO postDO = new PostDO();
		postDO.setCreatorId(targetUser.getId());
		postDO.setType("Post");
		
		return postService.pageByExample(postDO, pageInfo);
	}
}
