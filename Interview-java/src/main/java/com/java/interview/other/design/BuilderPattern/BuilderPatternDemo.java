package com.java.interview.other.design.BuilderPattern;

/**
 * @author liaowenhui
 * @date 2023/10/30 16:08
 */
public class BuilderPatternDemo {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();

        Meal vegMeal = mealBuilder.prepareVegMeal();
        System.out.println("Veg Meal");
        vegMeal.showItems();
        //总消费
        System.out.println("Total Cost: " +vegMeal.getCost());

        Meal nonVegMeal = mealBuilder.prepareNonVegMeal();
        System.out.println("\n\nNon-Veg Meal");
        nonVegMeal.showItems();
        //总消费
        System.out.println("Total Cost: " +nonVegMeal.getCost());
    }
}
