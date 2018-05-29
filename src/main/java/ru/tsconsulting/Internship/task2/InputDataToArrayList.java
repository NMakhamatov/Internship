package ru.tsconsulting.Internship.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.DataFormatException;

class InputDataToArrayList {

    static List<String> createArrayList(List<String> list) {
        List<String> arrayList = new ArrayList<>();
//        System.out.println("ID" + "\t" + "A.VALUE" + "\t" + "B.VALUE");
//        arrayList.add("ID" + "\t" + "A.VALUE" + "\t" + "B.VALUE");

        for (String s1 : list) {
            try {
                String[] strings1 = s1.split(",");
                if (strings1.length != 2) throw new DataFormatException("Неверный формат данных");
                Integer index1 = Integer.parseInt(strings1[0]);
                arrayList.add(s1);
            } catch (DataFormatException e) {
                System.out.println("Неверный формат строки");
            }catch (NumberFormatException e) {
                System.out.print("Неверный формат ID");
            }catch (Exception e) {
                System.out.println("Exception has been caught");
            }
        }
        ((ArrayList<String>) arrayList).trimToSize();
        return arrayList;
    }
}
