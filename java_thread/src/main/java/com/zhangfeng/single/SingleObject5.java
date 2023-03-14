package com.zhangfeng.single;

/**
 * @ClassName SingleObject5
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/8 22:14
 */

/**
 * 枚举
 */
public class SingleObject5 {

    private SingleObject5(){

    }

    //枚举只被创建一次
    private enum Singleton{
        INSTANCE;
        private SingleObject5 instance = null;
        Singleton(){
           instance = new SingleObject5();
        }
    }


    public static SingleObject5 getInstance(){
        return Singleton.INSTANCE.instance;
    }

}
