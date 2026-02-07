package com.example.streams.Java8Features.terminal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Person{
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }
}
public class StreamGroupByExample {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("Priyanka", "32"),
                new Person("Sanjay", "35"),
                new Person("Kushtu", "4"),
                new Person("Soni", "32")
        );

        Map<String, List<Person>> personByAge = persons.stream()
                .collect(Collectors.groupingBy(Person::getAge));

        System.out.println(personByAge);

        // Group by count
        Map<String, Long> countByAge = persons.stream()
                .collect(Collectors.groupingBy(Person::getAge,
                        Collectors.counting()));
        System.out.println(countByAge);

        // Group by map
        Map<String, List<String>> getNameByAge = persons.stream()
                .collect(Collectors.groupingBy(Person::getAge,
                        Collectors.mapping(Person::getName, Collectors.toList())));

        System.out.println(getNameByAge);
    }
}
