package com.imooc.test;

import com.alibaba.druid.pool.DruidDataSource;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.jdbc.JdbcRealm;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: JiaZF
 * Date: 2018/8/3
 * Time: 15:14
 * Description:
 */
public class JdbcRealmTest {

    DruidDataSource data =new DruidDataSource();
    {
        data.setUrl("jdbc:mysql://localhost:3306/mydb?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC");
        data.setUsername("root");
        data.setPassword("123456");
    }
    @Test
    public void testAuthentication(){

        JdbcRealm jdbcRealm = new JdbcRealm();
        jdbcRealm.setDataSource(data);
        jdbcRealm.setPermissionsLookupEnabled(true);
        String sql="select password from test_user where username= ?";
        jdbcRealm.setAuthenticationQuery(sql);

        String roleSql ="select role_name from test_user_role where username = ?";
        jdbcRealm.setUserRolesQuery(roleSql);

        //1.构建securtymanager
        DefaultSecurityManager manager = new DefaultSecurityManager();
        manager.setRealm(jdbcRealm);

        //2.主体提交认证请求
        SecurityUtils.setSecurityManager(manager);
        Subject subject = SecurityUtils.getSubject();

       // UsernamePasswordToken token =new UsernamePasswordToken("Mark","123456");
        UsernamePasswordToken token =new UsernamePasswordToken("xiaoming","123456");
        subject.login(token);

        //是否认证的一个方法
        boolean authenticated = subject.isAuthenticated();
        System.out.println("authenticated==============="+authenticated);
        subject.checkRole("user");
       // subject.checkRole("admin");

        /*subject.checkPermission("user:delete");*/

     
    }
}
