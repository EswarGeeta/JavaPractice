package org.practice.java8.interfaces;

public class Client implements SubInterface1 {
    @Override
    public void method1() {
        System.out.println("This is implementation for the abstract method method1");
    }
}
