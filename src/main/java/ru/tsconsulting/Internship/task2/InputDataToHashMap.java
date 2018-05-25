package ru.tsconsulting.Internship.task2;

import java.util.*;
import java.util.zip.DataFormatException;

public class InputDataToHashMap {

    static Map<Integer, LinkedList<String>> map = new HashMap<>();

    static void createHashMap(List<String> list1, List<String> list2) {

//        List<String> list2 = l2;

        System.out.println("ID" + "\t" + "A.VALUE" + "\t" + "B.VALUE");
        //Перебор строк первого файла

        for (String s1 : list1) {
            try {
                String[] strings1 = s1.split(",");
                if (strings1.length != 2) {
                    throw new DataFormatException("Неверный формат данных");
                }
                Integer index1 = Integer.parseInt(strings1[0]);
                LinkedList<String> templist = new LinkedList<>();
                StringBuilder stringBuilder = new StringBuilder();
                if (!map.containsKey(index1)) {
                    map.put(index1, new LinkedList<String>());
                }
                //перебор строк второго файла
                for (String s2 : list2) {
                    String[] strings2 = s2.split(",");
                    Integer index2 = Integer.parseInt(strings2[0]);
                    if (index1.equals(index2)) {
                        templist.add(strings2[1]);
                    }
                }
                if (templist.size() != 0) {
                    for (String s : templist) {
                        System.out.print(index1 + "\t" + strings1[1] + "\t" + s + "\n");
                        stringBuilder.append("\t").append(strings1[1]).append("\t").append(s);
                        map.get(index1).add(stringBuilder.toString());
                        stringBuilder.delete(0, stringBuilder.length());
                    }
                } else {
                    System.out.println(index1 + "\t" + strings1[1]);
                    stringBuilder.append("\t").append(strings1[1]);
                    map.get(index1).add(stringBuilder.toString());
                    stringBuilder.delete(0, stringBuilder.length());
                }
            }catch (DataFormatException e) {
                System.out.println("Неверный формат строки");
            }catch (NumberFormatException e) {
                System.out.print("Неверный формат ID");
            }catch (Exception e) {
                System.out.println("Exception has been caught");
            }
        }

    }
}