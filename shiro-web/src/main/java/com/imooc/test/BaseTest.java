package com.imooc.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by IntelliJ IDEA.
 * User: JiaZF
 * Date: 2018/8/13
 * Time: 13:46
 * Description:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring.xml")
public class BaseTest {

    @Test
    public void initTest(){
        System.out.println("test init");
    }

}