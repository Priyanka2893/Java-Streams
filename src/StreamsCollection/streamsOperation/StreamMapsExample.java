package com.example.streams.Java8Features.streamsOperation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMapsExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> sqrNum = numbers.stream()
                .map(num -> num * num)
                .collect(Collectors.toList());

        System.out.println(sqrNum);

        List<String> fruits = Arrays.asList("Apple", "Banana", "Kiwi", "Mango");
        List<Integer> fruitLen = fruits.stream()
                .map(String::length)
                .collect(Collectors.toList());
        System.out.println(fruitLen);
    }
}
