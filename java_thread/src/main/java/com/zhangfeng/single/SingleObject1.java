package com.zhangfeng.single;

/**
 * @ClassName SingleObject1
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/8 22:03
 */

/**
 * 饿汉式
 */
public class SingleObject1 {

    private static final SingleObject1 instance = new SingleObject1();

    private SingleObject1(){

    }

    public static SingleObject1 getInstance(){
        return instance;
    }
}
