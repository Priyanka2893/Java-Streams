package com.example.streams.Java8Features.streamsOperation;

import java.util.Arrays;
import java.util.List;

public class StreamMatchExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        boolean allEven = numbers.stream()
                .allMatch(num -> num % 2 == 0);
        System.out.println(allEven);

        boolean anyEven = numbers.stream()
                .anyMatch(num -> num % 2 == 0);
        System.out.println(anyEven);

        boolean noneNegativeNum = numbers.stream()
                .noneMatch(num -> num < 0);
        System.out.println(noneNegativeNum);
    }
}
