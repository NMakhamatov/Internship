package ru.tsconsulting.Internship;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;

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

    public ArrayList<Person> getListOfPersons() {
        return new ArrayList<Person>(list);
    }
    public BigDecimal addAndRecountAverSalary(Person[] persons) {
        for (Person p: persons) {
            list.add(p);
        }
        BigDecimal temp = countAverSalary();
        for (Person p: persons) {
            list.remove(p);
        }
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
