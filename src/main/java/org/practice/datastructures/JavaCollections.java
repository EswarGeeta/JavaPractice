package org.practice.datastructures;

import java.util.LinkedHashMap;

public class JavaCollections {

    public static void main(String[] args) {

//        Use LinkedHashMap for implementing LRUCache. Just make sure accessOrder parameter is specified as true
        LinkedHashMap<Integer, String> lhm = new LinkedHashMap<Integer, String>(10, 75, true);
        lhm.put(1, "one");
        lhm.put(2, "two");
        lhm.put(3, "three");
        lhm.get(2);
        lhm.get(1);
        lhm.entrySet().forEach(element -> System.out.println(element.getKey() + element.getValue()));


//        LinkedHashSet<Integer> lhs = new LinkedHashSet<Integer>();
//        lhm.put(1, "one");
//        lhm.put(2, "two");
//        lhm.put(3, "three");
//
//        lhm.get(2);
//        lhm.get(1);
//
//        lhm.remove(1);
//
//        lhm.entrySet().forEach(element -> System.out.println(element.getKey() + element.getValue()));

    }
}
