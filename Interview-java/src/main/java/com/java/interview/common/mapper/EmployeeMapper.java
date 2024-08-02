package com.java.interview.common.mapper;

;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.java.interview.common.entity.Employee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 *
 * @author liaowenhui
 * @date 2023/1/17 13:48
 */

@Repository
public interface EmployeeMapper extends BaseMapper<Employee> {

    @Insert({
            "<script>",
            "INSERT INTO employee(age,employee_name,id_number,birth_date,creat_time) VALUES " +
             "<foreach collection='employees' item='employee' separator=','>",
            "(#{employee.age},#{employee.employeeName},#{employee.idNumber},#{employee.birthDate},#{employee.creatTime})",
            "</foreach>",
            "</script>"
    })
    int saveBatch(@Param("employees") List<Employee> employee);
}
