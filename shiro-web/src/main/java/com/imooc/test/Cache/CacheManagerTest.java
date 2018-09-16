package com.imooc.test.Cache;

/**
 * Created by IntelliJ IDEA.
 * User: JiaZF
 * Date: 2018/8/14
 * Time: 8:44
 * Description:
 */
public class CacheManagerTest {

    public static void main(String [] args)throws Exception{

        /*String key = "test";

        String value = CacheManager.getData(key, new CacheManager.Load<String>() {
            public String load(){
                return "testValue";
            }
        },2);

        System.out.println("value:"+value);

        Thread.sleep(3 * 1000);

        String value2 = CacheManager.getData(key, new CacheManager.Load<String>() {
            @Override
            public String load() {
                return "什么";
            }
        },3);
        System.out.println("value2:" + value2);
        Thread.sleep(4 * 1000);
        System.out.println("value3:" + CacheManager.getData(key));*/

        System.out.println(Runtime.getRuntime().availableProcessors());

    }


}
