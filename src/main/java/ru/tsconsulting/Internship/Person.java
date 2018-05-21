package ru.tsconsulting.Internship;

import java.math.BigDecimal;
import java.math.RoundingMode;

class Person {
    private String name;
    private BigDecimal salary;


    public Person(String name,BigDecimal salary) {
            this.name = name;
            this.salary = salary;
            if (this.salary.signum() < 0) {
                throw new NumberFormatException("Отрицательная зарплата");
            }
    }
    public String getName() {return name; }
    public BigDecimal getSalary() {
        return salary;
    }
}