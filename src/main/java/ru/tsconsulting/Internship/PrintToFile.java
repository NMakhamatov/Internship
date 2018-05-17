package ru.tsconsulting.Internship;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class PrintToFile {
    private String inputFileName;
    private ArrayList<String> toPrint;

    public void setToPrint(ArrayList<String> toPrint) {
        this.toPrint = toPrint;
    }

    public PrintToFile(String inputFileName) {
        this.inputFileName = inputFileName;
    }


    void method() {
        int indexOfSlash = inputFileName.lastIndexOf("\\");
        String folder = inputFileName.substring(0, indexOfSlash + 1);
        try (FileWriter fw = new FileWriter(folder + "Out.txt");
             PrintWriter pw = new PrintWriter(fw)) {
            for (String s : toPrint) {
                pw.println(s);
            }
            if (!toPrint.isEmpty()) {
                System.out.println("Результаты сохранены в: " + folder + "Out.txt");
            }
        } catch (IOException ex) {
            System.out.print("IOException has been caught");
        }
    }
}
