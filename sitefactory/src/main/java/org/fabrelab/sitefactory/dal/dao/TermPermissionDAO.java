package org.fabrelab.sitefactory.dal.dao;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public interface TermPermissionDAO {

    public java.lang.Long insert(TermPermissionDO termPermissionDO);


    public Integer update(TermPermissionDO termPermissionDO);


    public TermPermissionDO findByPrimaryKey(java.lang.Long id);


    public Integer deleteByPrimaryKey(java.lang.Long id);


    public Integer countByExample(TermPermissionDO termPermissionDO);


    public List<TermPermissionDO> listByExample(TermPermissionDO termPermissionDO);


    public List<TermPermissionDO> pageByExample(TermPermissionDO termPermissionDO, PageInfo page);


    public Integer deleteByExample(TermPermissionDO termPermissionDO);









}
