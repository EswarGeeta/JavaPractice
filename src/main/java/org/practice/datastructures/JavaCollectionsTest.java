package org.practice.datastructures;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class JavaCollectionsTest {

    public static void main(String[] args) {
        Map<Integer, Integer> testMap = new TreeMap<>(Comparator.reverseOrder());
        testMap.put(10, 100);
        testMap.put(20, 20);
        testMap.put(5, 500);
        testMap.forEach( (k, v) -> System.out.println(k + " " + v));
    }
}
