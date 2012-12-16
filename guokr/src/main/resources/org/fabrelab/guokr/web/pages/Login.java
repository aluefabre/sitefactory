package org.fabrelab.guokr.web.pages;

import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.Link;
import org.apache.tapestry5.annotations.ActivationRequestParameter;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.BeanEditForm;
import org.apache.tapestry5.corelib.components.PasswordField;
import org.apache.tapestry5.corelib.components.TextField;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.fabrelab.guokr.web.formobjcet.UserLogin;
import org.fabrelab.guokr.web.services.MyCookieManager;
import org.fabrelab.sitefactory.dal.dataobject.UserDO;
import org.fabrelab.sitefactory.service.UserService;

/**
 * Start page of application newapp.
 */
public class Login {
	@Inject
	private ComponentResources resources;

	@Inject
	private UserService userService;
	
	@Property
	private UserLogin bean;

	@ActivationRequestParameter(value = "from")
	private String from;
	
	@Component
	private TextField email;
	
	@Component
	private PasswordField password;
	
	@Inject 
	private MyCookieManager cookieManager;
	
	@Inject
	private PageRenderLinkSource pageRenderLinkSource;
	
	@Component(id = "loginForm")
	private BeanEditForm loginForm; 
	
	void onValidateForm() {
		boolean valid = userService.isValid(bean.getEmail(), bean.getPassword());
		if(!valid){
			loginForm.recordError(email, "Email and Password Do Not Match!");
		}
	}
	
	Link onSuccess() {
		UserDO user = userService.getUserByEmail(bean.getEmail());
		cookieManager.setCurrentUserId(user.getId());
		return pageRenderLinkSource.createPageRenderLinkWithContext(
				org.fabrelab.guokr.web.pages.user.View.class, user.getId());
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	
	public boolean getIsFromJoin(){
		return "new_join".equals(from);
	}
}
