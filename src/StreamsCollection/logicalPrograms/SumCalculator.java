package com.example.streams.Java8Features.logicalPrograms;

import java.util.Arrays;
import java.util.List;

public class SumCalculator {
    public static void main(String[] args) {
        // sum of all elements
        List<Integer> numbers = Arrays.asList(1, 2, 3,4,5);
        // 1. using mapToInt
        int sum = numbers.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Sum os all numbers: " + sum);

        // 2. reduce method
        Integer reduceSum = numbers.stream().reduce(0, Integer::sum);
        System.out.println("USing reduce: " + reduceSum);
    }
}
