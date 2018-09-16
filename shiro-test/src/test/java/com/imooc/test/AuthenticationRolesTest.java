package com.imooc.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.SimpleAccountRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: JiaZF
 * Date: 2018/8/3
 * Time: 14:52
 * Description:
 */
public class AuthenticationRolesTest {

    SimpleAccountRealm simpleAccountRealm =new SimpleAccountRealm();

    @Before
    public void addUser(){
        simpleAccountRealm.addAccount("Mark","123456","admin","user");// 多参数
    }

    @Test
    public void testAuthentication(){

        //1.构建securtymanager
        DefaultSecurityManager manager = new DefaultSecurityManager();
        manager.setRealm(simpleAccountRealm);

        //2.主体提交认证请求
        SecurityUtils.setSecurityManager(manager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token =new UsernamePasswordToken("Mark","123456");
        subject.login(token);

        //是否认证的一个方法
        boolean authenticated = subject.isAuthenticated();
        System.out.println("authenticated:=================="+authenticated);

        subject.checkRole("admin");
        subject.checkRoles("admin","user");
    }
}
