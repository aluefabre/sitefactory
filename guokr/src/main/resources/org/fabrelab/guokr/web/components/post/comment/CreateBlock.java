package org.fabrelab.guokr.web.components.post.comment;

import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.Link;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.fabrelab.guokr.web.pages.Login;
import org.fabrelab.guokr.web.services.MyCookieManager;
import org.fabrelab.sitefactory.constants.RelationConstants;
import org.fabrelab.sitefactory.dal.dataobject.CommentDO;
import org.fabrelab.sitefactory.dal.dataobject.CommentRelationDO;
import org.fabrelab.sitefactory.dal.dataobject.PostDO;
import org.fabrelab.sitefactory.dal.dataobject.PostRelationDO;
import org.fabrelab.sitefactory.service.CommentService;
import org.fabrelab.sitefactory.service.PostService;
import org.fabrelab.sitefactory.service.UserService;

public class CreateBlock {

	@Property
	@Parameter(required = true, allowNull=false)
	private PostDO targetPost;	
	
	@Inject
	private PostService postService;
	
	@Inject
	private UserService userService;
	
	@Inject
	private CommentService commentService;

	@Property
	private String commentContent;
	
	@Inject
	private MyCookieManager cookieManager;

	@Inject
	private PageRenderLinkSource pageRenderLinkSource;
	
	public Link onSuccess(EventContext context) {
		if (cookieManager.getCurrentUserId() == null) {
			return pageRenderLinkSource.createPageRenderLink(Login.class);
		}
		Long postId = context.get(Long.class, 0);
		CommentDO comment = new CommentDO();
		comment.setContent(commentContent);
		commentService.createComment(comment, cookieManager.getCurrentUserId());
		
		PostRelationDO arel = new PostRelationDO();
		arel.setPostId(postId);
		arel.setRelatedId(comment.getId());
		arel.setRelation(RelationConstants.REGULAR);
		arel.setRelatedType("Comment");
		postService.createPostRelation(arel, cookieManager.getCurrentUserId());
		
		CommentRelationDO grel = new CommentRelationDO();
		grel.setCommentId(comment.getId());
		grel.setRelatedId(postId);
		grel.setRelation(RelationConstants.REGULAR);
		grel.setRelatedType("Post");
		commentService.createCommentRelation(cookieManager.getCurrentUserId(), grel);
		
		return null;
	}
}
