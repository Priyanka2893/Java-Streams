package StreamsCollection.Practise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

class Employee {
    private int id;
    private String name;
    private String dept;
    private double salary;

    public Employee(int id, String name, String dept, double salary) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", salary=" + salary +
                '}';
    }
}

public class Practise2 {

    public static void main(String[] args) {
        Employee emp1 = new Employee(1, "Promise", "IT", 40.0);
        Employee emp2 = new Employee(2, "John", "HR", 70.0);
        Employee emp3 = new Employee(3, "Peter", "Facility", 70.0);
        Employee emp4 = new Employee(4, "Tayo", "Facility", 30.0);
        List<Employee> employees = Arrays.asList(emp1, emp2, emp3, emp4);

        // 1.Print All Employee Names
        employees.stream().forEach(s -> System.out.println(s.getName()));

        List<String> employeeNames = employees.stream().map(Employee::getName).toList();
        System.out.println(employeeNames);

        // 2.Create a mapping of employee’s Id and Employee object
        // toMap - takes 2 paramter - function and function, we cannot use mapping() here as it accepts - 1.fxn and 2.Collector
        System.out.println(employees.stream().collect(Collectors.toMap(Employee::getId, employee -> employee)));

        // 3. Create a mapping of employee’s Id and their names.
        System.out.println(employees.stream().collect(Collectors.toMap(Employee::getId, Employee::getName)));

        //4.  Group employees by their departments.
        System.out.println(employees.stream().collect(Collectors.groupingBy(Employee::getDept)));

        // 5. Find the employee with the maximum salary.
        // here first we do -> map -> it will get all salary -> then we did max -> result is only salary which is max
        System.out.println(employees.stream().map(e -> e.getSalary()).max(Comparator.naturalOrder()).get());
        // here directly we did max -> using comparing -> result we get whole employee object
        Employee empWithMaxSalary = employees.stream().max(Comparator.comparing(Employee::getSalary)).get();
        System.out.println(empWithMaxSalary);

        // 6.Find the employee with the minimum salary.
        Employee empWithMinSalary = employees.stream().min(Comparator.comparing(Employee::getSalary)).get();
        System.out.println(empWithMinSalary);

        // 7. Calculate the average salary.
        System.out.println(employees.stream().mapToDouble(Employee::getSalary).average().orElse(-1));

        // 8. Calculate the total salary.
        System.out.println(employees.stream().mapToDouble(Employee::getSalary).sum());
        double totalSalary = employees.stream().reduce(0.00, (a, b) -> a + b.getSalary(), Double::sum);

        //9.Even number from list
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        System.out.println(numbers.stream().filter(s -> s % 2 == 0).collect(Collectors.toList()));

        // 10. Find the first string with length greater than 2.
        List<String> words = Arrays.asList("an", "boy", "the", "apple");
        System.out.println(words.stream().filter(s -> s.length() > 2).findFirst().get());

        // 11. Count Strings that start with ‘A’ case insensitive.
        List<String> fruits = Arrays.asList("banana", "apple", "Avocado", "orange");
        System.out.println(fruits.stream().filter(s -> s.toLowerCase().startsWith("a")).count());

        // 12. Convert a list of string to upper case.
        List<String> names = Arrays.asList("Java", "John", "Doe");
        System.out.println(names.stream().map(s -> s.toUpperCase()).toList());
        List<String> namesToUpper = names.stream().map(String::toUpperCase).toList();

        // 13. Sum of squares of all elements
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 6, 7);
        System.out.println(nums.stream().map(n -> n * n).mapToInt(n -> n).sum());
        Integer sumOfSquares = nums.stream().map(num -> num * num).reduce(0, Integer::sum);

        // 14.  Group Strings by their length.
        List<String> strings = Arrays.asList("apple", "boy", "girl", "man", "woman");
        System.out.println(strings.stream().collect(Collectors.groupingBy(s -> s.length())));

        // 15. Flatten a list of lists.
        List<List<String>> nestedList = Arrays.asList(
                Arrays.asList("x", "y", "z"),
                Arrays.asList("a", "b", "c"),
                Arrays.asList("1", "2", "3")
        );
        System.out.println(nestedList.stream().flatMap(List::stream).collect(Collectors.toList()));

        // 16. Find duplicate elements.
        List<String> input = Arrays.asList("apple", "banana", "apple", "orange", "banana");
        input.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .filter(s -> s.getValue() > 1)
                .toList()
                .forEach(s -> System.out.println(s.getKey()));

        //17.  Remove duplicate elements.
        List<String> fruits1 = Arrays.asList("apple", "banana", "apple", "orange", "banana");
        System.out.println(fruits1.stream().distinct().toList());

        // 18. Join upper case with delimeter “ -”.
        List<String> nameList = Arrays.asList("John", "doe", "smith", "promise", "akeni");
        System.out.println(nameList.stream().map(n -> n.toUpperCase()).collect(Collectors.joining("-")));

        // 19. Partition a list into even and odd number.
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println(list.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0)));

        // 20. Find the top 3 longest strings in a list.
        List<String> wordList = Arrays.asList("a", "bfgij", "abc", "abcd", "abcde");
        List<String> list1 = wordList.stream()
                .sorted(Comparator.comparing(String::length).reversed())
                .limit(3)
                .toList();
        System.out.println(list1);

        // 21. Find second smallest number, return min value if not found.
        List<Integer> nums1 = Arrays.asList(6, 1, 9, 6, 5, 7, 3, 3, 2, 2, 1);
        System.out.println(nums1.stream().distinct().sorted().skip(1).limit(1).findFirst().orElse(-1));

        // 22. Using the same list above, find the third largest num, return max integer value if not found.
        System.out.println(nums1.stream().distinct().sorted().skip(2).limit(1).findFirst().orElse(Integer.MAX_VALUE));

        // 23. Convert set of integers to int array.
        Set<Integer> set = Set.of(1, 2, 3, 4, 5);
        int[] setToArray = set.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(setToArray));

        // 24.Convert above int[] array to Set of Integer.
        Set<Integer> intArrayToSet = Arrays.stream(setToArray).boxed().collect(Collectors.toSet());
        System.out.println(intArrayToSet);

        //25. Convert List of Integer to int[] array.
        List<Integer> integers = List.of(1, 2, 1, 3, 4, 3, 1);
        int[] integersToIntArr = integers.stream().mapToInt(Integer::intValue).toArray();
        System.out.println(Arrays.toString(integersToIntArr));

        // 26. Convert the above integers to Set of Integer.
        Set<Integer> set1 = new HashSet<>(integers);
        System.out.println(set1);

        //27. Sort fruits in ascending order.
        List<String> fruits2 = List.of("apple", "pineapple", "mango", "guava", "orange", "banana");
        System.out.println(fruits2.stream().sorted().collect(Collectors.toList()));

        //28.  Sort the same fruits in descending order.
        System.out.println(fruits2.stream().sorted(Comparator.reverseOrder()).toList());

        //29.  Sum even and odd numbers in a list of integer and validate that your output is correct.
        List<Integer> list3 = List.of(3, 2, 5, 7, 1, 9, 22, 11, 8, 5, 9);
        int sumOfEvenNum = list3.stream().filter(num -> num % 2 == 0).mapToInt(Integer::intValue).sum();
        int sumOfOddNum = list3.stream().filter(num -> num % 2 == 1).mapToInt(Integer::intValue).sum();
        int sum = list3.stream().mapToInt(Integer::intValue).sum();

        System.out.println(sumOfEvenNum);
        System.out.println(sumOfOddNum);
        System.out.println(sum);
        System.out.println(sum == sumOfEvenNum + sumOfOddNum);

        // 30. How can you use peek for debugging?
        List<Integer> integerList = List.of(3, 2, 5, 7, 1, 9, 22, 11);
        List<Integer> evenList = integerList.stream()
                .peek(num -> System.out.println("num before filtering " + num))
                .filter(num -> num % 2 == 0)
                .peek(num -> System.out.println("num after filtering but before mapping " + num))
                .map(num -> num * num)
                .peek(num -> System.out.println("num after mapping " + num))
                .toList();

        System.out.println(evenList);

        // 31. Can you calculate the sum and average of a collection of numbers in one pass?

        String sumAndAverage = numbers.stream().collect(Collectors.teeing(
                Collectors.summingInt(num -> num),
                Collectors.averagingInt(num -> num),
                (sum1, avg) -> " sum is : " + sum1 + " while average is " + avg
        ));

        System.out.println("sumAndAverage => " + sumAndAverage);

        // 32. Using the same list above, calculate the min and max in one pass returning min integer value and max if not found.

        Map<String, Integer> minAndMaxMap = numbers.stream().collect(Collectors.teeing(
                Collectors.maxBy(Comparator.comparing(num -> num)),
                Collectors.minBy(Comparator.comparing(num -> num)),
                (max, min) -> Map.of("min", min.orElse(Integer.MIN_VALUE), "max", max.orElse(Integer.MAX_VALUE))
        ));
        System.out.println("minAndMax => " + minAndMaxMap);

        // 33.Given two collections, how do you keep only what is present in both collections? You may mutate the original collection.
        //
         List<String> firstList = new ArrayList<>();
         firstList.add("A");
         firstList.add("B");
         firstList.add("C");
         List<String> secondList = Arrays.asList("B", "C", "D");
         firstList.retainAll(secondList); // firstList is mutated
         System.out.println("retain all: " + firstList);

        //Notice that the firstList was created with the new keyword and not with
        // Arrays.asList. This is because the retainAll() method mutates the first list.
        // If we initialized the first list using Arrays.asList or List.of,
        // we will get an exception when we call the retainAll() method as the list
        // created by Arrays.asList() or List.of() methods are fixed size and cannot be shrunk or increased.

        // 34. What is the difference between filter() and takeWhile() methods?

        //filter() method applies a predicate to an entire stream and returns a new stream of elements that return true in the predicate check.

        List<Integer> numbers3 = List.of(1,2,3,4,5,6,7,8,9);
                List<Integer> evenNumbers = numbers3.stream().filter(num -> num % 2 == 0).toList();
                System.out.println("evenNumbers from filter operation : " + evenNumbers);

        //Output:
        //evenNumbers from filter operation : [2, 4, 6, 8]

        //takeWhile() method applies a predicate to the collection and keeps taking from a collection
        // everytime an element returns true, otherwise it stops taking. It may not apply to the whole stream.
        // Once it encounters the first false, it terminates. If the first element returns false,
        // it terminates without taking any element.

        List<Integer> takeWhileLessThanFive = numbers.stream().takeWhile(num -> num < 5).toList();
        List<Integer> takeWhileGreaterThan2 = numbers.stream().takeWhile(num -> num > 2).toList();

        System.out.println("takeWhileLessThanFive : " + takeWhileLessThanFive);
        System.out.println("takeWhileGreaterThan2 : " + takeWhileGreaterThan2);

        //Output:
        //takeWhileLessThanFive : [1, 2, 3, 4]
        //takeWhileGreaterThan2 : []

        //One good use case of takeWhile() is:
        //Imagine you had a sorted list of numbers from 1 to a million, and you only wanted to take the numbers that were less than 5.
        //If there were no duplicates, the takeWhile() runs for just 4 - 5 times — great performance gain.
        //If you used the filter() function in this scenario, it would run a million times, checking for every item.
        //So use takeWhile() when you want to stop at the first non-matching element (especially with sorted or ordered streams).


        // 34. dropWhile() is like the opposite of takeWhile(). dropWhile() applies a predicate to a collection and keeps dropping elements from the collection until the false result is encountered.
        //
        //If the first element returns false, no dropping occurs so the collection is returned untouched.
        //
        //While takeWhile() takes and collects what is taken from the collection, dropWhile() removes from the collection and collects what is remaining from the collection.
        //
        //List<Integer> numbers = List.of(1,2,3,4,5,6,7,8,9);
        //List<Integer> dropWhileLessThan5 = numbers.stream().dropWhile(num -> num < 5).toList(); List<Integer> dropWhileGreaterThan2 = numbers.stream().dropWhile(num -> num > 2).toList();
        //
        //System.out.println("dropWhileLessThan5 : " + dropWhileLessThan5);
        //System.out.println("dropWhileGreaterThan2 : "  + dropWhileGreaterThan2);
        //
        //Output:
        //dropWhileLessThan5 : [5, 6, 7, 8, 9]
        //dropWhileGreaterThan2 : [1, 2, 3, 4, 5, 6, 7, 8, 9]


        // 35.

    }
}
