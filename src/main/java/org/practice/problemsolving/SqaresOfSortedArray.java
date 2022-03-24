package org.practice.problemsolving;

public class SqaresOfSortedArray {

    public int[] sortedSquares(int[] nums) {
        int i=0, k = 0;
        int[] result = new int[nums.length];
        while(i<nums.length && nums[i] < 0) {
            i++;
        }
        int j = i - 1;
        while(i<nums.length && j >=0) {
            if(nums[i]< Math.abs(nums[j])) {
                result[k++] = nums[i] * nums[i];
                i++;
            } else {
                result[k++] = nums[j] * nums[j];
                j--;
            }
        }
        while(i< nums.length) {
            result[k++] = nums[i] * nums[i] ;
            i++;
        }
        while(j >= 0) {
            result[k++] = nums[j] * nums[j] ;
            j--;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-5,-3,-2,-1};
        SqaresOfSortedArray obj = new SqaresOfSortedArray();
        int[] result = obj.sortedSquares(nums);
        System.out.println(result);
    }


}
