package ru.tsconsulting.Internship.task1;

import java.io.IOException;
import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        if (args.length != 0) {
            InputData inputData = new InputData();
            try {
                inputData.readDataFromFile(args[0]);
                Map<String, Department> departments = inputData.getDepartments();
                PrintToFile printToFile = new PrintToFile(args[0]);
                printToFile.printResultsToFile(departments);
            } catch (IOException e) {
                System.out.println("IOException has been caught. Invalid path to the file");
            }

//            for (Map.Entry<String,Department> entry: departments.entrySet()) {
//                System.out.println(entry.getKey() + ":");
//                for (Person person:entry.getValue().getListOfPersons()   ) {
//                    System.out.println(person.getName());
//                }
//            }
        } else System.out.println("Введите путь к файлу");
    }
}