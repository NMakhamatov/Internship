package ru.tsconsulting.Internship;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrintToFile {
    private String inputFileName;

    public PrintToFile(String inputFileName) {
        this.inputFileName = inputFileName;
    }

    void printResultsToFile(Map<String, Department> map) {
        Map<String, List<Person[]>> combinations = new HashMap<>();
        for (Map.Entry<String, Department> entry : map.entrySet()) {
            combinations.put(entry.getKey(), Combinations.createCombinations(entry.getValue().getListOfPersons()));
        }
        int indexOfSlash = inputFileName.lastIndexOf("\\");
        String folder = inputFileName.substring(0, indexOfSlash + 1);
        try (FileWriter fw = new FileWriter(folder + "Out.txt");
             PrintWriter pw = new PrintWriter(fw)) {
            for (Map.Entry<String, List<Person[]>> entry : combinations.entrySet()) {
                BigDecimal averSalary = map.get(entry.getKey()).countAverSalary();
                for (Person[] persons : entry.getValue()) {
                    BigDecimal sum = BigDecimal.ZERO;
                    StringBuilder employees = new StringBuilder();
//                    String employees = "";
                    for (Person per : persons) {
                        sum = sum.add(per.getSalary());
//                        employees += per.getName() + ",";
                        employees = employees.append(per.getName());
                        employees = employees.append(",");
                    }
//                    employees = employees.substring(0, employees.length() - 1);
                    employees.deleteCharAt(employees.length()-1);
                    sum = sum.divide(new BigDecimal(persons.length), 2);
                    for (Map.Entry<String, Department> deps : map.entrySet()) {
                        BigDecimal averSalary2 = deps.getValue().countAverSalary();
                        if ((sum.compareTo(averSalary) < 0) && (sum.compareTo(averSalary2) > 0)) {
                            pw.println("Сотрудники: " + employees + " могут перейти из отдела " +
                                    entry.getKey() + " со средней зп " + averSalary + " в отдел "
                                    + deps.getKey() + " со средней зп (старая:" + averSalary2 +
                                    " => новая:" + addAndRecountSalary(sum,averSalary2,
                                    deps.getValue().getListOfPersons().size())   + ")");
                        }
                    }
                }
            }
        } catch (IOException ex) {
            System.out.print("IOException has been caught");
        } catch (Exception e) {
            System.out.println("Exception has been caught");
        }
        System.out.println("Результаты сохранены в:" + folder + "Out.txt");
    }
    private BigDecimal addAndRecountSalary(BigDecimal addingSalary,BigDecimal prevAverSalary,int amount) {
        BigDecimal result = addingSalary.add(prevAverSalary.negate());
        result = result.divide(new BigDecimal(amount+1),2,BigDecimal.ROUND_HALF_UP);
        return result;
    }
}
