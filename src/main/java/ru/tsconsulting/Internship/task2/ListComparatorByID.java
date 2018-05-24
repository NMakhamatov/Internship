package ru.tsconsulting.Internship.task2;

import java.util.Comparator;

public class ListComparatorByID implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int index1,index2;
        index1 = o1.charAt(0);
        index2 = o2.charAt(0);
        return Integer.compare(index1, index2);
    }
}
