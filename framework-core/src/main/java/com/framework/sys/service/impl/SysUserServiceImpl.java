package com.framework.sys.service.impl;

import com.framework.base.service.impl.BaseServiceImpl;
import com.framework.base.vo.BaseCondation;
import com.framework.shiro.util.PasswordUtil;
import com.framework.sys.mapper.SysUserMapper;
import com.framework.sys.service.SysUserService;
import com.framework.sys.vo.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SysUserServiceImpl extends BaseServiceImpl<SysUser, BaseCondation, SysUserMapper>
    implements SysUserService {

    @Autowired
    private PasswordUtil passwordUtil;

    public boolean add(SysUser user) {
        passwordUtil.encryptPassword(user);
        return super.add(user);
    }

    public boolean updateDetail(SysUser user) {
        passwordUtil.encryptPassword(user);
        return super.updateDetail(user);
    }
}
