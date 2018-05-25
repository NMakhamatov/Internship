package ru.tsconsulting.Internship.task2;

import java.io.*;
import java.util.*;

class InputData {

    static List<String> readDataFromFile(String path) throws IOException {
        List<String> list = new LinkedList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String line = bufferedReader.readLine();
        while (line != null) {
            line = line.toLowerCase();
            list.add(line);
            line = bufferedReader.readLine();
        }
        bufferedReader.close();
        return list;
    }
}
