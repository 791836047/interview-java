package com.java.interview.other.generics;

/**
 * https://www.runoob.com/java/java-generics.html
 * 泛型方法--有界的类型参数:
 * @author liaowenhui
 * @date 2022/7/6 11:25
 */
public class MaximumTest {

    // 比较三个值并返回最大值
    public static <T extends Comparable<T>> T maximum(T x, T y, T z)
    {
        // 假设x是初始最大值
        T max = x;
        if ( y.compareTo( max ) > 0 ){
            //y 更大
            max = y;
        }
        if ( z.compareTo( max ) > 0 ){
            // 现在 z 更大
            max = z;
        }
        // 返回最大对象
        return max;
    }
    public static void main( String args[] )
    {
        System.out.printf( "%d, %d 和 %d 中最大的数为 %d\n\n",
                3, 4, 5, maximum( 3, 4, 5 ) );

        System.out.printf( "%.1f, %.1f 和 %.1f 中最大的数为 %.1f\n\n",
                6.6, 8.8, 7.7, maximum( 6.6, 8.8, 7.7 ) );

        System.out.printf( "%s, %s 和 %s 中最大的数为 %s\n","pear",
                "apple", "orange", maximum( "pear", "apple", "orange" ) );
    }
}
