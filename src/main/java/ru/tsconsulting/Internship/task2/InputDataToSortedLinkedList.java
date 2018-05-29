package ru.tsconsulting.Internship.task2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public  class InputDataToSortedLinkedList {

    static List<Pair<Integer,String>> createSortedLinkedList(List<String> list) {
        List<Pair<Integer,String>> linkedList = new LinkedList<>();

        for (String s:list) {
            String[] strings = s.split(",");
            Integer integer = Integer.parseInt(strings[0]);
            linkedList.add(new Pair<Integer, String>(integer,strings[1]));
        }
        Collections.sort(linkedList, new ListComparatorByID());
        return linkedList;
    }
}
