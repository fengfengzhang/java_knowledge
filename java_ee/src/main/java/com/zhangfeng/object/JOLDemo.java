package com.zhangfeng.object;


import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.vm.VM;

/**
 * @ClassName ObjectHeadDemo
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/16 17:25
 */
public class JOLDemo {

    public static void main(String[] args) {
//        Object o = new Object(); //new 一个对象占多少内存，16字节
//        System.out.println(o.hashCode());//hashCode记录在什么位置
//        System.gc();//手动收集垃圾

           //VM详细细节
//        System.out.println(VM.current().details());
          //所有对象对齐，都是8字节的整数倍
//        System.out.println(VM.current().objectAlignment());


//        Object o = new Object();
//        System.out.println(ClassLayout.parseInstance(o).toPrintable());

        Customer c1 = new Customer();
        System.out.println(ClassLayout.parseInstance(c1).toPrintable());

    }
}

class Customer{
    //1第一种情况只有对象头，没有其他任何实例数据

    //2.第二种情况 int + boolean
    int id;
    boolean flag = false;

}
/**
 * 1.默认配置，启动了压缩指针
 *   12 + 4（对齐填充） = 一个对象16字节
 * 2.手动配置：关闭压缩指针
 *   16字节
 */


