package ru.tsconsulting.Internship;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Map;

class Combinations {

    private Map<String, Department> departments;
    private ArrayList<String> toPrint = new ArrayList<>();

    public void addToPrint(String s) {
        this.toPrint.add(s);
    }
    public ArrayList<String> getToPrint() {
        return toPrint;
    }
    Combinations(Map<String, Department> departments) {
        this.departments = departments;
    }

    /* arr[]  ---> Input Array
        data[] ---> Temporary array to store current combination
        start & end ---> Staring and Ending indexes in arr[]
        index  ---> Current index in data[]
        r ---> Size of a combination to be printed */
    void combinationUtil(String departmentName, Person[] arr, Person[] data, int start,
                         int end, int index, int r) {
            if (index == r) {
                BigDecimal averSalary = this.departments.get(departmentName).countAverSalary();
                BigDecimal sum = new BigDecimal(0);
                for (int j = 0; j < r; j++) {
                    sum = sum.add(data[j].getSalary());
                }
                sum = sum.divide(new BigDecimal(r), 2);
                for (Map.Entry<String, Department> entry : departments.entrySet()) {
                    String line = "";
                    if (!departmentName.equals(entry.getKey()) && sum.compareTo(averSalary) < 0 &&
                            sum.compareTo(departments.get(entry.getKey()).countAverSalary()) > 0) {

                        for (int j = 0; j < r; j++) {
                            line += data[j].getName() + " ";
                        }
                        line += " может (могут) перейти в отдел: " + entry.getKey();
                        addToPrint(line);
                    }
                }
                return;
            }
            // replace index with all possible elements. The condition
            // "end-i+1 >= r-index" makes sure that including one element
            // at index will make a combination with remaining elements
            // at remaining positions
            for (int i = start; i <= end && end - i + 1 >= r - index; i++) {
                data[index] = arr[i];
                combinationUtil(departmentName, arr, data, i + 1, end, index + 1, r);
            }
    }

    // The main function that prints all combinations of size r
    // in arr[] of size n. This function mainly uses combinationUtil()
    void findCombinations(Map<String, Department> map) {
            for (Map.Entry<String, Department> departmentEntry : map.entrySet()) {
                int r = departmentEntry.getValue().getList().size();
                // A temporary array to store all combination one by one
                Person data[] = new Person[r];
//                int n = departmentMap.getValue().getList().size();
                // Print all combination using temporary array 'data[]'

                //следующие 2 строки необходимы для приведения Object[] к Person[]
                Person[] persons = new Person[r];
                departmentEntry.getValue().getList().toArray(persons);

                for (int i = 1; i <= r; i++) {
                    combinationUtil(departmentEntry.getKey(), persons,
                            data, 0, r - 1, 0, i);
                }
            }
    }
}
