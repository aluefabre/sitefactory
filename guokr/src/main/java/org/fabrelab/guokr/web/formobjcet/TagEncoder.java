package org.fabrelab.guokr.web.formobjcet;

import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.ValueEncoderFactory;
import org.fabrelab.sitefactory.dal.dao.TagDAO;
import org.fabrelab.sitefactory.dal.dataobject.TagDO;

public class TagEncoder implements ValueEncoder<TagDO>, ValueEncoderFactory<TagDO> { 

    @Inject
    private TagDAO tagDAO;

    public String toClient(TagDO value) {
        // return the given object's ID
        return String.valueOf(value.getId()); 
    }

    public TagDO toValue(String id) { 
        // find the color object of the given ID in the database
        return tagDAO.findByPrimaryKey(Long.parseLong(id)); 
    }

    public ValueEncoder<TagDO> create(Class<TagDO> type) {
        return this; 
    }
} 