package org.fabrelab.guokr.web.pages.user;

import org.apache.commons.lang.StringUtils;
import org.apache.tapestry5.ComponentResources;
import org.apache.tapestry5.Link;
import org.apache.tapestry5.annotations.Component;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.corelib.components.BeanEditForm;
import org.apache.tapestry5.corelib.components.PasswordField;
import org.apache.tapestry5.corelib.components.TextField;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.fabrelab.guokr.web.formobjcet.UserJoin;
import org.fabrelab.guokr.web.pages.Login;
import org.fabrelab.sitefactory.dal.dataobject.UserDO;
import org.fabrelab.sitefactory.service.UserService;

/**
 * Start page of application newapp.
 */
public class Join {

	@Inject
	private ComponentResources resources;

	@Inject
	private UserService userService;
	
	@Inject
	private PageRenderLinkSource pageRenderLinkSource;
	
	@Component(id = "joinForm")
	private BeanEditForm joinForm; 
	
	@Component
	private TextField email;
	
	@Component
	private PasswordField rePassword;
	
	@Property
	private UserJoin bean;

	public void onValidateForm() {
		UserDO exsitUser = userService.getUserByEmail(bean.getEmail());
		if(exsitUser!=null){
			joinForm.recordError(email, "Email Already Exists!");
		}
		if(!StringUtils.equals(bean.getPassword(), bean.getRePassword())){
			joinForm.recordError(rePassword, "Password Do Not Match!");
		}
	}
	
	public Link onSuccess() {
		
		userService.createUser(bean);
		Link link = pageRenderLinkSource.createPageRenderLink( Login.class);
		link.addParameter("from", "new_join");
		return link;
	}
}
