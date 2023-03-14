package com.zhangfeng.juc.atomic;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName SyncAndReentrantLockDemo
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/12 13:26
 */

class ShareResource {
    private  int number = 1;//A:1,B:2 C:3
    private  Lock lock = new ReentrantLock();
    private  Condition conditionA = lock.newCondition();
    private  Condition conditionB = lock.newCondition();
    private  Condition conditionC = lock.newCondition();

    public void print5(){
        lock.lock();
        try{
            while (1!= number){
                conditionA.await();
            }

            for(int i = 0; i < 5; i++){
                System.out.println(Thread.currentThread().getName() + "  " +"A");
            }

            number = 2;
            conditionB.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void print10(){
        lock.lock();
        try{
            while (2!= number){
                conditionB.await();
            }

            for(int i = 0; i < 10; i++){
                System.out.println(Thread.currentThread().getName() + "  " +"B");
            }

            number = 3;
            conditionC.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void print15(){
        lock.lock();
        try{
            while (3!= number){
                conditionC.await();
            }

            for(int i = 0; i < 15; i++){
                System.out.println(Thread.currentThread().getName() + "  " +"C");
            }

            number = 1;
            conditionA.signal();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ShareResource shareResource = new ShareResource();
        for(int i = 0; i <=3 ; i++){
            new Thread(shareResource::print5,"1").start();
            new Thread(shareResource::print10,"2").start();
            new Thread(shareResource::print15,"2").start();
        }
    }


}