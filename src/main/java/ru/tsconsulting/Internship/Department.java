package ru.tsconsulting.Internship;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;

class Department {
    private String name;
    private ArrayList<Person> list = new ArrayList<>();

    Department(String name) { this.name = name; }

    public String getName() {
        return name;
    }
    void addPerson(Person p) {
        list.add(p);
    }

    ArrayList<Person> getListOfPersons() {
        return new ArrayList<>(list);
    }
    BigDecimal addAndRecountAverSalary(Person[] persons) {
        list.addAll(Arrays.asList(persons));
        BigDecimal temp = countAverSalary();
        list.addAll(Arrays.asList(persons));
        return temp;
    }

    BigDecimal countAverSalary() {
        BigDecimal averSalary = BigDecimal.ZERO;
        for (Person p : list) {
            averSalary = averSalary.add(p.getSalary());
        }
        BigDecimal listSize = new BigDecimal(list.size());
        return averSalary.divide(listSize,2,BigDecimal.ROUND_HALF_UP);
    }
}
