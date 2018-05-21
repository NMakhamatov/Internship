package ru.tsconsulting.Internship;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintToFile {
    private String inputFileName;
//    private ArrayList<String> toPrint;
    private Map<String,List<Person[]>> combinations = new HashMap<>();


//    public void setToPrint(ArrayList<String> toPrint) {
//        this.toPrint = toPrint;
//    }

    public PrintToFile(String inputFileName, Map<String,Department> map) {
        this.inputFileName = inputFileName;
        for (Map.Entry<String,Department> entry:map.entrySet() ) {
            combinations.put(entry.getKey(),Comb.createCombinations(entry.getValue().getListOfPersons()));
        }
    }


    void method(Map<String,Department> map) {
        int indexOfSlash = inputFileName.lastIndexOf("\\");
        String folder = inputFileName.substring(0, indexOfSlash + 1);
        try (FileWriter fw = new FileWriter(folder + "Out.txt");
             PrintWriter pw = new PrintWriter(fw)) {
//            BigDecimal averSalary = new BigDecimal()
            for (Map.Entry<String,List<Person[]>> entry: combinations.entrySet()           ) {
                BigDecimal averSalary = map.get(entry.getKey()).countAverSalary(); /////!!!!!!
//                BigDecimal averSalaryy = map.get("hr").countAverSalary();
                System.out.println(entry.getKey());
                System.out.println("Average salary:" +averSalary);
                for (Person[] persons:entry.getValue() ) {
                    BigDecimal sum = BigDecimal.ZERO;
                    String employees = "";
                    for (Person p: persons   ) {
                        sum = sum.add(p.getSalary());
                        employees += p.getName() + ",";
                    }
                    employees = employees.substring(0,employees.length()-1);
                    sum = sum.divide(new BigDecimal(persons.length), 2);
                    System.out.println("Сотрудники:" + employees +" Sum = " + sum);
                    for (Map.Entry<String,Department> deps: map.entrySet()         ) {
                        BigDecimal averSalary2 = deps.getValue().countAverSalary();
                        if ((sum.compareTo(averSalary)<0) && (sum.compareTo(averSalary2) > 0 )){
                            System.out.println("Сотрудники: " + employees + " могут перейти в отдел: "
                                    + deps.getKey());
                            pw.print("Сотрудники: " + employees + " могут перейти в отдел: "
                                    + deps.getKey());
                        }
                    }
                }

            }



//            for (String s : toPrint) {
//                pw.println(s);
//            }
//            if (!toPrint.isEmpty()) {
//                System.out.println("Результаты сохранены в: " + folder + "Out.txt");
//            }
        } catch (IOException ex) {
            System.out.print("IOException has been caught");
        }
    }
}
