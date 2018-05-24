package ru.tsconsulting.Internship.task1;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

class InputData {
    private Map<String, Department> departments = new HashMap<>();

    Map<String, Department> getDepartments() {
        return departments;
    }

    void readDataFromFile(String way) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader(way));
        String line = br.readLine();
        while (line != null) {
            line = line.toLowerCase();
            String[] strings = line.split(",");
            try {
                if (strings.length == 3) {
                    if (!departments.containsKey(strings[1])) {
                        departments.put(strings[1].trim(), new Department(strings[1].trim()));
                    }
                    departments.get(strings[1].trim()).addPerson(new Person(strings[0].trim(),
                            new BigDecimal(strings[2].trim())));
                } else {
                    System.out.print("Неверный формат данных в файле!");
                }
                line = br.readLine();
            } catch (ArithmeticException e) {
                System.out.println("ArithmeticException has been caught");
            } catch (NumberFormatException e) {
                System.out.println("Неверный фомат зарплаты");
                line = br.readLine();
            } catch (IllegalArgumentException e) {
                System.out.println("IllegalArgumentException");
            } catch (FileNotFoundException fnfex) {
                System.out.println("Файл не найден");
            } catch (IOException ioex) {
                System.out.println("Ошибка чтения (IOException)");
            } catch (Exception e) {
                System.out.println("Exception has been caught");
            }

        }
        br.close();
    }
}
