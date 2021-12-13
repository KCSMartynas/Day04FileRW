package com.company.day04.view;

import com.company.day04.model.PersonVO;

import java.text.MessageFormat;

public class Terminal {

    public void showMenu() {
        System.out.println("Menu:");
        System.out.println("1 - Parodyti visus įrašus");
        System.out.println("2 - Pridėti įrašą");
        System.out.println("3 - Trinti įrašą");
        System.out.println("4 - Rasti pagal akių spalvą");
        System.out.println("5 - Rasti aukščiausią");
        System.out.println("6 - Išsaugoti");
        System.out.println("0 - Programos pabaiga");
    }

    public void showPerson(PersonVO person) {
        String template = "Vardas: {0}; Amžius: {1}, Ūgis: {2}, Akių spalva: {3}";

        Object[] values = {
                person.getName(),
                person.getAge(),
                person.getHeight(),
                person.getColor()
        };

        System.out.println(MessageFormat.format(template, values));
    }
}
