package com.example.streams.Java8Features.logicalPrograms;

import java.util.Arrays;
import java.util.Optional;
import java.util.stream.Stream;

/*
1. Arrays.stream(arr):This creates a stream from the array arr. If arr is an array of primitive integers (e.g., int[]), the stream will be of type IntStream.
2. distinct():This operation ensures that duplicates are removed from the stream. The stream will now contain only unique elements.
3. boxed():This is the method we are focusing on. The boxed() operation converts the elements of the IntStream (which are primitive ints) into their corresponding wrapper objects, i.e., Integer objects.
Before calling boxed(), you have a stream of primitive int values. After calling boxed(), the stream contains Integer objects.
4. sorted((a, b) -> b - a):This sorts the stream in descending order based on the comparison logic you provide (in this case, b - a for descending order).
After sorting, the stream might look like: [9, 6, 4, 3, 2].
5. skip(1):This operation skips the first element in the stream, effectively discarding the largest element. After this operation, the stream might look like: [6, 4, 3, 2].
6. findFirst():This terminal operation finds the first element from the stream after the skip(1) operation. It returns an Optional<Integer>, which will contain the value if the stream is not empty or be empty if no element is found.
 */
public class SecondLargestElement {
    public static void main(String[] args) {
        int[] arr = {3,6,9,9,4,2};
        Optional<Integer> first = Arrays.stream(arr)
                .distinct()
                .boxed()
                .sorted((a, b) -> b - a) // 9,6,4,3,2
                .skip(1)
                .findFirst();

        System.out.println(first.get());
    }
}
