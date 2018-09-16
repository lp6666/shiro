package com.imooc.test;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: JiaZF
 * Date: 2018/8/3
 * Time: 15:00
 * Description:
 */
public class IniRealmTest {

    @Test
    public void testAuthentication(){

        IniRealm iniRealm =new IniRealm("classpath:user.ini");

        //1.构建securtymanager
        DefaultSecurityManager manager = new DefaultSecurityManager();
        manager.setRealm(iniRealm);

        //2.主体提交认证请求
        SecurityUtils.setSecurityManager(manager);
        Subject subject = SecurityUtils.getSubject();

        UsernamePasswordToken token =new UsernamePasswordToken("Mark","123456");
        subject.login(token);

        //是否认证的一个方法
        boolean authenticated = subject.isAuthenticated();
        System.out.println("authenticated==============="+authenticated);
        subject.checkRole("admin");

        subject.checkPermission("user:delete");
        subject.checkPermission("user:update");
    }
}
