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

//    public void setName(String name) {
//        this.name = name;
//    }
//    public void setSalary(String salary) {
//        try {this.salary = new BigDecimal(salary).setScale(2);}
//        catch (NumberFormatException ex) {
//            System.out.println("Указана неверная зарплата");
//
//        }
//        catch (ArithmeticException e) {
//            System.out.println("Неверный формат зарплаты");
//        }
//    }
    public String getName() {return name; }
    public BigDecimal getSalary() {
        return salary;
    }
}