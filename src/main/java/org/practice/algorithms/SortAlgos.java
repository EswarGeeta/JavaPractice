package org.practice.algorithms;

public class SortAlgos {

    public static void quickSort(int[] a) {
        quickSort(a, 0, a.length - 1);
    }
    public static void quickSort(int[] a, int low, int high) {
        int pivot_pos;
        if (low < high) {
            pivot_pos = partition(a, low, high);
            quickSort(a, low, pivot_pos - 1);
            quickSort(a, pivot_pos + 1, high);
        }
    }
    public static int partition(int[] a, int low, int high) {
        int pivot_elt, i, j, tmp;
        pivot_elt = a[low];
        i = low;
        j = high;
        while (i < j) {
            while (a[i] <= pivot_elt && i < high) i++;
            while (a[j] > pivot_elt && j > low) j--;
            if (i < j) {
                tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
            }
        }
        a[low] = a[j];
        a[j] = pivot_elt;
        return j;
    }


/*
    Complexity: Average and worst: T(n) = 2T(n/2) + O(n)  = O(n log n)
    space: O(n) auxiliary
*/
    public int mergeSort(int[] a) {
        return mergeSort(a, 0, a.length - 1);
    }

    public static int mergeSort(int[] a, int left, int right) {
        int inv_left = 0, inv_right = 0, inv = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;
            inv_left = mergeSort(a, left, mid);
            inv_right = mergeSort(a, mid + 1, right);
            inv = inv_left + inv_right + merge(a, left, mid, right);
        }
        return inv;
    }

    public static int merge(int[] a, int left, int mid, int right) {
        int i = left, j = mid + 1, k = 0, inv = 0;
        int temp[] = new int[right - left + 1];
        while (i <= mid && j <= right) {
            if (a[i] <= a[j]) {
                temp[k++] = a[i++];
            } else {
                temp[k++] = a[j++];
                inv += (mid - i + 1);
            }
        }
        while (i <= mid)
            temp[k++] = a[i++];
        while (j <= right)
            temp[k++] = a[j++];

        for (i = right; i >= left; i--)
            a[i] = temp[--k];
        return inv;
    }

    public static void main(String[] args) {
        int[] arr = {1, 10, 2, 8, 3, 9, 5, 6, 7, 4};
        for (int i : arr) {
            System.out.print(i + " ");
        }

        //        quickSort(arr);
//        System.out.println("After quick sort");
//        for (int i : arr) {
//            System.out.print(i + " ");
//        }

        SortAlgos algo = new SortAlgos();
        algo.mergeSort(arr);
        System.out.println("After quick sort");
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
