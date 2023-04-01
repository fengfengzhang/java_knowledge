package com.zhangfeng.juc.completablefuture;

import lombok.Getter;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @ClassName CompletableFutureMallDemo
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/4/1 16:21
 */
public class CompletableFutureMallDemo {

    public static List<NetMall> list = Arrays.asList(
            new NetMall("jd"),
            new NetMall("dangdang"),
            new NetMall("taobao")
    );

    public static List<String> getPrice(List<NetMall> list, String productName){
       return list.stream().map(netMall -> {
           return String.format(productName + " in %s price is %.2f",netMall.getNetMall(),netMall.calPrice(productName));
        }).collect(Collectors.toList());
    }

    public static List<String> getPriceByCompletableFuture(List<NetMall> list, String productName){
        List<String> collect = list.stream().map(netMall -> {
            return CompletableFuture.supplyAsync(() -> {
                return String.format(productName + " in %s price is %.2f", netMall.getNetMall(), netMall.calPrice(productName));
            });
        }).collect(Collectors.toList()).stream().map(i -> i.join()).collect(Collectors.toList());
        return collect;


    }

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
//        System.out.println(getPrice(list, "mysql"));
        System.out.println(getPriceByCompletableFuture(list, "mysql"));
        long end = System.currentTimeMillis();
        System.out.println("-----" + (end - start) + "----");
    }
}


class NetMall{

    @Getter
    private String netMall;

    public NetMall(String netMall) {
        this.netMall = netMall;
    }


    public double calPrice(String productName) {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return ThreadLocalRandom.current().nextDouble() * 2 + productName.charAt(0);
    }
}
