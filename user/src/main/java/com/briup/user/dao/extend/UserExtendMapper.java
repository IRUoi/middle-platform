package com.briup.user.dao.extend;

import com.briup.common.web.util.PageUtil;
import com.briup.user.bean.User;
import com.github.pagehelper.Page;

import java.util.List;
import java.util.Map;

/**
 * @Auther: ZHU(lc))
 * @Date: 11/8/2022-11-08-11:52 AM
 * @Description：com.briup.user.dao.extend
 */
public interface UserExtendMapper {
    User findByName(String username);

    Page<User> findByPage(Map params);

    void deleteBatch(List<Integer> ids);
}
