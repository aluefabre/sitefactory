package org.fabrelab.guokr.web.pages.question;

import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.Link;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.fabrelab.guokr.web.pages.Login;
import org.fabrelab.guokr.web.services.MyCookieManager;
import org.fabrelab.sitefactory.dal.dataobject.QuestionDO;
import org.fabrelab.sitefactory.exception.NoPermissionException;
import org.fabrelab.sitefactory.service.QuestionService;
import org.fabrelab.sitefactory.service.UserService;

public class View {

	@Inject 
	private QuestionService questionService;

	@Inject 
	private UserService userService;
	
	@Property
	private QuestionDO question;
	
	@Inject 
	private MyCookieManager cookieManager;
	
	@Inject
	private PageRenderLinkSource pageRenderLinkSource;

	private Boolean onActivate(EventContext context) {
		Long questionId = context.get(Long.class, 0);
		question = questionService.findByPrimaryKey(questionId);
		return true;	
	}
	
	Long onPassivate() {
		return question.getId();
	}
	
	Link onActionFromDelete(EventContext context) throws NoPermissionException {
		if(cookieManager.getCurrentUserId()==null){
			return pageRenderLinkSource.createPageRenderLink(Login.class);
		}
		Long questionId =  context.get(Long.class, 0);
		QuestionDO question = questionService.findByPrimaryKey(questionId);
		Long currentUserId = cookieManager.getCurrentUserId();
		questionService.deleteQuestionById(currentUserId, questionId);
		Link link = pageRenderLinkSource.createPageRenderLinkWithContext(org.fabrelab.guokr.web.pages.user.View.class, question.getCreatorId());
		return link;
	}
}
