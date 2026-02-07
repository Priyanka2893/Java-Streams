package com.example.streams.Java8Features.terminal;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamMaxMinExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 6, 2, 9, 0);

        Optional<Integer> minValue = numbers.stream()
                .collect(Collectors.minBy(Comparator.naturalOrder()));

        System.out.println(minValue.get());

        Optional<Integer> maxValue = numbers.stream()
                .collect(Collectors.maxBy(Comparator.naturalOrder()));

        System.out.println(maxValue.get());

    }
}
