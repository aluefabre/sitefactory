package org.fabrelab.sitefactory.service;

import java.util.Date;
import java.util.List;

import org.fabrelab.sitefactory.dal.dao.SiteDAO;
import org.fabrelab.sitefactory.dal.dao.SitePermissionDAO;
import org.fabrelab.sitefactory.dal.dao.SiteRelationDAO;
import org.fabrelab.sitefactory.dal.dao.RoleDAO;
import org.fabrelab.sitefactory.dal.dao.RoleRelationDAO;
import org.fabrelab.sitefactory.dal.dao.impl.SiteDAOImpl;
import org.fabrelab.sitefactory.dal.dataobject.SiteDO;
import org.fabrelab.sitefactory.dal.dataobject.SitePermissionDO;
import org.fabrelab.sitefactory.dal.dataobject.SiteRelationDO;
import org.fabrelab.sitefactory.dal.dataobject.RoleDO;
import org.fabrelab.sitefactory.dal.dataobject.RoleRelationDO;
import org.fabrelab.sitefactory.event.model.DeleteSiteEvent;
import org.fabrelab.sitefactory.event.service.EventService;
import org.fabrelab.sitefactory.exception.NoPermissionException;

public class SiteService extends SiteDAOImpl{

	private SiteDAO siteDAO;

	private SiteRelationDAO siteRelationDAO;

	private SitePermissionDAO sitePermissionDAO;

	protected RoleRelationDAO roleRelationDAO;
	
	private UserService userService;

	protected RoleDAO roleDAO;
	
	protected EventService eventService;
	
	public void createSite(Long operatorId, SiteDO bean) {
		bean.setCreatorId(operatorId);
		bean.setModifierId(operatorId);
		bean.setGmtCreate(new Date());
		bean.setGmtModify(new Date());
		siteDAO.insert(bean);
	}
	
	public void updateSite(Long operatorId, SiteDO bean) {
		bean.setModifierId(operatorId);
		siteDAO.update(bean);
	}
	public void createSiteRelation(Long operatorId, SiteRelationDO siteRelation) {
		siteRelationDAO.insert(siteRelation);
	}
	
	public void deleteSiteById(Long operator, Long siteId) throws NoPermissionException {
		siteDAO.deleteByPrimaryKey(siteId);
		eventService.fireEvent(new DeleteSiteEvent(siteId));
	}

	public boolean checkPermission(Long targetUserId, Long siteId, String permission){
		SitePermissionDO example = new SitePermissionDO();
		example.setSiteId(siteId);
		example.setPermission(permission);
		List<SitePermissionDO> listByExample = sitePermissionDAO.listByExample(example);
		for (SitePermissionDO sitePermission : listByExample) {
			String userCondition = sitePermission.getUserCondition();
			if(matchCondition(targetUserId, siteId, userCondition)){
				return true;
			}
		}
		return false;
	}
	
	private boolean matchCondition(Long targetUserId, Long siteId, String userCondition) {
		if("everyone".equals(userCondition)){
			return true;
		}
		if("creator".equals(userCondition)){
			SiteDO site = siteDAO.findByPrimaryKey(siteId);
			if(site.getCreatorId() == targetUserId){
				return true;
			}
		}
		if(userCondition.startsWith("relation-")){
			String[] parts = userCondition.split("-");
			String relation = parts[1];
			SiteRelationDO example = new SiteRelationDO();
			example.setSiteId(siteId);
			example.setRelatedId(targetUserId);
			example.setRelatedType("User");
			example.setRelation(relation);
			Integer count = siteRelationDAO.countByExample(example);
			if(count>0){
				return true;
			}
		}
		if(userCondition.startsWith("role-")){
			String[] parts = userCondition.split("-");
			String roleName = parts[1];
			RoleDO roleExample = new RoleDO();
			roleExample.setName(roleName);
			List<RoleDO> roles = roleDAO.listByExample(roleExample);
			if(roles!=null && roles.size()==1){
				RoleRelationDO example = new RoleRelationDO();
				example.setRoleId(roles.get(0).getId());
				example.setRelatedId(targetUserId);
				example.setRelatedType("User");
				example.setRelation("regular");
				Integer count = roleRelationDAO.countByExample(example);
				if(count>0){
					return true;
				}
			}
		}
		return false;
	}

	public UserService getUserService() {
		return userService;
	}

	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	public void setSiteRelationDAO(SiteRelationDAO siteRelationDAO) {
		this.siteRelationDAO = siteRelationDAO;
	}

	public void setSiteDAO(SiteDAO siteDAO) {
		this.siteDAO = siteDAO;
	}

	public void setEventService(EventService eventService) {
		this.eventService = eventService;
	}

	public void setSitePermissionDAO(SitePermissionDAO sitePermissionDAO) {
		this.sitePermissionDAO = sitePermissionDAO;
	}

	public void setRoleRelationDAO(RoleRelationDAO roleRelationDAO) {
		this.roleRelationDAO = roleRelationDAO;
	}

	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}

	public List<SiteRelationDO> findRelationByExample(SiteRelationDO grel, Long currentUserId) {
		return siteRelationDAO.listByExample(grel);
	}

	public void updateRelation(SiteRelationDO grel) {
		siteRelationDAO.update(grel);
	}

	public void deleteRelationByExample(SiteRelationDO grel, Long currentUserId) {
		siteRelationDAO.deleteByExample(grel);
	}

}
