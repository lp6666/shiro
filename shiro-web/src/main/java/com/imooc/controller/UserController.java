package com.imooc.controller;

import com.imooc.vo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: JiaZF
 * Date: 2018/8/6
 * Time: 10:24
 * Description:
 */
@Controller
public class UserController {

    @RequestMapping(value ="subLogin" ,produces = "application/json;charset=utf-8")  //method = RequestMethod.POST,
    @ResponseBody
    public String subLogin(User user){
      Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(),user.getPassword());
        try{
            token.setRememberMe(user.isRemenberMe());
            subject.login(token);
        }catch (AuthenticationException e){
            return e.getMessage();
        }

        if(!subject.hasRole("admin")){
            return "有user权限";
        }
        return "有admin权限";
        //return "登录成功";
    }


    @ResponseBody
    @RequestMapping(value="testRole",method = RequestMethod.GET)
    @RequiresPermissions("user:update")
    public String testRole(){
        return "testRole";
    }

    @ResponseBody
    @RequestMapping(value="testRole1",method = RequestMethod.GET)
    public String testRole1(){
        return "testRole1";
    }


    @ResponseBody
    @RequestMapping(value="testPesim",method = RequestMethod.GET)
    public String testPesim(){
        return "testPesim";
    }

    @ResponseBody
    @RequestMapping(value="testPesim1",method = RequestMethod.GET)
    public String testPesim1(){
        return "testPesim1";
    }
}
