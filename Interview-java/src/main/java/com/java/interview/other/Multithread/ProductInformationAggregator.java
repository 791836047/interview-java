package com.java.interview.other.Multithread;

import lombok.Data;

import java.util.concurrent.*;

/**
 *  chatgpt： 使用java实现：用户要查看一个商品的信息，需要将商品维度的一系列信息如商品的价格、优惠、库存、图片等等聚合起来，展示给用户，要求使用多线程的方式
 * @author liaowenhui
 * @date 2023/7/18 14:57
 */
public class ProductInformationAggregator {
    public static void main(String[] args) {
        // 创建线程池
        ExecutorService executor = Executors.newFixedThreadPool(3);

        //创建一个自己定义的线程池，使用自己定义的线程工厂
      /*  ExecutorService executor = new ThreadPoolExecutor(
                3,
                3,
                0,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue(10));*/

        // 商品ID
        String productId = "product1";

        // 创建商品服务、库存服务和优惠服务的任务
        Callable<Product> priceTask = new ProductInformationFetcher(productId);
        Callable<Integer> stockTask = new ProductStockFetcher(productId);
        Callable<Double> discountTask = new ProductDiscountFetcher(productId);

        // 提交任务到线程池获取商品信息
        //注意executor.execute();不能接收返回值
        Future<Product> priceFuture = executor.submit(priceTask);
        Future<Integer> stockFuture = executor.submit(stockTask);
        Future<Double> discountFuture = executor.submit(discountTask);

        try {
            // 获取商品信息
            double price = priceFuture.get().price;
            int stock = stockFuture.get();
            double discount = discountFuture.get();

            // 展示商品信息给用户
            displayProductInformation(productId, price, stock, discount);
        } catch (InterruptedException | ExecutionException e) {
            // 处理异常
            e.printStackTrace();
        }finally {
            // 关闭线程池
            executor.shutdown();
        }

    }

    // 任务一：获取商品
    private static class ProductInformationFetcher implements Callable<Product> {
        private String productId;

        public ProductInformationFetcher(String productId) {
            this.productId = productId;
        }

        @Override
        public Product call() throws Exception {
            // 模拟调用商品service获取商品信息的耗时操作
            Thread.sleep(1000);

            // 获取商品信息并返回
            Product product = new Product();
            product.setId(productId);
            product.setPrice(19.99);
            product.setDiscount(0.2);
            product.setStock(100);
            product.setImageUrl("https://example.com/product1.jpg");
            return product;
        }
    }

    // 任务二：获取商品库存
    private static class ProductStockFetcher implements Callable<Integer> {
        private String productId;

        public ProductStockFetcher(String productId) {
            this.productId = productId;
        }

        @Override
        public Integer call() throws Exception {
            int i=1/0;

            // 模拟调用库存service获取商品库存的耗时操作
            Thread.sleep(2000);

            // 获取商品库存并返回
            // 假设从库存服务获取库存
            int stock = 100;
            return stock;
        }
    }

    // 任务三：获取商品优惠
    private static class ProductDiscountFetcher implements Callable<Double> {
        private String productId;

        public ProductDiscountFetcher(String productId) {
            this.productId = productId;
        }

        @Override
        public Double call() throws Exception {
            // 模拟调用优惠service获取商品优惠的耗时操作
            Thread.sleep(3000);

            // 获取商品优惠并返回
            // 假设从优惠服务获取优惠
            double discount = 0.2;
            return discount;
        }
    }

    // 展示商品信息给用户
    private static void displayProductInformation(String productId, double price, int stock, double discount) {
        System.out.println("Product ID: " + productId);
        System.out.println("Price: $" + price);
        System.out.println("Stock: " + stock);
        System.out.println("Discount: " + discount * 100 + "%");
    }

    // 商品信息类
    @Data
    private static class Product {
        private String id;
        private double price;
        private double discount;
        private int stock;
        private String imageUrl;

        // 省略构造函数和getter/setter方法
    }
}
