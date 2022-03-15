package org.practice.problemsolving;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int i=0, j=0, max= Integer.MIN_VALUE, current = 0;
        while(j<nums.length) {
            current = current + nums[j];
            if(current > max)
                max = current;
            if(current < 1) {
                j++;
                i=j;
                current = 0;
            } else {
                j++;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        MaximumSubarray obj = new MaximumSubarray();
        System.out.println(obj.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
