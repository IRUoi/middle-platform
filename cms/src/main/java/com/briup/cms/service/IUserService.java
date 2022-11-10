package com.briup.cms.service;

import com.briup.cms.dto.UserDto;

/**
 * @Auther: ZHU(lc))
 * @Date: 11/8/2022-11-08-11:45 AM
 * @Description：com.briup.cms.service
 */
public interface IUserService {
    //登录成功，返回token
    public String login(UserDto userDto);
}

