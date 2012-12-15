package org.fabrelab.sitefactory.dal.dao;
import java.io.Serializable;
import java.util.*;
import org.fabrelab.sitefactory.dal.dataobject.*;
import org.fabrelab.sitefactory.dal.dao.*;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.fabrelab.pagekit.PageInfo;
public interface TagPermissionDAO {

    public java.lang.Long insert(TagPermissionDO tagPermissionDO);


    public Integer update(TagPermissionDO tagPermissionDO);


    public TagPermissionDO findByPrimaryKey(java.lang.Long id);


    public Integer deleteByPrimaryKey(java.lang.Long id);


    public Integer countByExample(TagPermissionDO tagPermissionDO);


    public List<TagPermissionDO> listByExample(TagPermissionDO tagPermissionDO);


    public List<TagPermissionDO> pageByExample(TagPermissionDO tagPermissionDO, PageInfo page);


    public Integer deleteByExample(TagPermissionDO tagPermissionDO);









}
