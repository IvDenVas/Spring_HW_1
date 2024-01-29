package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ObjectMapper objectMapper = new ObjectMapper();
        File fileJson = new File("file.json");
        Person person = new Person("Денис", "Петров", 34);

        try {
            objectMapper.configure(SerializationFeature.INDENT_OUTPUT, true);
            objectMapper.writeValue(fileJson, person);
            Person person1 = objectMapper.readValue(fileJson, Person.class);
            System.out.println("После десерилизации:\n\t" + person1);
            if(person1.equals(person)) System.out.println("Проверка equals");
            if(person1.hashCode() == person.hashCode()) System.out.println("Проверка hashcode");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}