package org.practice.sorting;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{65, 32, 43, 88, 10};
        SortingUtil.heapSort(arr);
        for(int num: arr) {
            System.out.println(num);
        }
    }
}
