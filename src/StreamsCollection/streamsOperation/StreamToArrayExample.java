package com.example.streams.Java8Features.streamsOperation;

import java.util.Arrays;
import java.util.List;

public class StreamToArrayExample {
    public static void main(String[] args) {
        List<String> fruits = Arrays.asList("Apple", "Banana", "Kiwi", "Mango");
        System.out.println(fruits);
        //------- From ListOfString to Array ------
        String[] fruitsArray = fruits.stream().toArray(String[]::new);
        System.out.println(fruitsArray);
        for(String fruit: fruitsArray){
            System.out.println(fruit);
        }
        //------- From ListOfInteger to Array ------
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        Integer[] arrayInt = numbers.stream().toArray(Integer[]::new);
        for (Integer num : arrayInt){
            System.out.println(num);
        }
    }
}
