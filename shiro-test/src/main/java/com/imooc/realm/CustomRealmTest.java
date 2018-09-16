package com.imooc.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.realm.text.IniRealm;
import org.apache.shiro.subject.Subject;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: JiaZF
 * Date: 2018/8/6
 * Time: 8:53
 * Description:
 */
public class CustomRealmTest {

    @Test
    public void customReal(){

        CustomRealm customRealm = new CustomRealm();
        //1.构建securtymanager
        DefaultSecurityManager manager = new DefaultSecurityManager();
        manager.setRealm(customRealm);

        //shiro 加密
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        //选择加密方式
        matcher.setHashAlgorithmName("md5");
        //加密次数
        matcher.setHashIterations(1);
        customRealm.setCredentialsMatcher(matcher);

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
        subject.checkPermission("user:add");
    }
}
