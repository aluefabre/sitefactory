package org.fabrelab.guokr.web.components.answer;

import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.Link;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.fabrelab.guokr.web.pages.Login;
import org.fabrelab.guokr.web.services.MyCookieManager;
import org.fabrelab.sitefactory.dal.dataobject.AnswerDO;
import org.fabrelab.sitefactory.dal.dataobject.UserDO;
import org.fabrelab.sitefactory.exception.NoPermissionException;
import org.fabrelab.sitefactory.service.AnswerService;
import org.fabrelab.sitefactory.service.UserService;

public class ViewBlock {

	@Property
	@Parameter(required = true, allowNull=false)
	private AnswerDO answer;	
	
	@Inject
	private AnswerService answerService;

	@Inject
	private UserService userService;
	
	@Inject
	private MyCookieManager cookieManager;

	@Inject
	private PageRenderLinkSource pageRenderLinkSource;
	
	public UserDO getCreator(){
		return userService.getUserById(answer.getCreatorId());
	}
	
	Link onActionFromDelete(EventContext context) throws NoPermissionException {
		if(cookieManager.getCurrentUserId()==null){
			return pageRenderLinkSource.createPageRenderLink(Login.class);
		}
		Long answerId =  context.get(Long.class, 0);
		Long currentUserId = cookieManager.getCurrentUserId();
		answerService.deleteAnswerById(currentUserId, answerId);
		return null;
	}
}
