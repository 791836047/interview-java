package com.java.interview.other.limitrate;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 滑动窗口示例二  首选
 *
 * @author liaowenhui
 * @date 2023/3/14 17:58
 */
public class SlidingWindow {
    // 窗口大小，单位为秒
    private int windowSize;
    // 窗口内的时间单元个数
    private int unitCount;
    // 每个时间单元的长度，单位为毫秒
    private int unitLength;
    // 窗口内的时间单元数组
    private AtomicInteger[] units;
    // 窗口内的总请求数
    private AtomicInteger total;
    // 限制值
    private int limit;
    // 锁对象
    private Object lock;

    public SlidingWindow(int windowSize, int unitCount, int limit) {
        this.windowSize = windowSize;
        this.unitCount = unitCount;
        this.unitLength = windowSize * 1000 / unitCount;
        this.units = new AtomicInteger[unitCount];
        for (int i = 0; i < unitCount; i++) {
            units[i] = new AtomicInteger(0);
        }
        this.total = new AtomicInteger(0);
        this.limit = limit;
        this.lock = new Object();
    }

    // 判断是否允许请求通过
    public boolean allow() {
        // 获取当前时间戳
        long now = System.currentTimeMillis();
        // 计算当前时间所在的时间单元索引
        //TODO 不理解
        int index = (int) ((now / unitLength) % unitCount);
        // 获取当前时间单元的请求数
        AtomicInteger currentUnit = units[index];
        // 获取当前时间单元的开始时间
        long currentUnitStartTime = currentUnit.get() * unitLength;

        // 加锁保证线程安全
        synchronized (lock) {
            // 如果当前时间单元已经过期，就重置为0，并从总数中减去过期的请求数
            if (now - currentUnitStartTime > windowSize * 1000) {
                total.addAndGet(-currentUnit.get());
                currentUnit.set(0);
            }
            // 清除其他过期的时间单元（如果有）
            for (int i = 1; i < unitCount; i++) {
                // 计算前一个时间单元索引
                int prevIndex = (index - i + unitCount) % unitCount;
                // 获取前一个时间单元
                AtomicInteger prevUnit = units[prevIndex];
                // 获取前一个时间单元开始时间
                long prevUnitStartTime = prevUnit.get() * unitLength;
                // 如果前一个时间单元过期，就重置为0，并从总数中减去过期的请求数
                if (now - prevUnitStartTime > windowSize * 1000) {
                    total.addAndGet(-prevUnit.get());
                    prevUnit.set(0);
                } else {
                    // 如果前一个时间单元没有过期，就跳出循环（因为后面的也不会过期）
                    break;
                }
            }
            // 如果总数小于限制值，就让当前时间单元和总数加1，并返回true
            if (total.get() < limit) {
                currentUnit.incrementAndGet();
                total.incrementAndGet();
                return true;
            } else {
                // 否则返回false，表示拒绝请求通过
                return false;
            }
        }
    }

    public static void main(String[] args) {
        // 创建一个滑动窗口对象，设置窗口大小为10秒，时间单元个数为10，限制值为15
        SlidingWindow slidingWindow = new SlidingWindow(10, 10, 15);
        // 创建一个线程池，用于模拟并发请求
        ExecutorService executorService = Executors.newFixedThreadPool(100);
        // 创建一个计数器数组，用于统计每个时间单元内的请求数
        AtomicInteger[] counters = new AtomicInteger[10];
        for (int i = 0; i < 10; i++) {
            counters[i] = new AtomicInteger(0);
        }
        // 创建100个线程，每个线程随机等待0到10秒后调用滑动窗口对象的allow()方法，并打印返回值和当前时间
        for (int i = 0; i < 100; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        // 随机等待0到10秒
                        Thread.sleep(new Random().nextInt(10000));
                        // 调用allow()方法，并获取返回值
                        boolean result = slidingWindow.allow();
                        // 获取当前时间戳和时间单元索引
                        long now = System.currentTimeMillis();
                        int index = (int) ((now / slidingWindow.unitLength) % slidingWindow.unitCount);
                        // 如果返回值为true，就让对应的计数器加1，并打印通过信息
                        if (result) {
                            counters[index].incrementAndGet();
                            //System.out.println(Thread.currentThread().getName() + " 请求通过 at " + now);
                        } else {
                            // 否则打印拒绝信息
                            System.out.println(Thread.currentThread().getName() + " 请求拒绝 at " + now);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        // 关闭线程池
        executorService.shutdown();
        // 等待所有线程执行完毕
        while (!executorService.isTerminated()) {
        }
        // 打印每个时间单元内的请求数，并与限制值进行比较
        for (int i = 0; i < 10; i++) {
            System.out.println("第" + (i + 1) + "个时间单元内请求数为：" + counters[i].get());
            if (counters[i].get() > slidingWindow.limit) {
                System.out.println("超过了限制值！");
            }
        }
    }
}
