package com.sihui.shiro.dao;

import com.sihui.shiro.vo.User;

import java.util.List;

/**
 * @author sihui.sha
 * @date 2018/11/13
 */
public interface UserDao {
    User getUserByUserName(String userName);

    List<String> queryRolesByUserName(String userName);

    List<String> getPermissionsByUserName(String userName);
}
