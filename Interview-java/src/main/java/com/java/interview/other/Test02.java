package com.java.interview.other;


import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.*;

/**
 * 测试CopyOnWriteArrayList和Collections.synchronizedList随着线程数增多的性能差异
 */
@Slf4j
public class Test02 {

    private int NUM = 10000;
    private int THREAD_COUNT = 16;

    @Test
    public void testAdd() throws Exception {
        List<Integer> list1 = new CopyOnWriteArrayList<>();
        List<Integer> list2 = Collections.synchronizedList(new ArrayList<>());

        //TODO 这个有必要吗？
        CountDownLatch addCountDownLatch = new CountDownLatch(THREAD_COUNT);
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);

        log.info("写操作,线程:{},每个线程写操作次数:{}", THREAD_COUNT, NUM);
        int addCopyCostTime = 0,addSynchCostTime = 0;
        for (int i = 0; i < THREAD_COUNT; i++) {
            addCopyCostTime += executor.submit(new AddTestTask(list1, addCountDownLatch)).get();
        }
        log.info("CopyOnWriteArrayList写操作,耗时(毫秒):{}", addCopyCostTime);

        for (int i = 0; i < THREAD_COUNT; i++) {
            addSynchCostTime += executor.submit(new AddTestTask(list2, addCountDownLatch)).get();
        }
        log.info("SynchronizedList写操作,耗时(毫秒):{}", addSynchCostTime);

        executor.shutdown();
    }

    @Test
    public void testGet() throws Exception {
        List<Integer> list = initList();

        List<Integer> list1 = new CopyOnWriteArrayList<Integer>(list);
        List<Integer> list2 = Collections.synchronizedList(list);

        int get_copyCostTime = 0;
        int get_synchCostTime = 0;
        log.info("读操作,线程:{},每个线程读操作次数:{}", THREAD_COUNT, NUM);

        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        CountDownLatch get_countDownLatch = new CountDownLatch(THREAD_COUNT);
        for (int i = 0; i < THREAD_COUNT; i++) {
            get_copyCostTime += executor.submit(new GetTestTask(list1, get_countDownLatch)).get();
        }
        log.info("CopyOnWriteArrayList读操作,耗时(毫秒):{}", get_copyCostTime);

        for (int i = 0; i < THREAD_COUNT; i++) {
            get_synchCostTime += executor.submit(new GetTestTask(list2, get_countDownLatch)).get();
        }
        log.info("SynchronizedList读操作,耗时(毫秒):{}", get_synchCostTime);

    }


    private List<Integer> initList() {
        List<Integer> list = new ArrayList<Integer>();
        int num = new Random().nextInt(1000);
        for (int i = 0; i < NUM; i++) {
            list.add(num);
        }
        return list;
    }

    class AddTestTask implements Callable<Integer> {
        List<Integer> list;
        CountDownLatch countDownLatch;

        AddTestTask(List<Integer> list, CountDownLatch countDownLatch) {
            this.list = list;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public Integer call() throws Exception {
            int num = new Random().nextInt(1000);
            long start = System.currentTimeMillis();
            for (int i = 0; i < NUM; i++) {
                list.add(num);
            }
            long end = System.currentTimeMillis();
            countDownLatch.countDown();
            return (int) (end - start);
        }
    }

    class GetTestTask implements Callable<Integer> {
        List<Integer> list;
        CountDownLatch countDownLatch;

        GetTestTask(List<Integer> list, CountDownLatch countDownLatch) {
            this.list = list;
            this.countDownLatch = countDownLatch;
        }

        @Override
        public Integer call() throws Exception {
            int pos = new Random().nextInt(NUM);
            long start = System.currentTimeMillis();
            for (int i = 0; i < NUM; i++) {
                list.get(pos);
            }
            long end = System.currentTimeMillis();
            countDownLatch.countDown();
            return (int) (end - start);
        }
    }
}
