package com.imooc.test.SerializableTest;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * Created by IntelliJ IDEA.
 * User: JiaZF
 * Date: 2018/8/14
 * Time: 9:09
 * Description:
 */
public class SerialTest{

    public static void main(String[] args) throws IOException {
        Person person = new Person(1234, "wang");
        System.out.println("Person Serial" + person);
        FileOutputStream fos = new FileOutputStream("D://Person.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(person);
        oos.flush();
        oos.close();
    }
}