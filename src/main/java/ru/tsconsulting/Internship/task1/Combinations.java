package ru.tsconsulting.Internship.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Combinations {
    static List<ru.tsconsulting.Internship.task1.Person[]> createCombinations(ArrayList<ru.tsconsulting.Internship.task1.Person> in) {
        if (in.size() == 1) {
            List<Person[]> out = new ArrayList<>(1);
            Person[] p = new Person[1];
            p[0] = in.get(0);
            out.add(p);
            return out;
        } else {
            Person previousPerson = in.get(in.size() - 1);
            in.remove(in.size() - 1);
            ArrayList<Person[]> out = (ArrayList<Person[]>) createCombinations(in);
            int j = out.size();
            Person[] prev = new Person[1];
            prev[0] = previousPerson;
            out.add(prev);
            for (int i = 0; i < j; i++) {
                Person[] persons = Arrays.copyOf(out.get(i), out.get(i).length + 1);
                persons[persons.length - 1] = previousPerson;
                out.add(persons);
            }
            return out;
        }
    }
}
