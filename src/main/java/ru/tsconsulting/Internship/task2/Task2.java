package ru.tsconsulting.Internship.task2;

import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.DataFormatException;

public class Task2 {
    public static void main(String[] args)  {
//        System.out.println(System.getProperty("user.dir"));
        try {
            List<String> list1 = InputData.readDataFromFile("C:\\Users\\NMAKHAMATOV\\Desktop\\java\\input1.txt");
            List<String> list2 = InputData.readDataFromFile("C:\\Users\\NMAKHAMATOV\\Desktop\\java\\input2.txt");
            InputDataToSortedLindedList.createSortedLinkedList(list1,list2);
            System.out.println("---------------------------------------------------------------------------------");
            for (String s:InputDataToSortedLindedList.list ) {
                System.out.println(s);
            }
        } catch (IOException e) {
//            e.printStackTrace();
            System.out.println("Файл  найден");
        }
//        catch (DataFormatException e) {
//            e.getMessage();
//            System.out.println("Неверный формат данных");
//        }

    }
}
