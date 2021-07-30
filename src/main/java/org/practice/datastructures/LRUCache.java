package org.practice.datastructures;

import java.util.LinkedHashMap;

public class LRUCache {
    LinkedHashMap<Integer, String> cache;
    int max_size;

    public LRUCache() {
        cache = new LinkedHashMap<>(5, 75, true);
        max_size = 3;
    }
    private void put(int key, String value) {
        if(cache.size() == max_size) {
            int leastUsedKey = cache.keySet().iterator().next();
            cache.remove(leastUsedKey);
        }
        cache.put(key, value);
    }

    private String get(int key) {
        return cache.get(key);
    }

    private void printCache() {
        System.out.println("=======");
        cache.entrySet().forEach(entry -> System.out.println(entry.getKey() + entry.getValue()));
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache();
        lruCache.put(1, "one");
        lruCache.put(2, "two");
        lruCache.put(3, "three");

        lruCache.printCache();

        lruCache.get(2);
        lruCache.printCache();

        lruCache.put(4, "four");
        lruCache.printCache();

        lruCache.get(3);
        lruCache.printCache();
    }

}
