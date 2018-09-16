package com.imooc.dao;

import com.imooc.vo.User;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: JiaZF
 * Date: 2018/8/8
 * Time: 14:14
 * Description:
 */
public interface UserDao {

    User getUserByUsername(String username);

    List<String> getRolesByUsername(String username);

    List<String> getPermissionsByUserName(String username);
}
