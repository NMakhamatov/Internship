package ru.tsconsulting.Internship;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        if (args.length != 0) {
            ReadInputData inputData = new ReadInputData(args[0]);
            Map<String, Department> departments = inputData.getDepartments();
            PrintToFile printToFile = new PrintToFile(args[0],departments);
            printToFile.method(departments);
        } else System.out.println("Введите путь к файлу");
    }
}