package ru.tsconsulting.Internship;

import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class ReadInputData {
    private Map<String, Department> departments = new HashMap<>();

    public Map<String, Department> getDepartments() {
        return departments;
    }

    public ReadInputData(String s) {
        readData(s);
    }

    private void readData(String way) {
        try (
                BufferedReader br = new BufferedReader(new FileReader(way))) {
            String line = br.readLine();
            while (line != null) {
                line = line.toLowerCase();
                String[] strings = line.split(",");
                if (strings.length == 3) {
                    if (!departments.containsKey(strings[1])) {
                        departments.put(strings[1], new Department(strings[1]));
                    }
                    departments.get(strings[1]).addPerson(new Person(strings[0], new BigDecimal(strings[2])));
                } else {
                    System.out.print("Неверный формат данных в файле!");
                }
                line = br.readLine();
            }
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException has been caught");
        } catch (NumberFormatException e) {
            System.out.println("Неверный фомат зарплаты");
        } catch (IllegalArgumentException e) {
            System.out.println("IllegalArgumentException");
        } catch (FileNotFoundException fnfex) {
            System.out.println("Файл не найден");
        } catch (IOException ioex) {
            System.out.println("Ошибка чтения (IOException)");
        }
    }
}
