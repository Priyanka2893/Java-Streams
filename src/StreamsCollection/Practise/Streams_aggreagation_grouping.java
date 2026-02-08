package StreamsCollection.Practise;

import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/***
 *  Immutable vs Modifiable List:
 *  Because that's how it's designed by the Java designers:
 *  Stream.toList() returns an unmodifiable list (same as List.of(...)).
 *  This helps prevent unintended modifications and encourages
 *  functional programming practices — no side effects.
 *
 *  | Method                                        | Modifiable? | Java Version | Backed By           |
 * | --------------------------------------------- | ----------- | ------------ | ------------------- |
 * | `Stream.of(...).toList()`                     | ❌ No        | 16+          | Unmodifiable list   |
 * | `Stream.of(...).collect(Collectors.toList())` | ✅ Yes       | 8+           | Usually `ArrayList` |
 *
 *
 * | Collector          | Use Case                                  | Returns                      |
 * | ------------------ | ----------------------------------------- | ---------------------------- |
 * | `groupingBy()`     | Group elements by a classifier            | `Map<key, List<values>>`     |
 * | `partitioningBy()` | Divide elements into two groups (boolean) | `Map<Boolean, List<values>>` |
 * | `summarizingInt()` | Summarize numeric data                    | `IntSummaryStatistics`       |
 *
 *
 */
public class Streams_aggreagation_grouping {
    public static void main(String[] args) {
        // Immutable list using streams
        var immutableList  = Stream.of("red","green",null).toList();
//        immutableList.add("yellow"); // compile and runtime error - Exception in thread "main" java.lang.UnsupportedOperationException
        System.out.println("Immutable list: " + immutableList);

        // Modifiable List using stream
        var modifiableList = Stream.of("red","green",null)
                .collect(Collectors.toList());
        modifiableList.add("yellow");
        modifiableList.set(2,"orange");
        System.out.println("Modifiable list: " + modifiableList);

        record Product(String name, String category ,int price){};
        Stream<Product> products = Stream.of(
                new Product("Laptop","Electronics",1000),
                new Product("Table","Furniture",1500),
                new Product("Show piece","Home Decor",200),
                new Product("Mouse","Electronics",700),
                new Product("TV","Electronics",2000),
                new Product("Sofa","Furniture",5000)

        );

        // Grouping - by each category
//        Map<String, List<Product>> groupingWithCategory =
//                products.collect(Collectors.groupingBy(Product::category));
//
//        System.out.println(groupingWithCategory);

        // Aggregation - sum of price in each category
//        Map<String, Integer> totalPriceByCategory =
//                products.collect(Collectors.groupingBy
//                        (Product::category,
//                                Collectors.summingInt(Product::price)
//                        ));
//
//        System.out.println(totalPriceByCategory);

        // Average price
//        Map<String, Double> averagePriceByCategory =
//                products.collect(Collectors.groupingBy
//                        (Product::category,
//                                Collectors.averagingDouble(Product::price)
//                        ));
//
//        System.out.println(averagePriceByCategory);

        //Count by category
//        Map<String, Long> countByCategory =
//                products.collect(Collectors.groupingBy
//                        (Product::category,
//                                Collectors.counting()
//                        ));
//
//        System.out.println(countByCategory);

        //filtering
//        var filteredByPrice = products
//                .filter(n -> n.price > 1000).toList();
//        System.out.println(filteredByPrice);

        // extracting product names
//        var extractProductCategory = products.
//                map(n -> n.category).collect(Collectors.toList());
//
//        System.out.println(extractProductCategory);

        // partitioning by product price greater than 1000
        var partionByPrice = products.
                collect(Collectors.partitioningBy(p -> p.price > 1000));
//
        System.out.println(partionByPrice.get(true));

        // summarising int
//        Map<String , IntSummaryStatistics> summaryStatisticsMap =
//                products.collect(Collectors.groupingBy(
//                        Product::category,
//                        Collectors.summarizingInt(Product::price)
//                ));
//
//        System.out.println(summaryStatisticsMap);
    }
}
