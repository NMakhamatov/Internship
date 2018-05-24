package ru.tsconsulting.Internship.task2;

import java.io.*;
import java.util.*;
import java.util.zip.DataFormatException;

class InputData {
//    private LinkedList<String> list1 = new LinkedList<>();
//    private LinkedList<String> list2 = new LinkedList<>();


    static List<String> readDataFromFile(String path) throws IOException {
        List<String> list = new LinkedList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(path));
        String line = bufferedReader.readLine();
        while (line != null) {
            line = line.toLowerCase();
//            String[] strings = line.split(",");
//            if (strings.length != 2) throw new DataFormatException("Неверный формат данных");
            list.add(line);
            line = bufferedReader.readLine();
        }
//            try {
//                if (strings.length == 3) {
//                    if (!departments.containsKey(strings[1])) {
//                        departments.put(strings[1].trim(), new Department(strings[1].trim()));
//                    }
//                    departments.get(strings[1].trim()).addPerson(new Person(strings[0].trim(),
//                            new BigDecimal(strings[2].trim())));
//                } else {
//                    System.out.print("Неверный формат данных в файле!");
//                }
//                line = br.readLine();
//            } catch (ArithmeticException e) {
//                System.out.println("ArithmeticException has been caught");
//            } catch (NumberFormatException e) {
//                System.out.println("Неверный фомат зарплаты");
//                line = br.readLine();
//            } catch (IllegalArgumentException e) {
//                System.out.println("IllegalArgumentException");
//            } catch (FileNotFoundException fnfex) {
//                System.out.println("Файл не найден");
//            } catch (IOException ioex) {
//                System.out.println("Ошибка чтения (IOException)");
//            } catch (Exception e) {
//                System.out.println("Exception has been caught");
//            }
//
//        }
        bufferedReader.close();
        return list;
    }
}
