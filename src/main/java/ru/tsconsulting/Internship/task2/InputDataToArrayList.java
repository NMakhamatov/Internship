package ru.tsconsulting.Internship.task2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.zip.DataFormatException;

class InputDataToArrayList {
    static ArrayList<String> arrayList= new ArrayList<>();
    static void createArrayList(List<String> list1, List<String> list2) throws DataFormatException {
        System.out.println("ID" + "\t" + "A.VALUE" + "\t" + "B.VALUE");
        arrayList.add("ID" + "\t" + "A.VALUE" + "\t" + "B.VALUE");
        //Перебор строк первого файла
        try {
            for (String s1 : list1) {
                String[] strings1 = s1.split(",");
                if (strings1.length != 2) throw new DataFormatException("Неверный формат данных");
                Integer index1 = Integer.parseInt(strings1[0]);
                List<String> templist = new LinkedList<>();
                StringBuilder stringBuilder = new StringBuilder();
                //перебор строк второго файла
                for (String s2 : list2) {
                    String[] strings2 = s2.split(",");
                    Integer index2 = Integer.parseInt(strings2[0]);
                    if (index1.equals(index2)) {
                        templist.add(strings2[1]);
                    }
                }
                if (templist.size() != 0) {
                    for (String s:templist ) {
                        System.out.print(index1 + "\t" + strings1[1] + "\t" + s + "\n");
                        stringBuilder.append(index1).append("\t").append(strings1[1]).append("\t").append(s);
                        arrayList.add(stringBuilder.toString());
                        stringBuilder.delete(0,stringBuilder.length());
                    }
                } else {
                    System.out.println(index1 + "\t" + strings1[1]);
                    stringBuilder.append(index1).append("\t").append(strings1[1]);
                    arrayList.add(stringBuilder.toString());
                    stringBuilder.delete(0,stringBuilder.length());
                }

            }
        } catch (Exception e) {

        }
    }
}
