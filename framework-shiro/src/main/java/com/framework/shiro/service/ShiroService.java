package com.framework.shiro.service;

import com.framework.shiro.vo.ShiroUser;
import java.util.Set;

public interface ShiroService {

    ShiroUser queryUserByLoginId(String loginId);

    Set<String> queryRoles(String loginId);

    Set<String> queryPermissions(String loginId);
}
