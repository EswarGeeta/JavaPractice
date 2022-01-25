package org.practice.java8;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Java8Examples {

    public static boolean isPrime(int n) {
        int i = 0;
        for(i=2; i<n; i++) {
            if(n % i == 0)
                break;
        }
        return n > 1 && i == n;
    }

    public static boolean isPrime2(int n) {
        return (n > 1) && IntStream.range(2, n).noneMatch( i -> n % i == 0 );
    }

    public static void main(String[] args) {
        System.out.println(isPrime(7));
        System.out.println(isPrime(6));

        System.out.println(isPrime2(7));
        System.out.println(isPrime2(6));

        // Get square root of first 10 prime numbers
        List<Double> sqrts10prime = Stream.iterate(1, i -> i+1)
                .filter(Java8Examples::isPrime2).peek(System.out::println)
                .map(Math::sqrt)
                .limit(10)
                .collect(Collectors.toList());

        System.out.println("Square roots for first 10 prime numbers ");
        sqrts10prime.forEach(System.out::println);

    }
}
