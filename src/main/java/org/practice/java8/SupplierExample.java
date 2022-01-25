package org.practice.java8;

import java.util.function.Supplier;

public class SupplierExample {

    public static void main(String[] args) {
        Supplier<Double> randIntegerSupplier = () -> Math.random();

        for(int i=0; i<10; i++)
            System.out.println(randIntegerSupplier.get());
    }
}
