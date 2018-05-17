package ru.tsconsulting.Internship;

import java.util.*;

public class Task1 {
    public static void main(String[] args) {
        if (args.length != 0) {
            GetInputData inputData = new GetInputData(args[0]);
            Map<String, Department> map = inputData.getDepartments();
            Combinations combinations = new Combinations(map);
            combinations.findCombinations(map);
            PrintToFile ptfile = new PrintToFile(args[0]);
            ptfile.setToPrint(combinations.getToPrint());
            ptfile.method();
        } else System.out.println("Введите путь к файлу");
//        for (Map.Entry<String,ArrayList<Person[]>> entry: leavingPersons.entrySet()) {
//            System.out.print("Department " + entry.getKey() + " has following combinations: \n");
//            ArrayList<Person[]>  arrayList = entry.getValue();
//            for (Person[] list: arrayList) {
//                for (int i = 0; i < list.length; i++) {
//
//                }
//                for (Person person: list) {
//                    System.out.println(person.getName() + " ");
//                }
//                System.out.println();
//            }
//
//        }
//        ptfile.method();
//        int i = 5;
//        Task1 task1 = new Task1();
//        System.out.println(task1.fact(i));

    }
//     int fact(int n) {
//        if (n == 1) {return 1;}
//        return  n*fact(n-1);
//    }

//    void printToFile(String inputFileName, Map<String,Department> map) throws IOException {
//        int indexOfSlash = inputFileName.lastIndexOf("\\");
//        String folder = inputFileName.substring(0,indexOfSlash+1);
//        FileWriter fw = new FileWriter(folder + "Out.txt");
//        PrintWriter pw = new PrintWriter(fw);
//
//        Collection<Department> departmentList = map.values();
//        for (Department d: departmentList) {
//            ArrayList<Person> persons = d.getList();
//            for (Person p : persons) {
//                BigDecimal salary = p.getSalary();
//                pw.print("Сотрудник " + p.getName() + " может перейти из отдела " + d.getName() + " в отделы: ");
//                for (Department d2 : departmentList) {
//                    if (salary.compareTo(d.countAverSalary(d.getList()))<0 && salary.compareTo(d2.countAverSalary(d2.getList()))>0) {
//                        pw.print(d2.getName() + ", ");
//                    }
//                }
//                pw.println();
//            }
//        }
//        pw.flush();
//        pw.close();
//    }

}




