package ru.tsconsulting.Internship.task2;

import java.util.*;

public class InputDataToHashMap {

    static Map<Integer, List<String>> createHashMap(List<Pair<Integer,String>> list) {
        Map<Integer, List<String>> map = new HashMap<>(list.size());
        for (Pair<Integer,String> entry: list) {
            int index = entry.getKey();
            if (!map.containsKey(index)) {
                map.put(index,new LinkedList<String>());
            }
            map.get(index).add(entry.getValue());
        }
        return map;
    }
}
