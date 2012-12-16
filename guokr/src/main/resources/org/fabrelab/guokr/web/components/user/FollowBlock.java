package org.fabrelab.guokr.web.components.user;

import org.apache.tapestry5.EventContext;
import org.apache.tapestry5.Link;
import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.PageRenderLinkSource;
import org.fabrelab.guokr.web.pages.Login;
import org.fabrelab.guokr.web.services.MyCookieManager;
import org.fabrelab.sitefactory.dal.dataobject.UserDO;
import org.fabrelab.sitefactory.service.UserService;

public class FollowBlock {
	@Property
	@Parameter(required = true, allowNull=false)
	private UserDO targetUser;
	
	@Inject 
	private UserService userService;
	
	@Inject 
	private MyCookieManager cookieManager;
	
	@Inject
	private PageRenderLinkSource pageRenderLinkSource;
	
	public boolean getIsLoggedIn(){
		return cookieManager.getCurrentUserId()!=null;
	}
	
	public boolean getIsIFollow(){
		return userService.isAFollowB(cookieManager.getCurrentUserId(), targetUser.getId());
	}
	
	public boolean getIsFollowMe(){
		return userService.isAFollowB( targetUser.getId(), cookieManager.getCurrentUserId());
	}
	
	public boolean getIsMySelf(){
		return  targetUser.getId().equals(cookieManager.getCurrentUserId());
	}
	
	Link onActionFromAddIFollow(EventContext context){
		if(cookieManager.getCurrentUserId()==null){
			return pageRenderLinkSource.createPageRenderLink(Login.class);
		}
		Long targetUserId= context.get(Long.class, 0);
		Long currentUserId = cookieManager.getCurrentUserId();
		userService.createFollow(currentUserId, targetUserId);
		return null;
	}
	
	Link onActionFromRemoveIFollow(EventContext context){
		if(cookieManager.getCurrentUserId()==null){
			return pageRenderLinkSource.createPageRenderLink(Login.class);
		}
		Long targetUserId= context.get(Long.class, 0);
		Long currentUserId = cookieManager.getCurrentUserId();
		userService.deleteFollow(currentUserId, targetUserId);
		return null;
	}
	
	Link onActionFromRemoveFollowMe(EventContext context) {
		if(cookieManager.getCurrentUserId()==null){
			return pageRenderLinkSource.createPageRenderLink(Login.class);
		}
		Long targetUserId= context.get(Long.class, 0);
		Long currentUserId = cookieManager.getCurrentUserId();
		userService.deleteFollow(targetUserId, currentUserId);
		return null;
	}
}
