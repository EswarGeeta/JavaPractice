package org.practice.datastructures;

import java.util.Scanner;

public class LinkedList<T> {
    LinkedListNode<T> head;
    public LinkedList ( ) {
        this.head = null;
    }

    public void insert(T value) {
        LinkedListNode<T> newNode = new LinkedListNode(value);
        if(head == null) {
            head = newNode;
        } else {
            LinkedListNode<T> temp = head;
            while(temp.getNext() != null) {
                temp = temp.getNext();
            }
            temp.setNext(newNode);
        }
    }

    public void printList() {
        LinkedListNode<T> temp = head;
        while(temp != null) {
            System.out.println(temp.getValue());
            temp = temp.getNext();
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pos = Integer.parseInt(scanner.nextLine());
        System.out.println(pos);
        String numString = scanner.nextLine();
        String[] numbers = numString.split(" ");
        System.out.println(numbers.length);
        LinkedList<Integer> list = new LinkedList<>();
        for(int i =0 ; i< numbers.length; i++) {
            list.insert(Integer.parseInt(numbers[i]));
        }
        LinkedListNode<Integer> result = list.head;
        for(int i=0; i<numbers.length - pos ; i++) {
            System.out.println(result.getValue());
            result = result.getNext();
        }
        System.out.println(result.getValue());
    }
}

class LinkedListNode<T> {
    T value;
    LinkedListNode<T> next;

    public LinkedListNode(T value ) {
        this.value = value;
        this.next = null;
    }
    public T getValue() {
        return this.value;
    }

    public LinkedListNode<T> getNext() {
        return this.next;
    }

    public void setNext(LinkedListNode<T> node) {
        this.next = node;
    }
}
