package org.practice.java8.interfaces;

public interface SubInterface1 extends MainInterface {
    @Override
    default void defaultMethod() {
        MainInterface.super.defaultMethod();
        System.out.println("Default method override in subclass");
    }
}
