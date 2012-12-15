package org.fabrelab.sitefactory.service;

import java.util.Date;
import java.util.List;

import org.fabrelab.sitefactory.dal.dao.ArticleDAO;
import org.fabrelab.sitefactory.dal.dao.ArticleRelationDAO;
import org.fabrelab.sitefactory.dal.dao.TextDAO;
import org.fabrelab.sitefactory.dal.dao.impl.ArticleDAOImpl;
import org.fabrelab.sitefactory.dal.dataobject.ArticleDO;
import org.fabrelab.sitefactory.dal.dataobject.ArticleRelationDO;
import org.fabrelab.sitefactory.dal.dataobject.TextDO;
import org.fabrelab.sitefactory.deo.ArticleEO;
import org.fabrelab.sitefactory.event.model.DeleteArticleEvent;
import org.fabrelab.sitefactory.event.model.NewArticleEvent;
import org.fabrelab.sitefactory.event.service.EventService;
import org.fabrelab.sitefactory.exception.NoPermissionException;
import org.fabrelab.sitefactory.util.LongUtils;
import org.springframework.beans.BeanUtils;

public class ArticleService extends ArticleDAOImpl {
 
	protected TextDAO textDAO;
	
	protected ArticleDAO articleDAO;
	protected ArticleRelationDAO articleRelationDAO;
	protected EventService eventService;
	
	public ArticleEO findExtendedArticle(Long articleId){
		ArticleDO article = findByPrimaryKey(articleId);
		ArticleEO result = new ArticleEO();
		BeanUtils.copyProperties(article, result);
		
		TextDO textDo = textDAO.findByPrimaryKey(article.getContentId());
		result.setContent(textDo.getContent());
		return result;
	}
	
	public void createArticle(ArticleEO article, Long userId) {
		article.setCreatorId(userId);
		article.setModifierId(userId);

		article.setGmtCreate(new Date());
		article.setGmtModify(new Date());
		
		articleDAO.insert(article);
		
		TextDO textDo = new TextDO();
		textDo.setContent(article.getContent());
		textDo.setCreatorId(userId);
		textDo.setModifierId(userId);
		textDo.setEntityId(article.getId());
		textDo.setGmtCreate(new Date());
		textDo.setGmtModify(new Date());
		
		textDAO.insert(textDo);
		
		article.setContentId(textDo.getId());
		articleDAO.update(article);
		
		eventService.fireEvent(new NewArticleEvent(article.getId()));
	}
		
	public void updateArticle(ArticleEO article, Long operator) throws NoPermissionException{
		if(!LongUtils.equalsAndNotNull(article.getCreatorId(), operator)){
			throw new NoPermissionException();
		}
		article.setModifierId(operator);
		articleDAO.update(article);
		
		TextDO textDo = new TextDO();
		textDo.setId(article.getContentId());
		textDo.setModifierId(operator);
		textDo.setContent(article.getContent());
		textDAO.update(textDo);
	}

	public boolean deleteArticleById(Long operator, Long articleId) throws NoPermissionException{
		ArticleDO article = findByPrimaryKey(articleId);
//		if(!LongUtils.equalsAndNotNull(article.getCreatorId(), operator)){
//			throw new NoPermissionException();
//		}
		articleDAO.deleteByPrimaryKey(articleId);
		eventService.fireEvent(new DeleteArticleEvent(articleId));
		return true;
	}

	public void createArticleRelation(ArticleRelationDO relation, Long userId) {
		relation.setCreatorId(userId);
		relation.setModifierId(userId);
		articleRelationDAO.insert(relation);
	}
	
	public void setArticleDAO(ArticleDAO articleDAO) {
		this.articleDAO = articleDAO;
	}

	public void setArticleRelationDAO(ArticleRelationDAO articleRelationDAO) {
		this.articleRelationDAO = articleRelationDAO;
	}
	
	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}

	public void setTextDAO(TextDAO textDAO) {
		this.textDAO = textDAO;
	}

	public List<ArticleRelationDO> findRelationByExample(ArticleRelationDO relation, Long currentUserId) {
		return articleRelationDAO.listByExample(relation);
	}

	public void updateRelation(ArticleRelationDO relation) {
		articleRelationDAO.update(relation);
	}

	public void deleteRelationByExample(ArticleRelationDO arel, Long currentUserId) {
		articleRelationDAO.deleteByExample(arel);
	}
}
