package com.zhangfeng.single;

/**
 * @ClassName SingleObject2
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/8 22:05
 */

/*
懒汉式
 */
public class SingleObject2 {

    private static SingleObject2 instance = null;

    public static  synchronized SingleObject2 getInstance(){
        if(instance == null){
            instance= new SingleObject2();
        }
        return instance;
    }


    private  SingleObject2(){

    }
}
