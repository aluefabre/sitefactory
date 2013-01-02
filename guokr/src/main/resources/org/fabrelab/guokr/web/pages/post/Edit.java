package org.fabrelab.guokr.web.pages.post;

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
import org.fabrelab.sitefactory.dal.dataobject.PostDO;
import org.fabrelab.sitefactory.exception.NoPermissionException;
import org.fabrelab.sitefactory.service.GroupService;
import org.fabrelab.sitefactory.service.PostService;
import org.fabrelab.sitefactory.service.UserService;
import org.fabrelab.sitefactory.util.LongUtils;

public class Edit {
	@Inject
	private PostService postService;

	@Inject
	private UserService userService;

	@Inject 
	private GroupService groupService;
	
	@Property
	private PostDO post;

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
		Long postId = context.get(Long.class, 0);
		post = postService.findByPrimaryKey(postId);
		if(!LongUtils.equalsAndNotNull(post.getCreatorId(), cookieManager.getCurrentUserId())){
			return pageRenderLinkSource.createPageRenderLink(Login.class);
		}
		title = post.getTitle();
		content = post.getContent();
		return null;
	}

	Long onPassivate() {
		return post.getId();
	}
	
	public GroupDO getTargetGroup(){
		GroupRelationDO groupRelationDO = new GroupRelationDO();
		groupRelationDO.setRelatedId(post.getId());
		groupRelationDO.setRelatedType("Post");
		groupRelationDO.setRelation(RelationConstants.REGULAR);
		List<GroupDO> list =groupService.listByRelation(groupRelationDO);
		if(list.size()>=1){
			return list.get(0);
		}
		return null;
	}
	
	public List<GroupDO> getPostGroups(){
		GroupRelationDO groupRelationDO = new GroupRelationDO();
		groupRelationDO.setRelatedId(post.getId());
		groupRelationDO.setRelatedType("Post");
		groupRelationDO.setRelation(RelationConstants.REGULAR);
		return groupService.listByRelation(groupRelationDO);
	}
	
	public Link onSuccess() throws NoPermissionException {
		if(cookieManager.getCurrentUserId()==null){
			return pageRenderLinkSource.createPageRenderLink(Login.class);
		}
		
		if(!LongUtils.equalsAndNotNull(post.getCreatorId(), cookieManager.getCurrentUserId())){
			return pageRenderLinkSource.createPageRenderLink(Login.class);
		}
		post.setContent(content);
		post.setTitle(title);
		postService.updatePost(post,cookieManager.getCurrentUserId());
		return pageRenderLinkSource.createPageRenderLinkWithContext(View.class, post.getId());
	}

}
