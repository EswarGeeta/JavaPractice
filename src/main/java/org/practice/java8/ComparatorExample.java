package org.practice.java8;

import java.util.Comparator;

public class ComparatorExample {
    public static void main(String[] args) {
        Comparator<Integer> comparator1 = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        Comparator<Integer> comparator2 = (i1, i2) -> i1.compareTo(i2);

        System.out.println(comparator1.compare(5, 3));
        System.out.println(comparator2.compare(3, 5));


    }
}
