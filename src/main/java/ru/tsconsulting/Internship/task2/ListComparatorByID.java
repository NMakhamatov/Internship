package ru.tsconsulting.Internship.task2;

import java.util.Comparator;

public class ListComparatorByID implements Comparator<Pair<Integer,String>> {
    @Override
    public int compare(Pair<Integer,String> pair1, Pair<Integer,String> pair2) {
        int index1,index2;
        index1 = pair1.getKey();
        index2 = pair2.getKey();
        int compare = Integer.compare(index1, index2);
        if (compare == 0) {
            return pair1.getValue().compareTo(pair2.getValue());
        } else return compare;
    }
}
