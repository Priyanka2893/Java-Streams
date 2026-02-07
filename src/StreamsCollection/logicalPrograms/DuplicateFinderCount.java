package com.example.streams.Java8Features.logicalPrograms;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class DuplicateFinderCount {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Apple", "Bananaa", "Apple", "Kiwi", "Kiwi", "Orange");

        Map<String, Long> freqMap = fruits.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()));

        System.out.println(freqMap);

        Map<String, Long> result = freqMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        System.out.println(result);

        Map<String, Long> resultInSingleLine = fruits.stream()
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(resultInSingleLine);
    }
}
