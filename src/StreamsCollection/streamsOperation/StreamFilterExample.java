package com.example.streams.Java8Features.streamsOperation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFilterExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        List<Integer> evenNum = numbers.stream()
                .filter(num -> num % 2 == 0)
                .collect(Collectors.toList());
        System.out.println(evenNum);

        List<Integer> oddNum = numbers.stream()
                .filter(num -> num % 2 != 0)
                .collect(Collectors.toList());
        System.out.println(oddNum);

        List<Integer> numGreaterThan5 = numbers.stream()
                .filter(num -> num > 5)
                .collect(Collectors.toList());
        System.out.println(numGreaterThan5);

        List<Integer> collect = numbers.stream()
                .filter(num -> num % 3 == 0 && num > 7)
                .collect(Collectors.toList());
        System.out.println(collect);

    }
}
