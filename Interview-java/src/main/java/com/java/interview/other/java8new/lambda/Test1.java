package com.java.interview.other.java8new.lambda;

/**
 * lambda 表达式只能引用标记了 final 的外层局部变量，这就是说不能在 lambda 内部修改定义在域外的局部变量，否则会编译错误。
 * @author liaowenhui
 * @date 2022/1/12 10:16
 */
public class Test1 {
    final static String salutation = "Hello! ";

    public static void main(String[] args) {
        System.out.println("------------------------------示例1--------------------------------");
        //函数式接口(Functional Interface)就是一个有且仅有一个抽象方法，但是可以有多个非抽象方法的接口。函数式接口可以被隐式转换为 lambda 表达式。
        //转为lambda表达式后，message相当于请求参数,System.out.println(salutation + message);就是方法的实现
        GreetingService greetService1 = new GreetingService() {
            @Override
            public void sayMessage(String message) {
                System.out.println(salutation + message);
            }
        };
        greetService1.sayMessage("Runoob");

        System.out.println("------------------------------示例2--------------------------------");
        final int num = 1;
        //转为lambda表达式后，param相当于参数i,System.out.println((param + num))就是方法的实现
        Converter<Integer, String> s = new Converter<Integer, String>() {
            @Override
            public void convert(Integer param) {
                System.out.println((param + num));
            }
        };
        // 输出结果为 3
        s.convert(2);

    }

    /**
     * 接口中每一个方法也是隐式抽象的,接口中的方法会被隐式的指定为 public abstract（只能是 public abstract，其他修饰符都会报错）。
     */
    interface GreetingService {
        void sayMessage(String message);
    }

    public interface Converter<T1, T2> {
        void convert(T1 i);
    }

}
