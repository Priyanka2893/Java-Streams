package StreamsCollection.streamsOperation;


import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class StreamForEachExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        numbers.stream().forEach(System.out::println);
        numbers.stream().forEach(num -> System.out.println(num * 2));
    }
}
