package StreamsCollection.Practise;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class CreateStreamInstances {
    public static void main(String[] args) {
        // 1. From a Collection
        List<String> listOfNames = Arrays.asList("Kushtu", "Priyanka", "Sanjay", "Suman");
        Stream<String> stream = listOfNames.stream();

        // 2. Array
        String[] arrayOfCity = {"Jaipur", "Ajmer", "Mumbai", "Jodhpur"};
        Stream<String> stream1 = Arrays.stream(arrayOfCity);

        // 3. Factory Method
        Stream<String> fruits = Stream.of("Apple", "Mango", "Guava", "Grapes");

        // 4. From Builder
        Stream.Builder<String> builder = Stream.builder();
        builder.add("Red");
        builder.add("Orange");

        // 5. Empty Stream
        Stream<Object> empty = Stream.empty();

        // 6. I/O Channel
        try(BufferedReader reader = new BufferedReader(new FileReader("/Users/priyankashaktawat/Documents/Projects-with-intelliJ/Practise/Streams/StreamsPractise/src/data.txt"))){
            Stream<String> lines = reader.lines();
        }catch(Exception e){
            e.printStackTrace();
        }

    }
}
