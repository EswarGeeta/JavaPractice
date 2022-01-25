package org.practice.java8;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsExamples {

    public static void main(String[] args) {
        //Find duplicate elements from Array
        List<Integer> nums = Arrays.asList(10, 28, 87, 10, 20, 76, 28, 80);
        Set<Integer> distinct = new HashSet<>();
        List<Integer> result =  nums.stream().filter(num -> !distinct.add(num)).collect(Collectors.toList());
        result.forEach(System.out::println);

        //multiple 2 numbers with functional interface
        BiFunction<Integer, Integer, Integer> multiply = (a, b) -> a * b;
        System.out.println(multiply.apply(10, 20));

        //limit and skip
        System.out.println("Limit");
        nums.stream().limit(3).forEach(num -> System.out.print(num + " "));
        System.out.println("\nSkip");
        nums.stream().skip(3).forEach(num -> System.out.print(num + " "));

        //Count number of occurrences of words in string
        System.out.println("\nCount the occurrences");
        String sample = "welcome to code decode and code decode welcome you";
        Map<String, Integer> occurrences = new HashMap<>();
        Arrays.stream(sample.split(" ")).forEach(word -> occurrences.put(word, (occurrences.containsKey(word)) ? occurrences.get(word) + 1 : 1));
        Map<String, Long> occurrences2 = Arrays.stream(sample.split(" ")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        occurrences.entrySet().forEach(System.out::println);
    }
}
