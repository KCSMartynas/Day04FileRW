package com.company.day04.controller;

import com.company.day04.model.FileRW;
import com.company.day04.model.PersonList;
import com.company.day04.model.PersonVO;
import com.company.day04.view.Terminal;

import java.util.ArrayList;
import java.util.Scanner;

public class PersonController {
    // model variables
    private FileRW fileRW;
    private PersonList personList;

    // view variables
    private Terminal terminal;
    private Scanner scanner;

    public PersonController() {
        fileRW = new FileRW();
        personList = new PersonList();

        loadData();

        terminal = new Terminal();

        scanner = new Scanner(System.in);

        Integer pasirinkimas = null;
        do {
            terminal.showMenu();
            pasirinkimas = produceInput(scanner);
            switch (pasirinkimas) {
                case 0:
                    return;
                case 1:
                    showAllEntries();
                    break;
                case 2:
                    appendPersonToList();
                    break;
                case 5:
                    try {
                        terminal.showPerson(personList.getTallestPerson());
                    } catch (Exception exception) {
                        System.out.println("Sarasas tuscias, reikia nuskaityti duomenis");
                    }
                    break;
            }
        } while (pasirinkimas != 0);

    }

    private void appendPersonToList() {
        System.out.println("Iveskite Varda");
        String name = scanner.nextLine();
        System.out.println("Iveskite Amziu (metais)");
        int amzius = scanner.nextInt();
        System.out.println("Iveskite ugi (cm)");
        int ugis = scanner.nextInt();
        System.out.println("Iveskite akiu spalva");
        String color = scanner.nextLine();

        personList.appendList(new PersonVO(name, amzius, ugis, color));
    }

    private void loadData() {
        fileRW.openFile();
        PersonVO entry = fileRW.readPerson();
        while(entry != null){
            personList.appendList(entry);
            entry = fileRW.readPerson();
        }
    }

    private void showAllEntries() {
        ArrayList<PersonVO> list = personList.getListCopy();

        for (PersonVO person : list) {
            terminal.showPerson(person);
        }
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
