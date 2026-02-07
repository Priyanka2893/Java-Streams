package com.example.streams.Java8Features.streamsOperation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamFlatMapExample {
    public static void main(String[] args) {
        //Map -> when given input is Strings, Integers
        //FlatMap -> ListOfList, MapOfMap

        List<List<Integer>> list = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5, 6),
                Arrays.asList(7, 8, 9)
        );

        List<Integer> numbers = list.stream()
                .flatMap(List::stream)
                .collect(Collectors.toList());

        System.out.println(numbers);

        for(Integer num : numbers){
            System.out.println(num);
        }
    }
}
