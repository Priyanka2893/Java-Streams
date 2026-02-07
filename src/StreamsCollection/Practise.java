package StreamsCollection;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Practise {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Priyanka", "IT", 25000));
        employees.add(new Employee("Soni", "IT", 100000));
        employees.add(new Employee("Ajay", "Medical", 200000));

        System.out.println(employees.stream().collect(Collectors.summingInt(Employee::salary)));
        System.out.println(employees.stream().mapToInt(Employee::salary).sum());
        System.out.println(employees.stream().min(Comparator.comparingInt(a -> a.salary)).get().salary);
        System.out.println(employees.stream().
                collect(Collectors.groupingBy(Employee::dept,
                        Collectors.mapping(e -> e.name, Collectors.toList()))));

        System.out.println(employees.stream()
                .map(Employee::salary)
                .sorted((a, b) -> b - a)
                .skip(1)
                .findFirst()
                .get());
        String s1 = "Priyanka"; // ['P',''r]

        Map<Character, Long> collect = s1.chars().mapToObj(c -> (char) c).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        Map<String, Long> collect1 = Arrays.stream(s1.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Arrays.stream(s1.split(""))
                .filter(c -> Collections.frequency(List.of(s1.split("")), c) > 1)
                .collect(Collectors.toSet())
                .forEach(System.out::println);
//        System.out.println(collect);
//        for (Map.Entry<String,Long> m : collect1.entrySet()){
////            System.out.println(m.getKey() + ":" + m.getValue());
//            if(m.getValue()>1){
//                System.out.println(m.getKey());
//
//            }
//        }
        //p -1,r-1->count>1 = return

    }

    static void getAvgAge() {

    }

    public record Employee(String name, String dept, int salary) {
    }

}


//
//public class Test {
//    public static void main(String[] args) {
//        /*
//        Find the second highest salary using Java 8 Stream
//        Find out the numbers starting with 1 using java 8
//        Find duplicate elements using java 8
//         */
//        List<Integer> salaries = Arrays.asList(10000, 5000, 8000, 3000, 12000, 8000, 15000);
//        secondHighestSalary(salaries);
//        numberStartingWithOne(salaries);
//        duplicateElements(salaries);
//        firstNonRepeatedCharacter();
//        /*
//        "WAP to find the first non-repeated character
//        I/p:- String str=""abcabcde""
//        O/p:- d
//         */
//    }
//    public static void secondHighestSalary(List<Integer> salaries){
//        Stream<Integer> salary = salaries.stream()
//                .sorted(Comparator.comparingInt(Integer::intValue).reversed()).skip(1).limit(1);
//
//        System.out.println(salary.findFirst().get());
//
//    }
//    public static void numberStartingWithOne(List<Integer> salaries){
//        // Integer - 10000 - string - toCharArray - 1,0,0,0,0 - chatAt(0) == 1 - return
////        String s = salaries.toString();
//        List<Integer> numbers = salaries.stream()
//                .filter(s -> s.toString().startsWith("1"))
//                .collect(Collectors.toList());
//        System.out.println(numbers);
//
//    }
//    public static void duplicateElements(List<Integer> salaries){
//        // Integer Stream - Integer - map - 10000 - 8000 - check in map(8000) - if yes -
//        // 1000 - 1, 8000 - 2
//        Map<Integer, Long> collect = salaries.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
//        // getValue > 1
//
//        for(Map.Entry<Integer,Long> m : collect.entrySet()){
//            if(m.getValue() > 1){
//                System.out.println(m.getKey());
//            }
//        }
//    }
//    public static void firstNonRepeatedCharacter(){
//        String str = "abcabcde";
//        char[] arr = str.toCharArray();
//        // a - 2. b - 2, c - 2, d - 1, e - 1
//        HashMap<Character,Integer> map = new HashMap<>();
//        for(int i = 0; i<arr.length; i++){
//            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
//        }
//        for(Map.Entry<Character,Integer> m : map.entrySet()){
//            if(m.getValue() == 1){
//                System.out.println(m.getKey());
//                break;
//            }
//        }
//
//    }
//}
//

