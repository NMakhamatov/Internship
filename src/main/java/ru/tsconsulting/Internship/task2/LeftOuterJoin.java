package ru.tsconsulting.Internship.task2;

import java.util.*;

public class LeftOuterJoin {

    static List<String> getResultFromArrayLists(List<String> list1, List<String> list2) {
        List<String> result = new ArrayList<>(list1.size());

//перебор строк первого файла
        for (String s1 : list1) {
            String[] strings1 = s1.split(",");
            if (strings1.length != 2) ;
            Integer index1 = Integer.parseInt(strings1[0]);
            LinkedList<String> templist = new LinkedList<>();
            StringBuilder stringBuilder = new StringBuilder();
            //перебор строк второго файла
            for (String s2 : list2) {
                String[] strings2 = s2.split(",");
                Integer index2 = Integer.parseInt(strings2[0]);
                if (index1 == index2) {
                    templist.add(strings2[1]);
                }
            }
            if (templist.size() != 0) {
                for (String s : templist) {
                    stringBuilder.append(index1).append("\t").append(strings1[1]).append("\t").append(s);
                    result.add(stringBuilder.toString());
                    stringBuilder.delete(0, stringBuilder.length());
                }
            } else {
                stringBuilder.append(index1).append("\t").append(strings1[1]);
                result.add(stringBuilder.toString());
                stringBuilder.delete(0, stringBuilder.length());
            }
        }
        return result;
    }

    static List<Three<Integer, String, String>> getResultFromLinkedLists(List<Pair<Integer, String>> list1, List<Pair<Integer, String>> list2) {
        List<Three<Integer, String, String>> result = new LinkedList<>();
        for (Pair<Integer, String> pair1 : list1) {
            int index1 = pair1.getKey();
            boolean isRepeating = false;
            List<String> tempList = new LinkedList<>();
            for (Pair<Integer, String> pair2 : list2) {
                int index2 = pair2.getKey();
                if (index1 == index2) {
                    isRepeating = true;
                    tempList.add(pair2.getValue());
                }
            }
            if (!isRepeating) result.add(new Three<Integer, String, String>(index1, pair1.getValue(), ""));
            else for (String s : tempList) {
                result.add(new Three<>(index1, pair1.getValue(), s));
            }

        }
        return result;
    }

    static List<Three<Integer, String, String>> getResultFromLinkedLists2(List<Pair<Integer, String>> list1, List<Pair<Integer, String>> list2) {
        List<Three<Integer, String, String>> result = new LinkedList<>();
//        List<Pair<Integer, String>> tempList2 = new LinkedList<>(list2);

        ListIterator<Pair<Integer, String>> iterator1 = list1.listIterator();
        ListIterator<Pair<Integer, String>> iterator2 = list2.listIterator();

        Pair<Integer, String> pair1 = iterator1.next();
        Pair<Integer, String> pair2 = iterator2.next();

//        boolean isEnd1 = false;
//        boolean isEnd2 = false;

        Integer index1;
        Integer index2;

        while (true) {
            index1 = pair1.getKey();
            index2 = pair2.getKey();
            int compare = index1.compareTo(index2);

//            if (!iterator1.hasNext()) isEnd1 = true;
//            if (!iterator2.hasNext()) isEnd2 = true;

            if (compare < 0) {
                result.add(new Three<>(pair1.getKey(), pair1.getValue(), ""));
                if (iterator1.hasNext()) {
                    pair1 = iterator1.next();
                } else break;
            } else if (compare > 0) {
                if (iterator2.hasNext()) {
                    pair2 = iterator2.next();
                } else break;

            } else {
                result.add(new Three<>(pair1.getKey(), pair1.getValue(), pair2.getValue()));

                while (iterator2.hasNext()) {
                    pair2 = iterator2.next();
                    if (pair2.getKey().compareTo(pair1.getKey()) == 0)
                        result.add(new Three<Integer, String, String>(pair1.getKey(), pair1.getValue(), pair2.getValue()));
                    else break;
                }

                pair2 = iterator2.previous();

                while (iterator2.hasPrevious()) {
                    pair2 = iterator2.previous();
                    if (!(pair2.getKey().compareTo(pair1.getKey()) == 0)) break;
                }
                pair2 = iterator2.next();
                if (iterator1.hasNext()) {
                    pair1 = iterator1.next();
                } else break;
            }

            //выход из цикла
//            if (isEnd1 && isEnd2) break;
        }


        return result;
    }

    static List<Three<Integer, String, String>> getResultFromHashMaps(Map<Integer, List<String>> map1, Map<Integer, List<String>> map2) {
        List<Three<Integer, String, String>> result = new LinkedList<>();

        for (Map.Entry<Integer, List<String>> entry : map1.entrySet()) {
            int index1 = entry.getKey();
            if (map2.containsKey(index1)) {
                for (String s1 : map1.get(index1)) {
                    for (String s2 : map2.get(index1)) {
                        result.add(new Three<Integer, String, String>(index1, s1, s2));
                    }
                }
            } else {
                for (String s : map1.get(index1)) {
                    result.add(new Three<Integer, String, String>(index1, s, ""));
                }
            }
        }
        return result;
    }
}
