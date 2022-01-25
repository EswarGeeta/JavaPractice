package org.practice.java8.interfaces;

public interface MainInterface {
    void method1();

    static void staticMethod() {
        System.out.println("This is the static method from Main interface");
    }

    default void defaultMethod() {
        System.out.println("This is the default method from Main interface");
    }
}
