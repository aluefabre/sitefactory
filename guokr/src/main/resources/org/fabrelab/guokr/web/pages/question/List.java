package org.fabrelab.guokr.web.pages.question;

import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.fabrelab.guokr.web.services.MyCookieManager;
import org.fabrelab.pagekit.PageInfo;
import org.fabrelab.sitefactory.dal.dataobject.QuestionDO;
import org.fabrelab.sitefactory.service.QuestionService;
import org.fabrelab.sitefactory.service.UserService;

public class List {
	
	@Inject 
	private UserService userService;
	
	@Property
	private QuestionDO question;
	
	@Inject
	private QuestionService questionService;

	@Inject
	private MyCookieManager cookieManager;

	@Inject
	private PageRenderLinkSource pageRenderLinkSource;
	
	@Property
	private Integer pageNo;
	
	private Boolean onActivate(EventContext context) {
		if(context.getCount()>0){
			this.pageNo =  context.get(Integer.class, 0);
		}else{
			pageNo = 0;
		}
		return true;	
	}
	
	Integer onPassivate() {
		return pageNo;
	}
	
	public java.util.List<QuestionDO> getQuestions() {
		PageInfo pageInfo = new PageInfo();
		pageInfo.setPageSize(20);
		pageInfo.setPageStart(20 * pageNo);
		QuestionDO relation = new QuestionDO();
		return  questionService.pageByExample(relation, pageInfo);
	}
	
}
