package com.example.streams.Java8Features.logicalPrograms;

import java.util.Random;

public class RandomNumbers {
    public static void main(String[] args) {
        // Random Number Generator
        Random random = new Random();
        random.ints(10, 0, 10)
                .forEach(System.out::println);
    }
}
