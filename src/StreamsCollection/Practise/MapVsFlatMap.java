package StreamsCollection.Practise;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapVsFlatMap {
    public static void main(String[] args) {
        // List
        List<String> words = Arrays.asList("hello","world");

        // Use map to convert each array ele to upper case
//        words.stream()
//                .map(w -> w.toUpperCase())
//                .collect(Collectors.toList());

        List<String> upperCaseList = words.stream()
                .map(String :: toUpperCase)
                .collect(Collectors.toList());

        System.out.println("Converted list ele to uppercase ele :  " + upperCaseList);

        // Using FlatMap flat list of list of arrays
        List<List<Integer>> numbers = Arrays.asList(
                Arrays.asList(1,2,3),
                Arrays.asList(4,5,6),
                Arrays.asList(7,8,9)

        );

        List<Integer> flattenedMap = numbers.stream()
                .flatMap(List :: stream)
                .collect(Collectors.toList());

        System.out.println("Flattened map: " + flattenedMap);
    }
}
