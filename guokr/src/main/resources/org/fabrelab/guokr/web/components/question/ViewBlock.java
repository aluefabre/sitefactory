package org.fabrelab.guokr.web.components.question;

import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.Link;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.fabrelab.guokr.web.pages.Login;
import org.fabrelab.guokr.web.services.MyCookieManager;
import org.fabrelab.sitefactory.dal.dataobject.QuestionDO;
import org.fabrelab.sitefactory.dal.dataobject.UserDO;
import org.fabrelab.sitefactory.exception.NoPermissionException;
import org.fabrelab.sitefactory.service.QuestionService;
import org.fabrelab.sitefactory.service.UserService;

public class ViewBlock {

	@Property
	@Parameter(required = true, allowNull=false)
	private QuestionDO question;

	@Inject
	private MyCookieManager cookieManager;

	@Inject
	private PageRenderLinkSource pageRenderLinkSource;
	
	@Inject
	private QuestionService questionService;

	@Inject
	private UserService userService;

	public UserDO getCreator(){
		return userService.getUserById(question.getCreatorId());
	}
	
	Link onActionFromDelete(EventContext context) throws NoPermissionException {
		if(cookieManager.getCurrentUserId()==null){
			return pageRenderLinkSource.createPageRenderLink(Login.class);
		}
		Long questionId =  context.get(Long.class, 0);
		Long currentUserId = cookieManager.getCurrentUserId();
		questionService.deleteQuestionById(currentUserId, questionId);
		return null;
	}
	
}
