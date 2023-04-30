package com.zhangfeng.juc.print;

import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName ThreadPrint
 * @Description 线程交替打印
 * @Author zhangfeng
 * @Date 2023/4/30 19:43
 */
public class ThreadPrint {

    public static class PrintByLock {
        List<String> list = Arrays.asList("A","B","C");
        Lock lock = new ReentrantLock();
        Condition conditionA = lock.newCondition();
        Condition conditionB = lock.newCondition();
        Condition conditionC = lock.newCondition();
        int index = 0;

        public void printA(){
            try {
                lock.lock();
                while (!list.get(index).equals("A")){
                    conditionA.await();
                }
                System.out.println(Thread.currentThread().getName() + " A");
                index++;
                index = index % list.size();
                conditionB.signal();

            }catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }





        }
        public void printB()  {
            try {
                lock.lock();
                while (!list.get(index).equals("B")){
                    conditionB.await();
                }
                System.out.println(Thread.currentThread().getName() + " B");
                index++;
                index = index % list.size();
                conditionC.signal();

            }catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }



        }

        public void printC(){
            try {
                lock.lock();
                while (!list.get(index).equals("C")){
                    conditionC.await();
                }
                System.out.println(Thread.currentThread().getName() + " C");
                index++;
                index = index % list.size();
                conditionA.signal();

            }catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }





        }


    }


    public static class PrintBySync{
        public final Object obj = new Object();
        List<String> list = Arrays.asList("A","B","C");
        int index = 0;

        public void printA(){
            synchronized (obj){
                try {
                     while (!list.get(index).equals("A")){
                       obj.wait();
                    }

                    System.out.println(Thread.currentThread().getName() + " A");
                     index ++;
                     index = index%list.size();
                     obj.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                }
        }

        public void printB(){
            synchronized (obj){
                try {
                     while (!list.get(index).equals("B")){
                       obj.wait();
                    }

                    System.out.println(Thread.currentThread().getName() + " B");
                     index ++;
                     index = index%list.size();
                     obj.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                }
        }

        public void printC(){
            synchronized (obj){
                try {
                     while (!list.get(index).equals("C")){
                       obj.wait();
                    }

                    System.out.println(Thread.currentThread().getName() + " C");
                     index ++;
                     index = index%list.size();
                     obj.notifyAll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                }
        }



    }




    public static void main(String[] args) throws InterruptedException {
//        lockPrint();

//        syncPrint();


    }

    private static void syncPrint() {
        PrintBySync print = new PrintBySync();
        Thread a = new Thread(() -> {
            for (int i = 0; i < 15; i++) {
                print.printA();
            }
        }, "线程A");
        Thread b = new Thread(() -> {
            for (int i = 0; i < 15; i++) {
                print.printB();
            }
        }, "线程B");
        Thread c = new Thread(() -> {
            for (int i = 0; i < 15; i++) {
                print.printC();
            }
        }, "线程C");

        a.start();
        b.start();
        c.start();
    }

    private static void lockPrint() {
        PrintByLock print = new PrintByLock();
        Thread a = new Thread(() -> {
            for (int i = 0; i < 15; i++) {
                print.printA();
            }
        }, "线程A");
        Thread b = new Thread(() -> {
            for (int i = 0; i < 15; i++) {
                print.printB();
            }
        }, "线程B");
        Thread c = new Thread(() -> {
            for (int i = 0; i < 15; i++) {
                print.printC();
            }
        }, "线程C");

        a.start();
        b.start();
        c.start();
    }
}
