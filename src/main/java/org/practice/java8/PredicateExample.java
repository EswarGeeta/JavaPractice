package org.practice.java8;

import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class PredicateExample {

    public static void main(String[] args) {
        Predicate<Integer> isEven = new Predicate<Integer>() {
            @Override
            public boolean test(Integer num) {
                return num %2 == 0;
            }
        };
        Predicate<Integer> isMutlipleOf5 = (num) -> num % 2 == 0;
        System.out.println(isEven.test(3));
        System.out.println(isMutlipleOf5.test(20));
        System.out.println(isEven.and(isMutlipleOf5).test(20));

        BiPredicate<Integer, Integer> checkIfEqual = (a, b) -> a.equals(b);
        checkIfEqual.test(10, 8);

    }




}
