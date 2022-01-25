package org.practice.datastructures;

import java.util.*;

public class LRUCache2 {
    int capacity;
    Map<Integer, DLLNode> cache;
    DoubleLinkedList dll;

    public LRUCache2(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        dll = new DoubleLinkedList();
    }

    public int get(int key) {
        int value = -1;
        if (cache.containsKey(key)) {
            DLLNode node = cache.get(key);
            dll.moveToFirst(node);
            value = node.value;
        }
        return value;
    }

    public void put(int key, int value) {
        if(cache.containsKey(key)){
            DLLNode node = cache.get(key);
            node.value = value;
            dll.moveToFirst(node);
            return;
        }
        if(cache.size() == capacity) {
            DLLNode node = dll.removeLast();
            cache.remove(node.key);
        }
        DLLNode node = new DLLNode(key, value);
        cache.put(key, node);
        dll.addFirst(node);
    }


    public static void main(String[] args) {
        LRUCache2 cache = new LRUCache2(2);
        System.out.println(cache.get(2));
        cache.put(2,6);
        System.out.println(cache.get(1));
        cache.put(1,5);
        cache.put(1,2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }
}


class DoubleLinkedList {
    DLLNode head, tail;
    public void addFirst(DLLNode node) {
        if(node != null) {
            if(head == null) {
                head = node;
                tail = node;
                return;
            }
            node.next = head;
            head.prev = node;
            head = node;
        }
    }

    public DLLNode removeLast() {
        DLLNode toRemove = tail;
        if(head != tail) {
            tail = tail.prev;
            tail.next.prev = null;
            tail.next = null;
        } else {
            head = null;
            tail = null;
        }
        return toRemove;
    }

    public void moveToFirst(DLLNode node) {
        if(node != null) {
            if(node == head)
                return;
            node.prev.next = node.next;
            if(node != tail)
                node.next.prev = node.prev;
            else
                tail = tail.prev;

            node.next = head;
            head.prev = node;
            head = node;
        }
    }
}

class DLLNode {
    int key;
    int value;
    DLLNode prev;
    DLLNode next;

    DLLNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}
