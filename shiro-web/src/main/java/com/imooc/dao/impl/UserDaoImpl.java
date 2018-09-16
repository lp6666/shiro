package com.imooc.dao.impl;

import com.imooc.dao.UserDao;
import com.imooc.vo.User;
import org.apache.shiro.util.CollectionUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Component;
import sun.rmi.transport.StreamRemoteCall;

import javax.annotation.Resource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: JiaZF
 * Date: 2018/8/8
 * Time: 14:15
 * Description:
 */
@Component
public class UserDaoImpl implements UserDao {


    @Resource
    private JdbcTemplate jdbcTemplate;

    public User getUserByUsername(String username) {

        String sql ="select username ,password from test_user where username = ?";
        List<User> list  = jdbcTemplate.query(sql, new String[]{username}, new RowMapper<User>() {
            public User mapRow(ResultSet rs, int rowNum) throws SQLException {
                User user = new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                return user;
            }
        });
        if(CollectionUtils.isEmpty(list)){
            return null;
        }
        return list.get(0);
    }

    public List<String> getRolesByUsername(String username) {

        String sql ="select role_name from test_user_role where username = ?";
        List<String> list  = jdbcTemplate.query(sql, new String[]{username}, new RowMapper<String>() {
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getString("role_name");
            }
        });
        if(CollectionUtils.isEmpty(list)){
            return null;
        }
        return list;
    }

    public List<String> getPermissionsByUserName(String username) {
        String sql ="select permission from roles_permissions rp inner join test_user_role tur on  tur.role_name =  rp.role_name where tur.username = ?";
        List<String> list  = jdbcTemplate.query(sql, new String[]{username}, new RowMapper<String>() {
            public String mapRow(ResultSet rs, int rowNum) throws SQLException {
                return rs.getString("permission");
            }
        });
        if(CollectionUtils.isEmpty(list)){
            return null;
        }
        return list;
    }
}
