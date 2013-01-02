package org.fabrelab.guokr.web.components.article.comment;

import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.Link;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.fabrelab.guokr.web.pages.Login;
import org.fabrelab.guokr.web.services.MyCookieManager;
import org.fabrelab.sitefactory.constants.RelationConstants;
import org.fabrelab.sitefactory.dal.dataobject.ArticleDO;
import org.fabrelab.sitefactory.dal.dataobject.ArticleRelationDO;
import org.fabrelab.sitefactory.dal.dataobject.CommentDO;
import org.fabrelab.sitefactory.dal.dataobject.CommentRelationDO;
import org.fabrelab.sitefactory.service.ArticleService;
import org.fabrelab.sitefactory.service.CommentService;
import org.fabrelab.sitefactory.service.UserService;

public class CreateBlock {

	@Property
	@Parameter(required = true, allowNull=false)
	private ArticleDO targetArticle;	
	
	@Inject
	private ArticleService articleService;
	
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
		Long articleId = context.get(Long.class, 0);
		CommentDO comment = new CommentDO();
		comment.setContent(commentContent);
		commentService.createComment(comment, cookieManager.getCurrentUserId());
		
		ArticleRelationDO arel = new ArticleRelationDO();
		arel.setArticleId(articleId);
		arel.setRelatedId(comment.getId());
		arel.setRelation(RelationConstants.REGULAR);
		arel.setRelatedType("Comment");
		articleService.createArticleRelation(arel, cookieManager.getCurrentUserId());
		
		CommentRelationDO grel = new CommentRelationDO();
		grel.setCommentId(comment.getId());
		grel.setRelatedId(articleId);
		grel.setRelation(RelationConstants.REGULAR);
		grel.setRelatedType("Article");
		commentService.createCommentRelation(cookieManager.getCurrentUserId(), grel);
		
		return null;
	}
}
