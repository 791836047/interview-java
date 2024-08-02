package com.java.interview.other.design.filterPattern.cainiao;

import java.util.List;

/**
 * 为标准（Criteria）创建一个接口。
 * @author 79183
 * @date 2024/7/3 14:41
 */
public interface Criteria {
    public List<Person> meetCriteria(List<Person> persons);

}
