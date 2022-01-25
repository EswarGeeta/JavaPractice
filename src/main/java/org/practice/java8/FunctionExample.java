package org.practice.java8;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FunctionExample {
    public static void main(String[] args) {
        Function<String, String> upper = (str) -> str.toUpperCase();
        Function<String, String> padding = (str) -> "xxxxx" + str + "xxxxx";

        Function<String, String> upperAndThenPadding = upper.andThen(padding);
        System.out.println(upperAndThenPadding.apply("sample"));
        System.out.println(upper.compose(padding).apply("sample"));

        List<String> names = Arrays.asList("one", "two", "three", "four");
        System.out.println(names.stream().sorted(Comparator.comparing(String::length)).collect(Collectors.toList()));
        System.out.println(names.stream().sorted((name1, name2) -> Integer.compare(name1.length(), name2.length())).collect(Collectors.toList()));

        names.forEach(System.out::println);
        names.stream().count();

        System.out.println(names.stream().collect(Collectors.joining()));
        System.out.println(names.stream().collect(Collectors.joining(" - ")));
        System.out.println(names.stream().collect(Collectors.joining(" - ", "(", ")")));
        Set<Integer> result = names.stream().collect(Collectors.mapping(String::length, Collectors.toSet()));

        System.out.println(names.stream().collect(Collectors.counting()));

        System.out.println("No of cpu processors:" + Runtime.getRuntime().availableProcessors());
        names.stream().reduce((name1, name2) -> name1.length() > name2.length() ? name1 : name2).ifPresent( System.out::println);
        System.out.println(names.stream().collect(Collectors.summingInt(String::length)));
        System.out.println(names.stream().collect(Collectors.averagingInt(String::length)));

        System.out.println(names.stream().collect(Collectors.groupingBy(String::length)));

        List<Integer> numbers = Arrays.asList(1,5,2,5,7,3,25,3);
        System.out.println(numbers.stream().reduce(Integer.MAX_VALUE, Integer::min));
        numbers.stream().reduce(Integer::min).ifPresent(System.out::println);
        numbers.stream().min(Integer::compareTo).ifPresent(System.out::println);
        numbers.stream().limit(3).reduce(Integer::sum).ifPresent(System.out::println); //limit -> considers only first 3 elements
        numbers.stream().skip(3).reduce(Integer::sum).ifPresent(System.out::println); //skip -> skips first 3 elements

        System.out.println(numbers.stream().allMatch(a -> a > 0));
        System.out.println(numbers.stream().anyMatch(a -> a > 20));
        System.out.println(numbers.stream().noneMatch(a -> a > 26));

        System.out.println(IntStream.rangeClosed(1, 10).sum());

        Stream.of(1,2,3,4,5,6).forEach( System.out::print);
        Stream.iterate(1, a -> a + 1).limit(20).forEach(System.out::print);

        Supplier randomSup = new Random()::nextInt;
        Stream.generate(randomSup).limit(5).forEach(System.out::println);

        Optional.empty();

    }

    Function<String, String> toUppercaselambda = s -> s.toUpperCase();
    Function<String, String> getToUppercaseMethodReference = String::toUpperCase;
}
