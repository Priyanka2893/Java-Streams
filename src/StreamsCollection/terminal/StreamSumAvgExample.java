package com.example.streams.Java8Features.terminal;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamSumAvgExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        Integer sumOfNum = numbers.stream()
                .collect(Collectors.summingInt(Integer::intValue));
        System.out.println(sumOfNum);

        Double avgOfNum = numbers.stream()
                .collect(Collectors.averagingInt(Integer::intValue));
        System.out.println(avgOfNum);


    }
}
