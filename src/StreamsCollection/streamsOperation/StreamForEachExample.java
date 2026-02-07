package com.example.streams.Java8Features.streamsOperation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;

public class StreamForEachExample {
    public static void main(String[] args) {
        Logger logger = LoggerFactory.getLogger(StreamForEachExample.class);
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        logger.info("simple reference output without parameter: ");
        numbers.stream().forEach(System.out::println);
        logger.info("Using lambda expression: ");
        numbers.stream().forEach(num -> System.out.println(num * 2));
    }
}
