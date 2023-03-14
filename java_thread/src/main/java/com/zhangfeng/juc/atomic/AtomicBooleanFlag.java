package com.zhangfeng.juc.atomic;

/**
 * @ClassName AtomicBooleanFlag
 * @Description TODO
 * @Author Zhengfeng
 * @Date 2023/3/7 15:41
 */

import java.util.concurrent.atomic.AtomicBoolean;

/**
 * volatile是java虚拟机提供的轻量级的同步机制
 * 修饰的变量
 * 1.保证可见性
 * 2.不保证原子性
 * 3.禁止指令重排序
 *
 * JMM java内存模型
 */
public class AtomicBooleanFlag {

    public static AtomicBoolean flag = new AtomicBoolean(true);

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            while (flag.get()){
                try {
                    Thread.sleep(1000);
                    System.out.println("I am working");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            System.out.println("I am finished");

        }).start();

        Thread.sleep(5000);
        flag.set(false);

    }
}
