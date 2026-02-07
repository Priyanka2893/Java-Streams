package com.example.streams.Java8Features.streamsOperation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDistinctCountSortedExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 1, 6, 3, 5, 9, 0);

        List<Integer> distinctNum = numbers.stream().distinct()
                .collect(Collectors.toList());
        System.out.println(distinctNum);

        long count = numbers.stream()
                .count();

        System.out.println(count);

        List<Integer> sortedNum = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sortedNum);

    }
}
