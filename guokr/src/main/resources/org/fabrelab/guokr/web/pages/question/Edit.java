package org.fabrelab.guokr.web.pages.question;

import java.util.List;

import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.Link;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.fabrelab.guokr.web.constants.RelationConstants;
import org.fabrelab.guokr.web.pages.Login;
import org.fabrelab.guokr.web.services.MyCookieManager;
import org.fabrelab.sitefactory.dal.dataobject.GroupDO;
import org.fabrelab.sitefactory.dal.dataobject.GroupRelationDO;
import org.fabrelab.sitefactory.dal.dataobject.QuestionDO;
import org.fabrelab.sitefactory.exception.NoPermissionException;
import org.fabrelab.sitefactory.service.GroupService;
import org.fabrelab.sitefactory.service.QuestionService;
import org.fabrelab.sitefactory.service.UserService;
import org.fabrelab.sitefactory.util.LongUtils;

public class Edit {
	@Inject
	private QuestionService questionService;

	@Inject
	private UserService userService;

	@Inject 
	private GroupService groupService;
	
	@Property
	private QuestionDO question;

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
		Long questionId = context.get(Long.class, 0);
		question = questionService.findByPrimaryKey(questionId);
		if(!LongUtils.equalsAndNotNull(question.getCreatorId(), cookieManager.getCurrentUserId())){
			return pageRenderLinkSource.createPageRenderLink(Login.class);
		}
		title = question.getTitle();
		content = question.getContent();
		return null;
	}

	Long onPassivate() {
		return question.getId();
	}
	
	public GroupDO getTargetGroup(){
		GroupRelationDO groupRelationDO = new GroupRelationDO();
		groupRelationDO.setRelatedId(question.getId());
		groupRelationDO.setRelatedType("Question");
		groupRelationDO.setRelation(RelationConstants.REGULAR);
		List<GroupDO> list =groupService.listByRelation(groupRelationDO);
		if(list.size()>=1){
			return list.get(0);
		}
		return null;
	}
	
	public List<GroupDO> getQuestionGroups(){
		GroupRelationDO groupRelationDO = new GroupRelationDO();
		groupRelationDO.setRelatedId(question.getId());
		groupRelationDO.setRelatedType("Question");
		groupRelationDO.setRelation(RelationConstants.REGULAR);
		return groupService.listByRelation(groupRelationDO);
	}
	
	public Link onSuccess() throws NoPermissionException {
		if(cookieManager.getCurrentUserId()==null){
			return pageRenderLinkSource.createPageRenderLink(Login.class);
		}
		
		if(!LongUtils.equalsAndNotNull(question.getCreatorId(), cookieManager.getCurrentUserId())){
			return pageRenderLinkSource.createPageRenderLink(Login.class);
		}
		question.setContent(content);
		question.setTitle(title);
		questionService.updateQuestion(question,cookieManager.getCurrentUserId());
		return pageRenderLinkSource.createPageRenderLinkWithContext(View.class, question.getId());
	}

}
