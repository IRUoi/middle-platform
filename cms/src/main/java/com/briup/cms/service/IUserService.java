package com.briup.cms.service;

import com.briup.cms.dto.UserDto;
import com.briup.common.web.util.PageUtil;
import com.briup.user.bean.User;

import java.util.List;

/**
 * @Auther: ZHU(lc))
 * @Date: 11/8/2022-11-08-11:45 AM
 * @Description：com.briup.cms.service
 */
public interface IUserService {
    //登录成功，返回token
    public String login(UserDto userDto);
    //分页条件查询（角色和名字）
    PageUtil findByPage(PageUtil pageUtil);
    //获取登录用户信息
    User findById(Integer id);

    User currentInfo(String token);

    //更新用户

    void updateUserInfo(User user);
    //id删除

    void deleteById(Integer id);

    void deleteBatch(List<Integer> ids);
}

