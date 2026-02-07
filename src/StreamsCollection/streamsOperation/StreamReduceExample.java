package com.example.streams.Java8Features.streamsOperation;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamReduceExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        Optional<Integer> sum = numbers.stream()
                .reduce((a, b) -> a + b);
        if(sum.isPresent()){
            System.out.println(sum.get());
        }else{
            System.out.println("No ele found");
        }

        Optional<Integer> max = numbers.stream()
                .reduce(Integer::max);
        if(sum.isPresent()){
            System.out.println(max.get());
        }else{
            System.out.println("No ele found");
        }

    }
}
