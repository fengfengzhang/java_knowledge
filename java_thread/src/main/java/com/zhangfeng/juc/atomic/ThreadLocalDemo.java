package com.zhangfeng.juc.atomic;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Thread和ThreadLocal  各自线程人手一份
 *
 * ThreadLocal 里内部类 ThreadLocalMap内部类
 * ThreadLocalMap 内有Entry extends WeakReference<ThreadLocal<?>> <?> 代表支持任何泛型
 */

/**
 * @ClassName ThreadLocalDemo
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/13 21:34
 */

class House{
    int selectCount = 0;

    public synchronized void saleHouse(){
        selectCount ++;
    }
    /*ThreadLocal<Integer> saleVolume = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };*/
    ThreadLocal<Integer> saleVolume = ThreadLocal.withInitial(()->0);
     public void saleVolumeByThreadLocal(){
         saleVolume.set(1+saleVolume.get());
     }
}

public class ThreadLocalDemo {

    public static void main(String[] args) throws InterruptedException {
//        culSaleVolumeBySync();
        House house = new House();
        for(int i = 1; i <= 5 ;i ++){
            new Thread(()->{
                int size = new Random().nextInt(5) + 1;
                try {
                    System.out.println(size);
                    for(int j = 1; j<= size; j++){
                        house.saleVolumeByThreadLocal();
                        house.saleHouse();
                    }
                } finally {
                    //threadLocal,线程使用完要销毁，否则影响其他线程后面的使用，会记录原来的指
                    house.saleVolume.remove();
                }

                System.out.println(Thread.currentThread().getName() +"销售卖出" + house.saleVolume.get());
            },String.valueOf(i)).start();
        }

        TimeUnit.SECONDS.sleep(3);

        System.out.println(house.selectCount);
    }

    private static void culSaleVolumeBySync() throws InterruptedException {
        House house = new House();
        for(int i = 1; i <= 5 ;i ++){
            new Thread(()->{
                int size = new Random().nextInt(5) + 1;
                System.out.println(size);
                for(int j = 1; j<= size; j++){
                    house.saleHouse();
                }
            },String.valueOf(i)).start();
        }

        TimeUnit.SECONDS.sleep(3);

        System.out.println(house.selectCount);
    }
}
