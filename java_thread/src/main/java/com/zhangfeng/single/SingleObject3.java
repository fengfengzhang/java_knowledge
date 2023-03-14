package com.zhangfeng.single;

/**
 * @ClassName SingleObject3
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/8 22:07
 */

/**
 * 懒汉式双重检索
 */
public class SingleObject3 {

    private static volatile SingleObject3 instance = null;

    private SingleObject3(){

    }

    public static SingleObject3 getInstance(){
        if(instance == null){
            synchronized (SingleObject3.class){
                if(instance == null){
                    instance = new SingleObject3();
                }
            }
        }
        return instance;
    }
}
