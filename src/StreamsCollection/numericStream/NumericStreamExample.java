package com.example.streams.Java8Features.numericStream;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.IntStream;

public class NumericStreamExample {
    public static void main(String[] args) {
        // range method
        IntStream.range(1,5)
                .forEach(System.out::println);

        System.out.println("-----------------");
        // range closed method
        IntStream.rangeClosed(1,5)
                .forEach(System.out::println);

        System.out.println("-----------------");

        //count()
        long count = IntStream.rangeClosed(1, 5)
                .count();
        System.out.println("Count is: " + count);

        IntStream.rangeClosed(1,5)
                .forEach(num -> System.out.println(num*2));

        //how to create IntStream
        int[] numbers = {5,10,15,3,6,5};
        int sum = IntStream.of(numbers).sum();
        System.out.println(sum);

        OptionalInt max = IntStream.of(numbers).max();
        System.out.println(max.getAsInt());

        OptionalInt min = IntStream.of(numbers).min();
        System.out.println(min.getAsInt());

        OptionalDouble average = IntStream.of(numbers).average();
        System.out.println(average.getAsDouble());

        // --------- boxing and unboxing----------
        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5);

        IntStream intStream = numbers2.stream().mapToInt(Integer::intValue);
        int sum1 = intStream.sum();
        System.out.println(sum1);

        // after terminal op we need again get main stream
        OptionalInt max1 = numbers2.stream().mapToInt(Integer::intValue).max();
        System.out.println(max1.getAsInt());

        //convert IntStream to Long,Double,Object Stream
        int[] numbers3 = {2,5,1,5,9};
        IntStream.of(numbers3).mapToObj(num -> " " + num)
                .forEach(System.out::println);

        IntStream.of(numbers3)
                .mapToDouble(num -> Math.sqrt(num))
                .forEach(System.out::println);



    }

}
