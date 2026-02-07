package com.example.streams.Java8Features.streamsOperation;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamFindExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 3, 4, 5, 6, 7, 8, 9);

        Optional<Integer> anyEven = numbers.stream()
                .filter(num -> num % 2 == 0)
                .findAny();
        System.out.println(anyEven.get());

        Optional<Integer> firstOddNum = numbers.stream()
                .filter(num -> num % 2 != 0)
                .findFirst();
        System.out.println(firstOddNum.get());
    }
}
