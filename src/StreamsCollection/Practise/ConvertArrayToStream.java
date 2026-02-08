package StreamsCollection.Practise;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ConvertArrayToStream {
    public static void main(String[] args) {
        // Two ways to convert array to stream
        // 1. For primitive type array
        int[] arrayInt = {1,2,3,4,5,6};

        IntStream arrayIntToStream = Arrays.stream(arrayInt);
        arrayIntToStream.forEach(System.out::println);

        // 2. For Object type array
        Integer[] arrayInteger = {7,8,9,10};
        Stream<Integer> arrayIntegerToStream = Stream.of(arrayInteger);
        arrayIntegerToStream.forEach(System.out::println);
    }
}
