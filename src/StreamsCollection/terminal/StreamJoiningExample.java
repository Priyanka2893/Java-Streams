package com.example.streams.Java8Features.terminal;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamJoiningExample {
    public static void main(String[] args) {
        Stream<String> words = Stream.of("Java", "is", "awesome");

        String collect = words.collect(Collectors.joining(" "));
        System.out.println(collect);
    }
}
