package org.fabrelab.guokr.web.pages.user.answer;

import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.fabrelab.guokr.web.services.MyCookieManager;
import org.fabrelab.pagekit.PageInfo;
import org.fabrelab.sitefactory.dal.dataobject.AnswerDO;
import org.fabrelab.sitefactory.dal.dataobject.UserDO;
import org.fabrelab.sitefactory.service.AnswerService;
import org.fabrelab.sitefactory.service.UserService;

public class List {

	@Inject
	private AnswerService answerService;

	@Inject
	private UserService userService;

	@Property
	private UserDO targetUser;
	
	@Property
	private AnswerDO answer;
	
	@Property
	private Integer pageNo;

	@Inject
	private MyCookieManager cookieManager;

	@Inject
	private PageRenderLinkSource pageRenderLinkSource;
	
	private Boolean onActivate(EventContext context) {
		Long targetUserId = context.get(Long.class, 0);
		targetUser = userService.getUserById(targetUserId);
		pageNo=0;
		if(context.getCount()>1){
			this.pageNo = context.get(Integer.class, 1);
		}
		return true;
	}

	Object[] onPassivate() {
		return  new Object[]{targetUser.getId(), pageNo};
	}
	
	public java.util.List<AnswerDO> getAnswers(){
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageSize(20);
		pageInfo.setPageStart(20 * pageNo);
		AnswerDO answerDO = new AnswerDO();
		answerDO.setCreatorId(targetUser.getId());
		return answerService.pageByExample(answerDO, pageInfo);
	}
	
}
