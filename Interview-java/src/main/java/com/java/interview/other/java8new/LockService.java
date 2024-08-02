package com.java.interview.other.java8new;

import java.util.function.Supplier;

/**
 * 学习封装分布式锁和Supplier使用懒加载
 * @author liaowenhui
 * @date 2023/8/10 14:56
 */
public class LockService {

    public <T> T executeWithLock(LockBizType bizType, String bizId, Supplier<T> supplier) {
        return executeWithLock(bizType, bizId, 60, 3, supplier);
    }

    public <T> T executeWithLock(LockBizType bizType, String bizId, int expireSeconds, int retryTimes, Supplier<T> supplier) {
        int lockTimes = 1;
        boolean lock = tryLock(bizType, bizId, expireSeconds);
        while (lockTimes < retryTimes && !lock) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                // Handle interruption
            }
            lock = tryLock(bizType, bizId, expireSeconds);
            lockTimes++;
        }

        if (!lock) {
            throw new LockException("try lock fail");
        }

        try {
            /**
             * 延迟求值（Lazy Evaluation）： Supplier 代表一个可以提供值的函数，但它并不会立即执行。
             * 当你调用 supplier.get() 时，才会触发执行 Supplier 所代表的逻辑。这种延迟求值的特性可以在需要时才执行，避免不必要的计算和资源消耗。
             */
            return supplier.get();
        } finally {
            unlock(bizType, bizId);
        }
    }

    private boolean tryLock(LockBizType bizType, String bizId, int expireSeconds) {
        // Simulate lock acquisition logic
        // Return true if lock is acquired, false otherwise
        return true; // Replace with actual lock logic
    }

    private void unlock(LockBizType bizType, String bizId) {
        // Simulate unlocking logic
        // Implement unlocking of the lock
    }
}

enum LockBizType {
    ORDER,
    // Add other types if needed
}

class LockException extends RuntimeException {
    public LockException(String message) {
        super(message);
    }
}

