package org.fabrelab.sitefactory.event.handler;

import java.util.List;

import org.fabrelab.pagekit.PageInfo;
import org.fabrelab.sitefactory.dal.dao.ArticleRelationDAO;
import org.fabrelab.sitefactory.dal.dataobject.ArticleDO;
import org.fabrelab.sitefactory.dal.dataobject.ArticleRelationDO;
import org.fabrelab.sitefactory.dal.dataobject.UserDO;
import org.fabrelab.sitefactory.event.model.DeleteArticleEvent;
import org.fabrelab.sitefactory.event.model.DeleteEntityEvent;
import org.fabrelab.sitefactory.event.model.Event;
import org.fabrelab.sitefactory.event.model.NewArticleEvent;
import org.fabrelab.sitefactory.service.ArticleService;
import org.fabrelab.sitefactory.service.UserService;

public class ArticleEventHandler extends EventHandler {
	
	ArticleService articleService;

	ArticleRelationDAO articleRelationDAO;
	
	UserService userService;
	
	@Override
	public void onEvent(Event event) {
		if(event instanceof DeleteEntityEvent){
			DeleteEntityEvent deleteEntityEvent = (DeleteEntityEvent)event;
			ArticleRelationDO example = new ArticleRelationDO();
			example.setRelatedId(deleteEntityEvent.getEntityId());
			example.setRelatedType(deleteEntityEvent.getEntityType());
			articleRelationDAO.deleteByExample(example );
		}
		
		if(event instanceof DeleteArticleEvent){
			DeleteArticleEvent deleteEvent = (DeleteArticleEvent)event;
			ArticleRelationDO example = new ArticleRelationDO();
			example.setArticleId(deleteEvent.getEntityId());
			articleRelationDAO.deleteByExample(example);
		}

		if(event instanceof NewArticleEvent){
			handleNewArticleEvent((NewArticleEvent)event);
		}
	}

	private void handleNewArticleEvent(NewArticleEvent event) {
		Long articleId = event.getArticleId();
		ArticleDO article = articleService.findByPrimaryKey(articleId);
		PageInfo page = new PageInfo();
		page.setPageSize(Integer.MAX_VALUE);
		page.setPageStart(0);
		List<UserDO> followers = userService.getFollowMeUsers(article.getCreatorId(), page);
		for(UserDO follower : followers){
			ArticleRelationDO anu = new ArticleRelationDO();
			anu.setArticleId(articleId);
			anu.setRelatedId(follower.getId());
			anu.setRelatedType("User");
			anu.setRelation("FOLLOW");
			articleService.createArticleRelation(anu, follower.getId());
		}
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setArticleRelationDAO(ArticleRelationDAO articleRelationDAO) {
		this.articleRelationDAO = articleRelationDAO;
	}
}
