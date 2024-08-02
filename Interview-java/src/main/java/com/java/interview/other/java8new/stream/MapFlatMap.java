package com.java.interview.other.java8new.stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

/**
 *  映射，可以将一个流的元素按照一定的映射规则映射到另一个流中。分为map和flatMap：
 *  map：接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
 *  flatMap：接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。
 * @author liaowenhui
 * @date 2022/1/11 18:31
 */
public class MapFlatMap {
    public static void main(String[] args) {
        String[] strArr = { "abcd", "bcdd", "defde", "fTr" };
        List<String> strList = Arrays.stream(strArr).map(String::toUpperCase).collect(toList());

        List<Integer> intList = Arrays.asList(1, 3, 5, 7, 9, 11);
        List<Integer> intListNew = intList.stream().map(x -> x + 3).collect(toList());

        System.out.println("每个元素大写：" + strList);
        System.out.println("每个元素+3：" + intListNew);

        /**
         * https://blog.csdn.net/Xumuyang_/article/details/120951979
         * flatMap的使用
         * 给定单词列表["Hello","World"]，你想要返回去重后的列表["H","e","l", "o","W","r","d"]
         * 作用：获取订单流下面多个商品的集合
         */
        String[] strArr2 = { "hello", "world"};
        //不满足
        List<String[]> collect = Arrays.stream(strArr2)
                .map(word -> word.split(""))
                .distinct()
                .collect(toList());
        //你需要一个字符流，而不是数组流。有一个叫作Arrays.stream()的方法可以接受一个数组并产生一个流
        //不满足
        List<Stream<String>> collect1 = Arrays.stream(strArr2)
                .map(word -> word.split(""))
                .map(Arrays::stream)
                .distinct()
                .collect(toList());
        //满足
        List<String> collect2 = Arrays.stream(strArr2)
                //将每个单词转换为由其字母构成的数组
                .map(w -> w.split(""))
                //将各个生成流扁平化为单个流
                .flatMap(Arrays::stream)
                .distinct()
                .collect(toList());


        //实战

    }
}
