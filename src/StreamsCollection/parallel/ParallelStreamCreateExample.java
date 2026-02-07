package com.example.streams.Java8Features.parallel;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
   Sequential Stream : 1. Process ele in a stream in serial manner
                       2. Op are executed in single thread
                       3. Suitable for small-medium data sets or
                       order of execution is imp
                       4. Can be created by default when working with streams
   Parallel Stream :   1. Process ele in a stream concurrently
                       2. Op are divided into multiple tasks that
                       can be operated on different threads
                       3. Suitable for large data sets
                       4. Created by converting sequential using parallel()
                       method
   Data Partitioning
   Task Description
   Concurrent Processing
   Result Aggregation

   When not to use parallel streams:
   1. Small data sets
   2. Sequential dependencies
   3. Non-thread op
   4. I/O bound op
   5. Order sensitive op
 */
public class ParallelStreamCreateExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        numbers.stream().parallel().forEach(System.out::println);
        System.out.println("-------------------");
        numbers.parallelStream().forEach(System.out::println);

        System.out.println("-------------------");

        int[] numbers1 = {1,2,3,4,5};
        Arrays.stream(numbers1).parallel()
                .filter(num -> num%2 == 0)
                .map(num -> num * 2)
                .forEach(System.out::println);



    }
}
