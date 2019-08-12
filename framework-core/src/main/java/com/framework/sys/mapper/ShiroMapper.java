package com.framework.sys.mapper;

import com.framework.mybatis.MyBatisMapper;
import com.framework.sys.vo.SysUser;
import java.util.Set;

@MyBatisMapper
public interface ShiroMapper {

    SysUser queryUserByLoginId(String loginId);

    Set<String> queryRoles(String loginId);

    Set<String> queryPermissions(String loginId);
}
