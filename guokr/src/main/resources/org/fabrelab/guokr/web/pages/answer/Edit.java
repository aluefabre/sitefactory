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
import org.fabrelab.sitefactory.dal.dataobject.GroupDO;
import org.fabrelab.sitefactory.dal.dataobject.GroupRelationDO;
import org.fabrelab.sitefactory.dal.dataobject.AnswerDO;
import org.fabrelab.sitefactory.exception.NoPermissionException;
import org.fabrelab.sitefactory.service.GroupService;
import org.fabrelab.sitefactory.service.AnswerService;
import org.fabrelab.sitefactory.service.UserService;
import org.fabrelab.sitefactory.util.LongUtils;

public class Edit {
	@Inject
	private AnswerService answerService;

	@Inject
	private UserService userService;

	@Inject 
	private GroupService groupService;
	
	@Property
	private AnswerDO answer;

	@Inject
	private MyCookieManager cookieManager;

	@Inject
	private PageRenderLinkSource pageRenderLinkSource;

	@Property
	private String title;
	
	@Property
	private String content;
	
	private Link onActivate(EventContext context) {
		if(cookieManager.getCurrentUserId()==null){
			return pageRenderLinkSource.createPageRenderLink(Login.class);
		}
		Long answerId = context.get(Long.class, 0);
		answer = answerService.findByPrimaryKey(answerId);
		if(!LongUtils.equalsAndNotNull(answer.getCreatorId(), cookieManager.getCurrentUserId())){
			return pageRenderLinkSource.createPageRenderLink(Login.class);
		}
		title = answer.getTitle();
		content = answer.getContent();
		return null;
	}

	Long onPassivate() {
		return answer.getId();
	}
	
	public GroupDO getTargetGroup(){
		GroupRelationDO groupRelationDO = new GroupRelationDO();
		groupRelationDO.setRelatedId(answer.getId());
		groupRelationDO.setRelatedType("Answer");
		groupRelationDO.setRelation(RelationConstants.REGULAR);
		List<GroupDO> list =groupService.listByRelation(groupRelationDO);
		if(list.size()>=1){
			return list.get(0);
		}
		return null;
	}
	
	public List<GroupDO> getAnswerGroups(){
		GroupRelationDO groupRelationDO = new GroupRelationDO();
		groupRelationDO.setRelatedId(answer.getId());
		groupRelationDO.setRelatedType("Answer");
		groupRelationDO.setRelation(RelationConstants.REGULAR);
		return groupService.listByRelation(groupRelationDO);
	}
	
	public Link onSuccess() throws NoPermissionException {
		if(cookieManager.getCurrentUserId()==null){
			return pageRenderLinkSource.createPageRenderLink(Login.class);
		}
		
		if(!LongUtils.equalsAndNotNull(answer.getCreatorId(), cookieManager.getCurrentUserId())){
			return pageRenderLinkSource.createPageRenderLink(Login.class);
		}
		answer.setContent(content);
		answer.setTitle(title);
		answerService.updateAnswer(answer,cookieManager.getCurrentUserId());
		return pageRenderLinkSource.createPageRenderLinkWithContext(View.class, answer.getId());
	}

}
