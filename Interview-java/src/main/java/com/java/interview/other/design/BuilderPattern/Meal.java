package com.java.interview.other.design.BuilderPattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 创建一个 Meal 类，带有上面定义的 Item 对象。
 * @author liaowenhui
 * @date 2023/10/30 16:07
 */
public class Meal {
    private List<Item> items = new ArrayList<>();

    public void addItem(Item item){
        items.add(item);
    }

    public float getCost(){
        float cost = 0.0f;
        for (Item item : items) {
            cost += item.price();
        }
        return cost;
    }

    public void showItems(){
        for (Item item : items) {
            System.out.print("Item : "+item.name());
            System.out.print(", Packing : "+item.packing().pack());
            System.out.println(", Price : "+item.price());
        }
    }
}
