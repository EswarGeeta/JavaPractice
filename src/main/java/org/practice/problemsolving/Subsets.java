package org.practice.problemsolving;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        return subsetsRecursive(nums, 0);
    }

    private List<List<Integer>> subsetsRecursive(int[] nums, int index) {
        List<List<Integer>> result = new ArrayList<>();
        if(index == nums.length - 1) {
            result.add(new ArrayList<>());
            List<Integer> sub = new ArrayList<>();
            sub.add(nums[index]);
            result.add(sub);
            return result;
        }
        List<List<Integer>> subResult = subsetsRecursive(nums, index+1);
        subResult.forEach(sub -> {
            List<Integer> subNew = new ArrayList<>(sub);
            subNew.add(nums[index]);
            result.add(new ArrayList<>(subNew));
        });
        result.addAll(subResult);
        return result;
    }


    public static void main(String[] args) {
        Subsets obj = new Subsets();
        obj.subsets(new int[]{1,2,3});
    }
}
