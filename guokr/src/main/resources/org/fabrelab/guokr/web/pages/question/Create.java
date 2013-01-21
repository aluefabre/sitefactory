package org.fabrelab.guokr.web.pages.question;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.tapestry5.EventConstants;
import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.Link;
import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.annotations.Import;
import org.apache.tapestry5.annotations.OnEvent;
import org.apache.tapestry5.annotations.Persist;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.fabrelab.guokr.model.Person;
import org.fabrelab.guokr.model.Phone;
import org.fabrelab.guokr.web.pages.Login;
import org.fabrelab.guokr.web.services.MyCookieManager;
import org.fabrelab.sitefactory.dal.dataobject.QuestionDO;
import org.fabrelab.sitefactory.service.QuestionService;


@Import(library={"context:static/js/question.js"})
public class Create {

	
	@Property
	private String title ;
	
	@Property
	private String tags ;
	
	@Property
	private String addtag ;
	
	@Property
	private String content;

	@Inject
	private QuestionService questionService;

	@Inject
	private MyCookieManager cookieManager;

	@Inject
	private PageRenderLinkSource pageRenderLinkSource;

	@OnEvent(EventConstants.ACTIVATE)
	void init() {
		if (person == null)
			person = new Person();
	}

	private Link onActivate(EventContext context) {
		if (cookieManager.getCurrentUserId() == null) {
			return pageRenderLinkSource.createPageRenderLink(Login.class);
		}
		return null;
	}
	
	Object[] onPassivate() {
		return new Object[]{};
	}
	
	public Link onSuccess(EventContext context) {
		if (cookieManager.getCurrentUserId() == null) {
			return pageRenderLinkSource.createPageRenderLink(Login.class);
		}
		QuestionDO question = new QuestionDO();
		question.setContent(content);
		question.setTitle(title);
		question.setType("POST");
		questionService.createQuestion(question, cookieManager.getCurrentUserId());
		
		return pageRenderLinkSource.createPageRenderLinkWithContext(View.class, question.getId());
	}

	List<String> onProvideCompletionsFromAddTag(String partial) {
		List<String> result = new ArrayList<String>();
		result.add("tetss");
		result.add("asdasdasd");
		return result;
	}
	
	
	@Property
	private Phone phone;
	
	@Property
	@Persist
	private Person person;
	 
	public ValueEncoder<Phone> getPhoneEncoder() {
		return new ValueEncoder<Phone>() {
			public String toClient(Phone value) {
				return value.getNumber();
			}

			public Phone toValue(String clientValue) {
				for (Phone currentPhone : person.getPhones()) {
					if (currentPhone.getNumber() != null
							&& clientValue.equals(currentPhone.getNumber()))
						return currentPhone;
				}
				return null;
			}
		};
	}

	@OnEvent(value = EventConstants.ADD_ROW, component = "phones")
	public Object onAddRowFromPhones() {
		Phone phone = new Phone();
		phone.setNumber("");
		phone.setStartDate(new Date());
		person.getPhones().add(phone);
		phone.setPerson(person);
		return phone;
	}

	@OnEvent(value = EventConstants.REMOVE_ROW, component = "phones")
	void onRemoveRowFromPhones(Phone phoneToDelete) {
		person.getPhones().remove(phoneToDelete);
	}
}
