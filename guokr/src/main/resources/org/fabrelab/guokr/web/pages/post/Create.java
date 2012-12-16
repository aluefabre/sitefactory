package org.fabrelab.guokr.web.pages.post;

import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.Link;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.fabrelab.guokr.web.constants.RelationConstants;
import org.fabrelab.guokr.web.pages.Login;
import org.fabrelab.guokr.web.services.MyCookieManager;
import org.fabrelab.sitefactory.dal.dataobject.GroupRelationDO;
import org.fabrelab.sitefactory.dal.dataobject.PostDO;
import org.fabrelab.sitefactory.dal.dataobject.PostRelationDO;
import org.fabrelab.sitefactory.service.GroupService;
import org.fabrelab.sitefactory.service.PostService;

public class Create {
	@Property
	private String title;

	@Property
	private String content;

	@Inject
	private PostService postService;

	@Inject
	private GroupService groupService;
	
	@Inject
	private MyCookieManager cookieManager;

	@Inject
	private PageRenderLinkSource pageRenderLinkSource;

	@Property
	private Long groupId;
	
	private Link onActivate(EventContext context) {
		if (cookieManager.getCurrentUserId() == null) {
			return pageRenderLinkSource.createPageRenderLink(Login.class);
		}
		groupId = context.get(Long.class, 0);
		return null;
	}
	
	Object[] onPassivate() {
		return new Object[]{groupId};
	}
	
	public Link onSuccess(EventContext context) {
		if (cookieManager.getCurrentUserId() == null) {
			return pageRenderLinkSource.createPageRenderLink(Login.class);
		}
		groupId = context.get(Long.class, 0);
		PostDO post = new PostDO();
		post.setContent(content);
		post.setTitle(title);
		post.setType("POST");
		postService.createPost(post, cookieManager.getCurrentUserId());
		
		PostRelationDO arel = new PostRelationDO();
		arel.setPostId(post.getId());
		arel.setRelatedId(groupId);
		arel.setRelation(RelationConstants.REGULAR);
		arel.setRelatedType("Group");
		postService.createPostRelation(arel, cookieManager.getCurrentUserId());
		
		GroupRelationDO grel = new GroupRelationDO();
		grel.setGroupId(groupId);
		grel.setRelatedId(post.getId());
		grel.setRelation(RelationConstants.REGULAR);
		grel.setRelatedType("Post");
		groupService.createGroupRelation(cookieManager.getCurrentUserId(), grel);
		
		return pageRenderLinkSource.createPageRenderLinkWithContext(View.class, post.getId());
	}
}
