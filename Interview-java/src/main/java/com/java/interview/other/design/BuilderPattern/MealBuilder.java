package com.java.interview.other.design.BuilderPattern;

/**
 * 创建一个 MealBuilder 类，实际的 builder 类负责创建 Meal 对象。
 * @author liaowenhui
 * @date 2023/10/30 16:07
 */
public class MealBuilder {

    //素食汉堡套餐
    public Meal prepareVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    //鸡肉汉堡套餐
    public Meal prepareNonVegMeal (){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}
