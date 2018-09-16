package com.imooc.test.SerializableTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

/**
 * Created by IntelliJ IDEA.
 * User: JiaZF
 * Date: 2018/8/14
 * Time: 9:10
 * Description:
 */
public class DeserialTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        long begin = System.currentTimeMillis();
        Person person;
        FileInputStream fis = new FileInputStream("D://Person.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        person = (Person) ois.readObject();
        ois.close();
        long end = System.currentTimeMillis();
        System.out.println("Person Deserial" + person+" ,用时："+(end -begin)+"ms");
    }

}