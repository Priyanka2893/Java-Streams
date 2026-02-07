package com.example.streams.Java8Features.terminal;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamPartitionByExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Map<Boolean, List<Integer>> evenOddPartition = numbers.stream()
                .collect(Collectors.partitioningBy(num -> num % 2 == 0));

        System.out.println("Even: " + evenOddPartition.get(true));
        System.out.println("Odd: " + evenOddPartition.get(false));

        List<String> fruits = Arrays.asList("Apple", "Banana", "Cherry", "Mango", "Dates");

        Map<Boolean, List<String>> shortLengthWords = fruits.stream()
                .collect(Collectors.partitioningBy(word -> word.length() <= 5));

        System.out.println("Less than 5 length: " + shortLengthWords.get(true));
        System.out.println("More than 5 length: " + shortLengthWords.get(false));
    }
}
