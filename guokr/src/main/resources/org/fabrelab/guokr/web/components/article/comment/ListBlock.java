package org.fabrelab.guokr.web.components.article.comment;

import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.fabrelab.pagekit.PageInfo;
import org.fabrelab.sitefactory.constants.RelationConstants;
import org.fabrelab.sitefactory.dal.dataobject.ArticleDO;
import org.fabrelab.sitefactory.dal.dataobject.CommentDO;
import org.fabrelab.sitefactory.dal.dataobject.CommentRelationDO;
import org.fabrelab.sitefactory.service.ArticleService;
import org.fabrelab.sitefactory.service.CommentService;

public class ListBlock {

	@Property
	@Parameter(required = true, allowNull=false)
	private ArticleDO targetArticle;	
	
	@Property
	private Integer pageNo;	
	
	@Inject
	private ArticleService articleService;
	
	@Inject
	private CommentService commentService;

	@Property
	private CommentDO comment;	
	
	public java.util.List<CommentDO> getComments() {
		if(pageNo==null){
			pageNo = 0;
		}
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageSize(20);
		pageInfo.setPageStart(20 * pageNo);
		CommentRelationDO relation = new CommentRelationDO();
		relation.setRelatedId(targetArticle.getId());
		relation.setRelatedType("Article");
		relation.setRelation(RelationConstants.REGULAR);
		return commentService.pageByRelation(relation, pageInfo);
	}
}
