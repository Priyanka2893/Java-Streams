package com.example.streams.Java8Features.logicalPrograms;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class DuplicateRemover {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 2, 3);
        // 1. using set
        Set<Integer> usingSet = numbers.stream()
                .collect(Collectors.toSet());

        System.out.println(usingSet);
        // 2. using distinct
        List<Integer> usingDistinct = numbers.stream()
                .distinct()
                .collect(Collectors.toList());
        System.out.println(usingDistinct);

    }
}
