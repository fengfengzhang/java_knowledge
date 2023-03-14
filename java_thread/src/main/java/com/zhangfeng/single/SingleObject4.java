package com.zhangfeng.single;

/**
 * @ClassName SingleObject4
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/8 22:10
 */

/**
 * 静态内部类
 */
public class SingleObject4 {

    //装载链接初始化
    private SingleObject4(){

    }

    /**
     * static 只被加载一次
     * static 严格保证顺序，使用才被加载
     * 保证了懒加载，线程安全，效率
     */
    private static class InstanceHolder {
        private final  static SingleObject4 instance = new SingleObject4();
        /*public InstanceHolder(){

        }*/
    }

    public static SingleObject4 getInstance(){
        return InstanceHolder.instance;
    }


}
