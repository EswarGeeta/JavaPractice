package org.practice.problemsolving;

class CircularArrayLoop {
    public boolean circularArrayLoop(int[] nums) {
        int[] positions = new int[nums.length];
        int i=0;
        while(i< nums.length) {
            // Reach to i=0 position.
            while(i < nums.length && positions[i] ==-1)
                i++;

            if(i == nums.length)
                break;
            //Move till we get a 1 or -1.
            int j = i;
            while(positions[j] == 0) {
                positions[j] = 1;
                j = ( j + nums[j]) % nums.length;
                if(j < 0)
                    j = nums.length + j;
            }
            // If positions[j] is 1, it indicates a possibility of circle. See if it is circle by validating that all the number are either positive or negative
            boolean isPrevPositive = nums[j] > 0;
            int count = 0;
            if(positions[j] == 1) {
                while(positions[j] == 1 && isPrevPositive == nums[j] > 0) {
                    count++;
                    positions[j] = -1;
                    isPrevPositive = nums[j] > 0;
                    j = ( j + nums[j]) % nums.length;
                    if(j < 0)
                        j = nums.length + j;
                }
                if (isPrevPositive == nums[j] > 0 && count > 1)
                    return true;
            }
            //Mark the traversed positions to -1 so that we don't traverse them again.
            j = i;
            while(positions[j] == 1) {
                positions[j] = -1;
                j = ( j + nums[j]) % nums.length;
                if(j < 0)
                    j = nums.length + j;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-1,-2,-2};
        CircularArrayLoop circularArrayLoop = new CircularArrayLoop();
        System.out.println(circularArrayLoop.circularArrayLoop(nums));
    }
}