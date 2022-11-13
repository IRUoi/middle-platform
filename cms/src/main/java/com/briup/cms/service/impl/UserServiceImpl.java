package com.briup.cms.service.impl;

import com.briup.cms.dto.UserDto;
import com.briup.cms.service.IUserService;
import com.briup.common.web.util.PageUtil;
import com.briup.common.web.web.exception.CustomerException;
import com.briup.common.web.web.response.ResultCode;
import com.briup.common.web.util.JwtUtil;
import com.briup.user.bean.User;
import com.briup.user.dao.UserMapper;
import com.briup.user.dao.extend.UserExtendMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auther: ZHU(lc))
 * @Date: 11/8/2022-11-08-11:48 AM
 * @Description：com.briup.cms.service.impl
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserExtendMapper userExtendMapper;
    @Override
    public String login(UserDto userDto) {
        User userFormDB = userExtendMapper.findByName(userDto.getUsername());
        //1、检验用户名密码
        if(ObjectUtils.isEmpty(userFormDB)
                || !userFormDB.getPassword().equals(userDto.getPassword())){
            throw new CustomerException(ResultCode.USER_LOGIN_ERROR);
        }
        //账户禁用
        if(userFormDB.getStatus() == 1){
            throw new CustomerException(ResultCode.USER_ACCOUNT_FORBIDDEN);
        }
        //2、准备token中的信息
        Map<String,Object> info = new HashMap<>();
        info.put("username",userFormDB.getUsername());
        info.put("realname",userFormDB.getRealname());
        String token = JwtUtil.sign(String.valueOf(userFormDB.getUserId()), info);
        //3、通过工具类产生token并返回
        return token;
    }

    @Override
    public List<User> findByPage(PageUtil pageUtil) {
        return null;
    }
}
