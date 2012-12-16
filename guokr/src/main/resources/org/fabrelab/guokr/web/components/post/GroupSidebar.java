package org.fabrelab.guokr.web.components.post;

import java.util.List;

import org.apache.tapestry5.annotations.Parameter;
import org.apache.tapestry5.annotations.Property;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.fabrelab.sitefactory.dal.dataobject.GroupDO;
import org.fabrelab.sitefactory.dal.dataobject.GroupRelationDO;
import org.fabrelab.sitefactory.dal.dataobject.PostDO;
import org.fabrelab.sitefactory.service.GroupService;

public class GroupSidebar {

	@Property
	@Parameter(required = true, allowNull=false)
	private PostDO post;
	
	@Inject 
	private GroupService groupService;
	
	public GroupDO getTargetGroup(){
		GroupRelationDO groupRelationDO = new GroupRelationDO();
		groupRelationDO.setRelatedId(post.getId());
		groupRelationDO.setRelatedType("Post");
		List<GroupDO> list = groupService.listByRelation(groupRelationDO);
		if(list.size()>=1){
			return list.get(0);
		}
		return null;
	}
	
}
