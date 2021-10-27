package org.practice.problemsolving;

public class KthLargest {
    private int[] top;

    public KthLargest(int k, int[] nums) {
        top = new int[k];
        for(int i=0; i<k ; i++){
            top[i] = Integer.MIN_VALUE;
        }

        for(int i=0; i<nums.length; i++) {
            sortedInsert(nums[i]);
        }
    }

    public void sortedInsert(int inp) {
        int i=0;
        while(i<top.length && inp <= top[i])
            i++;
        if(i == top.length)
            return;
        int tmp;
        while(i<top.length) {
            tmp = top[i];
            top[i] = inp;
            inp = tmp;
            i++;
        }
    }
    
    public int add(int val) {
        sortedInsert(val);
        return top[top.length-1];
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */