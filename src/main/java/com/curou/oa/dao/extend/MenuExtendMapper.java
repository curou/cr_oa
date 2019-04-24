package com.curou.oa.dao.extend;


import com.curou.oa.dao.MenuMapper;
import org.apache.ibatis.annotations.Select;

public interface MenuExtendMapper extends MenuMapper {

    @Select("SELECT max(sort) from menu")
    Integer getMaxSort();

}
