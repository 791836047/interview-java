package com.java.interview.other.design.filterPattern.cainiao;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 79183
 * @date 2024/7/3 14:42
 */
public class CriteriaFemale implements Criteria {

    @Override
    public List<Person> meetCriteria(List<Person> persons) {
        List<Person> femalePersons = new ArrayList<Person>();
        for (Person person : persons) {
            if(person.getGender().equalsIgnoreCase("FEMALE")){
                femalePersons.add(person);
            }
        }
        return femalePersons;
    }
}
