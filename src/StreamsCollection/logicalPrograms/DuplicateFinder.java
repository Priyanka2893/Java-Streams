package com.example.streams.Java8Features.logicalPrograms;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DuplicateFinder {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 4, 7, 7, 8, 9, 10);

        Map<Integer, Long> frequencyMap = numbers.stream()
                .collect(Collectors.groupingBy(num -> num, Collectors.counting()));
        System.out.println("Frequency Map:" + frequencyMap);
        List<Integer> duplicates = frequencyMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());

        System.out.println(duplicates);
    }
}
