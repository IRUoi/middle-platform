package com.briup.user.dao.extend;

import com.briup.user.bean.User;

/**
 * @Auther: ZHU(lc))
 * @Date: 11/8/2022-11-08-11:52 AM
 * @Description：com.briup.user.dao.extend
 */
public interface UserExtendMapper {
    public User findByName(String username);
}
