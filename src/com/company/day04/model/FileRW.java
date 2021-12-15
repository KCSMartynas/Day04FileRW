package com.company.day04.model;

import com.company.day04.Main;

import java.io.File;
import java.io.FileWriter;
import java.text.MessageFormat;
import java.util.Scanner;

public class FileRW {
    private Scanner scanner;

    public void openFile() {
        try {
            scanner = new Scanner(new File(Main.FILE_NAME));
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }

    public PersonVO readPerson() {
        if (!scanner.hasNext()) {
            scanner.close();
            return null;
        }
        PersonVO result = new PersonVO();

        String eilute = scanner.nextLine();
        String[] exploded = eilute.split("\\|");

        result.setName(exploded[0]);
        try {
            result.setAge(Integer.parseInt(exploded[1]));
        } catch (Exception exception) {
            result.setAge(-1);
        }
        try {
            result.setHeight(Integer.parseInt(exploded[2]));
        } catch (Exception exception) {
            result.setHeight(-1);
        }
        result.setColor(exploded[3]);

        return result;
    }

    public void writePerson(PersonVO person) {
        String template = "{0}|{1}|{2}|{3}\n";

        Object[] values = {
                person.getName(),
                person.getAge(),
                person.getHeight(),
                person.getColor()
        };
        String outputLine = MessageFormat.format(template, values);
        try {
            FileWriter fileWriter = new FileWriter(Main.FILE_NAME, true);
            fileWriter.write(outputLine);
            fileWriter.close();
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
