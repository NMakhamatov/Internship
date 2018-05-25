package ru.tsconsulting.Internship.task2;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Task2 {
    public static void main(String[] args) {
//        System.out.println(System.getProperty("user.dir"));
        try {
            List<String> list1 = InputData.readDataFromFile("C:\\Users\\NMAKHAMATOV\\Desktop\\java\\input1.txt");
            List<String> list2 = InputData.readDataFromFile("C:\\Users\\NMAKHAMATOV\\Desktop\\java\\input2.txt");
//            InputDataToArrayList.createArrayList(list1,list2);
//            InputDataToSortedLindedList.createSortedLinkedList(list1,list2);
            InputDataToHashMap.createHashMap(list1, list2);
            System.out.println("---------------------------------------------------------------------------------");
            //вывод ArrayList на экран
//            for (String s: InputDataToArrayList.arrayList) {
//                System.out.println(s);
//            }
            //вывод SortedLinkedList на экран
//            for (String s:InputDataToSortedLindedList.list ) {
//                System.out.println(s);
//            }
            //вывод HashMap на экран
            for (Map.Entry<Integer, LinkedList<String>> entry : InputDataToHashMap.map.entrySet()) {
                for (String s : entry.getValue()) {
                    System.out.println(entry.getKey() + s);
                }
            }
        } catch (IOException e) {
            System.out.println("Файл  найден");
        }
    }
}
