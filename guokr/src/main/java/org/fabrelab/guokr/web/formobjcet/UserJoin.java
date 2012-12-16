package org.fabrelab.guokr.web.formobjcet;

import java.util.Date;

import org.apache.tapestry5.beaneditor.NonVisual;
import org.apache.tapestry5.beaneditor.ReorderProperties;
import org.apache.tapestry5.beaneditor.Validate;
import org.fabrelab.sitefactory.dal.dataobject.UserDO;

@ReorderProperties(value = "email, password, rePassword, name, profession, company, location")
public class UserJoin extends UserDO {
	
	@Validate("required,minlength=5,maxlength=15")
	private String rePassword;

	public String getRePassword() {
		return rePassword;
	}

	public void setRePassword(String rePassword) {
		this.rePassword = rePassword;
	}
	
	@NonVisual
    public void setId(Long id) {
		super.setId(id);
	}
	
	@NonVisual
	public void setGmtCreate(Date gmtCreate) {
		super.setGmtCreate(gmtCreate);
	}
	
	@NonVisual
	public void setGmtModify(Date gmtModify) {
		super.setGmtModify(gmtModify);
	}
	
	@NonVisual
	public void setCreatorId(Long creatorId) {
		super.setCreatorId(creatorId);
	}
	
	@NonVisual
	public void setModifierId(Long modifierId) {
		super.setModifierId(modifierId);
	}
}
