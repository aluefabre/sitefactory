package org.fabrelab.guokr.web.pages.answer;

import java.util.List;

import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.Link;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.fabrelab.guokr.web.pages.Login;
import org.fabrelab.guokr.web.services.MyCookieManager;
import org.fabrelab.sitefactory.constants.RelationConstants;
import org.fabrelab.sitefactory.dal.dataobject.AnswerDO;
import org.fabrelab.sitefactory.dal.dataobject.GroupDO;
import org.fabrelab.sitefactory.dal.dataobject.GroupRelationDO;
import org.fabrelab.sitefactory.exception.NoPermissionException;
import org.fabrelab.sitefactory.service.AnswerService;
import org.fabrelab.sitefactory.service.GroupService;
import org.fabrelab.sitefactory.service.UserService;

public class View {

	@Inject 
	private AnswerService answerService;

	@Inject 
	private UserService userService;
	
	@Property
	private AnswerDO answer;
	
	@Inject 
	private MyCookieManager cookieManager;
	
	@Inject
	private PageRenderLinkSource pageRenderLinkSource;

	private Boolean onActivate(EventContext context) {
		Long answerId = context.get(Long.class, 0);
		answer = answerService.findByPrimaryKey(answerId);
		return true;	
	}
	
	Long onPassivate() {
		return answer.getId();
	}
	
	Link onActionFromDelete(EventContext context) throws NoPermissionException {
		if(cookieManager.getCurrentUserId()==null){
			return pageRenderLinkSource.createPageRenderLink(Login.class);
		}
		Long answerId =  context.get(Long.class, 0);
		AnswerDO answer = answerService.findByPrimaryKey(answerId);
		Long currentUserId = cookieManager.getCurrentUserId();
		answerService.deleteAnswerById(currentUserId, answerId);
		
		Link link = pageRenderLinkSource.createPageRenderLinkWithContext(org.fabrelab.guokr.web.pages.user.View.class, answer.getCreatorId());
		return link;
	}
}
