package org.practice.sorting;

public class SortingUtil {

    public static void heapSort(int[] input) {
        maxHeapifyArray(input);
        for(int i=input.length-1; i>0; i--){
            swap(input, 0, i);
            maxHeapifyElement(input, 0, i-1);
        }
    }

    private static void maxHeapifyArray(int[] input) {
        for(int i= input.length/2-1; i>=0 ; i-- )
            maxHeapifyElement(input, i);
    }

    private static void maxHeapifyElement(int[] input, int index) {
        maxHeapifyElement(input, index, input.length-1);
    }

    private static void maxHeapifyElement(int[] input, int index, int limit) {
        int maxIndex = index;
        int left = 2*index+1, right = 2*index + 2;
        if(left <= limit && input[left] > input[index])
            maxIndex = left;
        if(right <= limit && input[right] > input[maxIndex])
            maxIndex = right;
        if(index != maxIndex){
            swap(input, index, maxIndex);
            maxHeapifyElement(input, maxIndex, limit);
        }
    }

    private static void swap(int[] input, int index, int left) {
        int tmp = input[index];
        input[index] = input[left];
        input[left] = tmp;
    }

}
