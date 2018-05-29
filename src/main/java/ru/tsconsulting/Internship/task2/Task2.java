package ru.tsconsulting.Internship.task2;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Task2 {
    public static void main(String[] args) {
//        System.out.println(System.getProperty("user.dir"));
        try {
            List<String> file1 = InputData.readDataFromFile("C:\\Users\\NMAKHAMATOV\\IdeaProjects\\Internship\\src\\main\\resources\\input1.txt");
            List<String> file2 = InputData.readDataFromFile("C:\\Users\\NMAKHAMATOV\\IdeaProjects\\Internship\\src\\main\\resources\\input2.txt");

            List<String> arraylist1 = InputDataToArrayList.createArrayList(file1);
            List<String> arraylist2 = InputDataToArrayList.createArrayList(file2);

            List<Pair<Integer, String>> linkedList1 = InputDataToSortedLinkedList.createSortedLinkedList(arraylist1);
            List<Pair<Integer, String>> linkedList2 = InputDataToSortedLinkedList.createSortedLinkedList(arraylist2);

            Map<Integer, List<String>> map1 = InputDataToHashMap.createHashMap(linkedList1);
            Map<Integer, List<String>> map2 = InputDataToHashMap.createHashMap(linkedList2);

            List<String> resultFromArrayLists = LeftOuterJoin.getResultFromArrayLists(arraylist1, arraylist2);
            List<Three<Integer, String, String>> resultFromLinkedLists = LeftOuterJoin.getResultFromLinkedLists(linkedList1, linkedList2);
            List<Three<Integer,String,String>> resultFromHashMaps = LeftOuterJoin.getResultFromHashMaps(map1,map2);

            System.out.println("File №1:");
            for (String s : arraylist1) {

                System.out.println(s);
            }
            System.out.println("File №2:");
            for (String s : arraylist2) {

                System.out.println(s);
            }
            System.out.println("====   RESULT 1:   =====");
            for (String s : resultFromArrayLists) {
                System.out.println(s);
            }
            System.out.println("====   RESULT 2:   =====");
            for (Three<Integer, String, String> three : resultFromLinkedLists) {
                System.out.println(three.getKey() + "\t" + three.getValue1() +
                        "\t" + three.getValue2());
            }
                System.out.println("====   RESULT 3:   =====");

            for (Three<Integer, String, String> three : resultFromHashMaps) {
                System.out.println(three.getKey() + "\t" + three.getValue1() +
                        "\t" + three.getValue2());
            }

        } catch (IOException e) {
            System.out.println("Файл  найден");
        }
    }
}
