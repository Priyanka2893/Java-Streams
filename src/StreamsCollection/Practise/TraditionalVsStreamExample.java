package StreamsCollection.Practise;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class TraditionalVsStreamExample {
    public static void main(String[] args) {
        // Traditionally

        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        int sumOfEvenNumbers = 0;
        for(int num : numbers){
            if(num % 2 == 0){ // Filter of even numbers
                int square = num * num; // square of even numbers
                sumOfEvenNumbers += square; // add to sum
            }
        }
        System.out.println("Sum of square od even numbers(traditional) : " + sumOfEvenNumbers);


        // Using Stream approach
        int sum = numbers.stream()
                .filter(n -> n % 2 ==0) // Filter out even numbers
                .mapToInt(n -> n * n) // square even number and return int because result is of int type
                .sum(); // sum of square

        System.out.println("Sum of square od even numbers (using stream) : " + sum);


    }
}
