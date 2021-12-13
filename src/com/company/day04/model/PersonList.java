package com.company.day04.model;

import java.util.ArrayList;

public class PersonList {
    ArrayList<PersonVO> list;

    public PersonList() {
        list = new ArrayList<>();
    }

    public ArrayList<PersonVO> getListCopy() {
        return new ArrayList<>(list);
    }

    public void appendList(PersonVO person) {
        list.add(person);
    }

    public PersonVO removePersonAt(int position) throws Exception {
        if (position < 0 || position >= list.size()) {
            throw new Exception("Person list index is out of bounds, use 0 >= i < size()");
        }

        return list.remove(position);
    }

    public ArrayList<PersonVO> findByColor(String color) {
        ArrayList<PersonVO> result = new ArrayList<>();

        for (PersonVO person : list) {
            if (person.getColor().equals(color)) {
                result.add(person);
            }
        }

        return result;
    }

    public PersonVO getTallestPerson() throws Exception {
        if(list.size() == 0) {
            throw new Exception("Person List is empty");
        }
        PersonVO result = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            PersonVO current = list.get(i);
            if(current.getHeight() > result.getHeight()){
                result = current;
            }
        }

        return result;
    }

}
