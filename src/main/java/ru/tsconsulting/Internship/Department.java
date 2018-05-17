package ru.tsconsulting.Internship;

import java.math.BigDecimal;
import java.util.ArrayList;

class Department {
    private String name;
    private ArrayList<Person> list = new ArrayList<>();

    Department(String name) { this.name = name; }

    public String getName() {
        return name;
    }

    public void addPerson(Person p) {
        list.add(p);
    }

    public ArrayList<Person> getList() {
        return list;
    }

    BigDecimal countAverSalary() {
        BigDecimal averSalary = new BigDecimal(0);
        for (Person p : list) {
            averSalary = averSalary.add(p.getSalary());
        }
        BigDecimal listSize = new BigDecimal(list.size());
        return averSalary.divide(listSize);
    }
}
