package com.framework.sys.mapper;

import com.framework.base.mapper.TreeMapper;
import com.framework.base.vo.BaseCondation;
import com.framework.mybatis.MyBatisMapper;
import com.framework.sys.vo.SysMenu;

@MyBatisMapper
public interface SysMenuMapper extends TreeMapper<SysMenu, BaseCondation> {
}
