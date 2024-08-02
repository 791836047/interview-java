package com.java.interview.other.design.filterPattern.cainiao;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 79183
 * @date 2024/7/3 14:41
 */
public class CriteriaMale implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> malePersons = new ArrayList<Person>();
        for (Person person : persons) {
            if(person.getGender().equalsIgnoreCase("MALE")){
                malePersons.add(person);
            }
        }
        return malePersons;
    }
}
