package org.fabrelab.guokr.web.formobjcet;

import org.apache.tapestry5.ValueEncoder;
import org.apache.tapestry5.ioc.annotations.Inject;
import org.apache.tapestry5.services.ValueEncoderFactory;
import org.fabrelab.sitefactory.dal.dataobject.SiteDO;
import org.fabrelab.sitefactory.service.SiteService;

public class SiteEncoder implements ValueEncoder<SiteDO>, ValueEncoderFactory<SiteDO> { 

    @Inject
    private SiteService siteService;

    public String toClient(SiteDO value) {
        // return the given object's ID
        return String.valueOf(value.getId()); 
    }

    public SiteDO toValue(String id) { 
        // find the color object of the given ID in the database
        return siteService.findByPrimaryKey(Long.parseLong(id)); 
    }

    public ValueEncoder<SiteDO> create(Class<SiteDO> type) {
        return this; 
    }
} 