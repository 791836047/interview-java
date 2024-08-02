package com.java.interview.common.entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

/**
 *
 * @author liaowenhui
 * @date 2023/1/17 10:31
 */
@Data
public class Employee {
    @TableId(value = "employee_id", type = IdType.AUTO)
    private Long employeeId;
    private Integer age;
    private String employeeName;
    private Integer idNumber;
    private LocalDateTime birthDate;
    private LocalDateTime createTime;

    public Employee(Integer age, String employeeName, Integer idNumber, LocalDateTime birthDate) {
        this.age = age;
        this.employeeName = employeeName;
        this.idNumber = idNumber;
        this.birthDate = birthDate;
    }

    public Employee() {
    }
}
