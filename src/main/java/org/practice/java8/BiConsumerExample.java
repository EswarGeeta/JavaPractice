package org.practice.java8;

import java.util.function.BiConsumer;

public class BiConsumerExample {
    public static void main(String[] args) {
        BiConsumer<Integer, Integer> add = (a, b) -> System.out.println("sum " + (a + b));
        add.accept(4, 5);

        BiConsumer<Integer, Integer> multiply = (a, b) -> System.out.println("Multiplication "+ (a*b));

        multiply.accept(4,5 );

        add.andThen(multiply).accept(4,5);
    }
}
