package com.imooc.test.SerializableTest;

import java.io.Serializable;

/**
 * Created by IntelliJ IDEA.
 * User: JiaZF
 * Date: 2018/8/14
 * Time: 9:08
 * Description:
 */
public class  Person implements Serializable {
    private static final long serialVersionUID = 123456789L;
    // 测试序列化 修改了序列化id后就报错了。
    //Exception in thread "main" java.io.InvalidClassException: com.imooc.test.SerializableTest.Person;
    // local class incompatible: stream classdesc serialVersionUID = 123456789, local class serialVersionUID = 16789
    //private static final long serialVersionUID = 16789L;

    public int id;
    public String name;
    public int age;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Person(int id, String name,int age) {
        this.id = id;
        this.name = name;
        this.age=age;
    }

    public String toString() {
        return "Person: " + id + " " + name+" "+age;
    }
}
