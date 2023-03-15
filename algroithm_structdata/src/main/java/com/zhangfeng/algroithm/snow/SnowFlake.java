package com.zhangfeng.algroithm.snow;

import java.util.HashSet;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @ClassName SnowFlake
 * @Description TODO
 * @Author zhangfeng
 * @Date 2023/3/14 22:22
 */
//雪花算法，生成全局唯一id
public class SnowFlake {

    // 时间 41 位
    private static long lastTime = System.currentTimeMillis();

    // 数据中心 ID 5 位 (默认 0-31)
    private long datacenterId = 0;
    private long datacenterIdShift = 5;

    // 机房机器 ID 5 位 (默认 0-31)
    private long workerId = 0;
    private long workerIdShift = 5;

    // 随机数 12 位 (默认 0~4095)
    private AtomicLong random = new AtomicLong();
    private long randomShift = 12;
    // 随机数的最大值
    private long maxRandom = (long) Math.pow(2, randomShift);

    public SnowFlake() {
    }

    public SnowFlake(long workerIdShift, long datacenterIdShift){
        if (workerIdShift < 0 ||
                datacenterIdShift < 0 ||
                workerIdShift + datacenterIdShift > 22) {
            throw new IllegalArgumentException("参数不匹配");
        }
        this.workerIdShift = workerIdShift;
        this.datacenterIdShift = datacenterIdShift;
        this.randomShift = 22 - datacenterIdShift - workerIdShift;
        this.maxRandom = (long) Math.pow(2, randomShift);
    }

    // 获取雪花的 ID
    private long getId() {
        return lastTime << (workerIdShift + datacenterIdShift + randomShift) |
                workerId << (datacenterIdShift + randomShift) |
                datacenterId << randomShift |
                random.get();
    }

    // 生成一个新的 ID
    public synchronized long nextId() {
        long now = System.currentTimeMillis();

        // 如果当前时间和上一次时间不在同一毫秒内，直接返回
        if (now > lastTime) {
            lastTime = now;
            random.set(0);
            return getId();
        }

        // 将最后的随机数，进行 + 1 操作
        if (random.incrementAndGet() < maxRandom) {
            return getId();
        }

        // 自选等待下一毫秒
        while (now <= lastTime) {
            now = System.currentTimeMillis();
        }

        lastTime = now;
        random.set(0);
        return getId();

    }

    // 测试
    public static void main(String[] args) {
        SnowFlake snowFlake = new SnowFlake();
        HashSet<Long> set = new HashSet<>();
        for (int i = 0; i < 10000; i++) {
            set.add(snowFlake.nextId());
        }
        System.out.println(set.size());
    }
}
