package StreamsCollection;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Stream_Example_02 {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,3,4,5,5,6,7,7,8,7,7,8,9,9,10);

        // Intermediate operations
        List<Integer> squaredNumbers =numbers.stream()
                .filter(n -> n%2 ==0) // Filter even numbers
                .map(s -> s * s)      // square even numbers
                .distinct()           // remove duplicates
                .peek(System.out::println)  // peek into that stream(for debugging)
                .collect(Collectors.toList()); // collect the result into a list

        System.out.println("Squared numbers : "+ squaredNumbers);

        // Terminal Operations
        long count = numbers.stream()
                .filter(n -> n > 5) // filter numbers > 5
                .count();           // count remaining numbers

        System.out.println("Count of numbers > 5: " + count );

        int sum = numbers.stream()
                .mapToInt(Integer:: intValue) //convert Integer stream to int stream
                .sum();
        System.out.println("Sum of numbers " + sum);
    }
}
