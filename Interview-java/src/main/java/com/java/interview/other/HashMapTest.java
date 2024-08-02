package com.java.interview.other;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**迭代期间修改内容
 * @author liaowenhui
 * @date 2023/7/21 9:33
 */
public class HashMapTest {
    public static void main(String[] args) {
        // 创建一个 Hashtable
        HashMap<String, Integer> myMap = new HashMap<>();
        myMap.put("apple", 1);
        myMap.put("banana", 2);
        myMap.put("orange", 3);
        myMap.put("grape", 4);

        /**
         *  错误示例：在迭代期间修改内容
         *  这是因为在迭代期间删除键"banana"导致了 HashMap 的结构修改，进而触发了 ConcurrentModificationException，
         *  这是 Java 在检测到在迭代期间对集合结构的并发修改时抛出的异常。
         */
        for (Map.Entry<String, Integer> entry : myMap.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            System.out.println("Current key: " + key + ", Current value: " + value);

            if (key.equals("banana")) {
                // 在迭代期间尝试删除键"banana"
                myMap.remove(key);
            }
        }

        /**
         * 为了解决这个问题，我们可以使用 Iterator 来手动进行遍历，并使用 remove() 方法从迭代器中删除元素，而不是直接操作 HashMap：
         */
        // 正确示例：使用迭代器删除键
        Iterator<Map.Entry<String, Integer>> iterator = myMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            String key = entry.getKey();
            int value = entry.getValue();
            System.out.println("Current key: " + key + ", Current value: " + value);

            if (key.equals("banana")) {
                iterator.remove(); // 使用迭代器删除键"banana"
            }
        }
        System.out.println(myMap);

    }
}
