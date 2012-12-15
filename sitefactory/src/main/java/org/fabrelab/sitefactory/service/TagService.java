package org.fabrelab.sitefactory.service;

import java.util.Date;
import java.util.List;

import org.fabrelab.pagekit.PageInfo;
import org.fabrelab.sitefactory.dal.dao.RoleDAO;
import org.fabrelab.sitefactory.dal.dao.TagDAO;
import org.fabrelab.sitefactory.dal.dao.TagRelationDAO;
import org.fabrelab.sitefactory.dal.dataobject.TagDO;
import org.fabrelab.sitefactory.dal.dataobject.TagRelationDO;
import org.fabrelab.sitefactory.event.model.DeleteTagEvent;
import org.fabrelab.sitefactory.event.service.EventService;
import org.fabrelab.sitefactory.exception.NoPermissionException;

public class TagService {

	private TagDAO TagDODAO;

	private TagRelationDAO tagRelationDAO;
	
	private UserService userService;

	protected RoleDAO roleDAO;
	
	protected EventService eventService;
	
	public void createTag(Long creatorId, TagDO bean) {
		bean.setCreatorId(creatorId);
		bean.setModifierId(creatorId);
		bean.setGmtCreate(new Date());
		bean.setGmtModify(new Date());
		TagDODAO.insert(bean);
	}
	
	public List<TagDO> listTagByExample(PageInfo page, TagDO example){
		return TagDODAO.pageByExample(example, page);
	}
	
	public List<TagDO> listTagByExample(TagDO example){
		return TagDODAO.listByExample(example);
	}
	
	public void updateTag(Long operatorId, TagDO bean) {
		bean.setModifierId(operatorId);
		TagDODAO.update(bean);
	}

	public TagDO getTagById(Long TagDOId) {
		return TagDODAO.findByPrimaryKey(TagDOId);
	}

	public void createTagRelation(TagRelationDO tagDORelation) {
		tagRelationDAO.insert(tagDORelation);
	}
	
	public List<TagDO> listTagsByUserId(Long userId, PageInfo page) {
		TagRelationDO grelation = new TagRelationDO();
		grelation.setRelatedId(userId);
		grelation.setRelatedType("User");
		return TagDODAO.pageByRelation(grelation, page);
	}
	
	public List<TagDO> listTagsByRelation(Long relatedId, String relatedType, String relation) {
		TagRelationDO grelation = new TagRelationDO();
		grelation.setRelatedId(relatedId);
		grelation.setRelatedType(relatedType);
		grelation.setRelation(relation);
		return TagDODAO.listByRelation(grelation);
	}

	public void deleteTagById(Long currentUserId, Long TagDOId) throws NoPermissionException {

		TagDODAO.deleteByPrimaryKey(TagDOId);
		eventService.fireEvent(new DeleteTagEvent(TagDOId));
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setTagRelationDAO(TagRelationDAO TagDORelationDAO) {
		this.tagRelationDAO = TagDORelationDAO;
	}

	public void setTagDAO(TagDAO TagDODAO) {
		this.TagDODAO = TagDODAO;
	}

	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}

	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}

}
