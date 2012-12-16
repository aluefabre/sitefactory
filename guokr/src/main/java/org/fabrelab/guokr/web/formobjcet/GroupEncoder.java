package org.fabrelab.guokr.web.formobjcet;

import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.ValueEncoderFactory;
import org.fabrelab.sitefactory.dal.dataobject.GroupDO;
import org.fabrelab.sitefactory.service.GroupService;

public class GroupEncoder implements ValueEncoder<GroupDO>, ValueEncoderFactory<GroupDO> { 

    @Inject
    private GroupService groupService;

    public String toClient(GroupDO value) {
        // return the given object's ID
        return String.valueOf(value.getId()); 
    }

    public GroupDO toValue(String id) { 
        // find the color object of the given ID in the database
        return groupService.findByPrimaryKey(Long.parseLong(id)); 
    }

    public ValueEncoder<GroupDO> create(Class<GroupDO> type) {
        return this; 
    }
} 