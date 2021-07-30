package org.practice.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class MethodReferenceExample {

    private final List<String> elements = Arrays.asList("one", "two", "three");

    static Consumer<Integer> intConsumer = System.out::println;

    static Predicate<Integer> testEven1 = num -> num%2 == 0;

    static boolean testEven2(Integer num) {
        return num%2 == 0;
    }
    static Predicate<Integer> testEven2WithMethodReference = MethodReferenceExample::testEven2;


    public static void main(String[] args) {
        intConsumer.accept(10);
    }




}
