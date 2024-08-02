package com.java.interview.other;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.StandardCharsets;

/**
 * @author liaowenhui
 * @date 2023/7/21 14:50
 */
public class BloomFilterExample {
    public static void main(String[] args) {
        // 假设我们有1000个用户，我们要对其中的100个用户做推荐商品处理逻辑
        int totalUsers = 1000;
        int recommendedUsers = 100;

        /**
         * 创建一个布隆过滤器
         * 参数介绍：
         * expectedInsertions：这是布隆过滤器的预计容量大小，即预期需要存储的元素数量。
         * Funnel：Funnels.stringFunnel(StandardCharsets.UTF_8)创建了一个用于处理字符串类型的Funnel，
         * 其中StandardCharsets.UTF_8指定了使用UTF-8编码将字符串转换成字节。
         */
        BloomFilter<String> bloomFilter = BloomFilter.create(Funnels.stringFunnel(StandardCharsets.UTF_8), recommendedUsers);

        // 将推荐过商品的用户加入到布隆过滤器中
        for (int i = 0; i < recommendedUsers; i++) {
            String userId = "user_" + i;
            bloomFilter.put(userId);
        }

        // 模拟查询一部分用户是否需要推荐商品
        for (int i = 0; i < totalUsers; i++) {
            String userId = "user_" + i;
            if (bloomFilter.mightContain(userId)) {
                System.out.println(userId + " 需要推荐商品");
                // TODO: 在这里执行推荐商品的处理逻辑
            } else {
                System.out.println(userId + " 不需要推荐商品");
            }
        }
    }
}
