package com.java.interview.other;
import cn.hutool.json.JSONUtil;
import lombok.Data;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.IsoFields;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author liaowenhui
 * @date 2023/3/28 14:26
 */
@Data
public class Entity {

    private LocalDate date;
    private BigDecimal consumption;
    private BigDecimal balance;
    private String dateString;

    public Entity() {
    }

    public Entity(LocalDate date, BigDecimal consumption, BigDecimal balance) {
        this.date = date;
        this.consumption = consumption;
        this.balance = balance;
    }


    public static void main(String[] args) {
        List<Entity> entities = new ArrayList<>();
        entities.add(new Entity(LocalDate.of(2023, 2, 25), new BigDecimal("100"), new BigDecimal("100")));
        entities.add(new Entity(LocalDate.of(2023, 2, 26), new BigDecimal("100"), new BigDecimal("100")));
        entities.add(new Entity(LocalDate.of(2023, 2, 27), new BigDecimal("100"), new BigDecimal("100")));
        entities.add(new Entity(LocalDate.of(2023, 2, 28), new BigDecimal("100"), new BigDecimal("100")));
        entities.add(new Entity(LocalDate.of(2023, 3, 1), new BigDecimal("100"), new BigDecimal("100")));
        entities.add(new Entity(LocalDate.of(2023, 3, 2), new BigDecimal("200"), new BigDecimal("200")));
        entities.add(new Entity(LocalDate.of(2023, 3, 3), new BigDecimal("300"), new BigDecimal("300")));
        entities.add(new Entity(LocalDate.of(2023, 3, 4), new BigDecimal("400"), new BigDecimal("400")));
        entities.add(new Entity(LocalDate.of(2023, 3, 5), new BigDecimal("500"), new BigDecimal("500")));
        entities.add(new Entity(LocalDate.of(2023, 3, 6), new BigDecimal("600"), new BigDecimal("600")));
        entities.add(new Entity(LocalDate.of(2023, 3, 7), new BigDecimal("700"), new BigDecimal("700")));

        //按周查询
        List<Entity> weekQueryResult = entities.parallelStream()
                .peek(e -> {
                    LocalDate date = e.getDate();
                    //转为2023-03-27至2023-04-02的形式
                    e.setDateString(date.minusDays(date.getDayOfWeek().getValue() - 1).toString()
                            + "至" + date.plusDays(DayOfWeek.SUNDAY.getValue() - date.getDayOfWeek().getValue()).toString());
                })
                .collect(Collectors.groupingBy(Entity::getDateString))
                .values()
                .stream()
                .flatMap(list -> Stream.of(list.stream().reduce((data1, data2) -> {
                    data1.setConsumption(data1.getConsumption().add(data2.getConsumption()));
                    data1.setBalance(data1.getBalance().add(data2.getBalance()));
                    return data1;
                }).orElse(null)))
                .collect(Collectors.toList());
        System.out.println("按周查询" + JSONUtil.toJsonStr(weekQueryResult));


        List<Entity> entities2 = new ArrayList<>();
        entities2.add(new Entity(LocalDate.of(2023, 2, 25), new BigDecimal("100"), new BigDecimal("100")));
        entities2.add(new Entity(LocalDate.of(2023, 2, 26), new BigDecimal("100"), new BigDecimal("100")));
        entities2.add(new Entity(LocalDate.of(2023, 2, 27), new BigDecimal("100"), new BigDecimal("100")));
        entities2.add(new Entity(LocalDate.of(2023, 2, 28), new BigDecimal("100"), new BigDecimal("100")));
        entities2.add(new Entity(LocalDate.of(2023, 3, 1), new BigDecimal("100"), new BigDecimal("100")));
        entities2.add(new Entity(LocalDate.of(2023, 3, 2), new BigDecimal("200"), new BigDecimal("200")));
        entities2.add(new Entity(LocalDate.of(2023, 3, 3), new BigDecimal("300"), new BigDecimal("300")));
        entities2.add(new Entity(LocalDate.of(2023, 3, 4), new BigDecimal("400"), new BigDecimal("400")));
        entities2.add(new Entity(LocalDate.of(2023, 3, 5), new BigDecimal("500"), new BigDecimal("500")));
        entities2.add(new Entity(LocalDate.of(2023, 3, 6), new BigDecimal("600"), new BigDecimal("600")));
        entities2.add(new Entity(LocalDate.of(2023, 3, 7), new BigDecimal("700"), new BigDecimal("700")));

        //按月查询
        List<Entity> monthQueryResult = entities2.parallelStream()
                .peek(e -> {
                    LocalDate dateTime = e.getDate();
                    e.setDateString(String.format("%d年%d月", dateTime.getYear(), dateTime.getMonthValue()));
                })
                .collect(Collectors.groupingBy(Entity::getDateString))
                .values()
                .stream()
                .flatMap(list -> Stream.of(list.stream().reduce((data1, data2) -> {
                    data1.setConsumption(data1.getConsumption().add(data2.getConsumption()));
                    data1.setBalance(data1.getBalance().add(data2.getBalance()));
                    return data1;
                }).orElse(null)))
                .collect(Collectors.toList());
        System.out.println("按月查询" + JSONUtil.toJsonStr(monthQueryResult));
    }


}
