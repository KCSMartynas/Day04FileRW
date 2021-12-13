package com.company.day04.controller;

import com.company.day04.model.FileRW;
import com.company.day04.model.PersonList;
import com.company.day04.view.Terminal;

import java.util.Scanner;

public class PersonController {
    // model variables
    private FileRW fileRW;
    private PersonList personList;

    // view variables
    private Terminal terminal;

    public PersonController() {
        fileRW = new FileRW();
        personList = new PersonList();

        terminal = new Terminal();

        Scanner scanner = new Scanner(System.in);

        Integer pasirinkimas= null;
        do {
            terminal.showMenu();
            pasirinkimas = produceInput(scanner);

        } while (pasirinkimas != 0);

    }

    private int produceInput(Scanner scanner) {
        Integer result = null;
        while (result == null) {
            try {
                result = scanner.nextInt();
            } catch (Exception exception) {
                scanner.next();
                System.out.println("Iveskite sveika skaiciu tarp 0 ir 6");
            }
        }
        return result;
    }

}
