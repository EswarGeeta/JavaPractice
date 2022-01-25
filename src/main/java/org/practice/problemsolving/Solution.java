package org.practice.problemsolving;

import java.util.*;

class Solution {
    public int findJudge(int n, int[][] trust) {
        Map<Integer, Integer> trustMap = new HashMap<>();
        for(int i=0; i<trust.length; i++) {
            if(trustMap.containsKey(trust[i][1])) {
                trustMap.put(trust[i][1], trustMap.get(trust[i][1])+1);
            }
            else
                trustMap.put(trust[i][1], 1);
        }
        for(int i=0; i<trust.length; i++) {
            trustMap.remove(trust[i][0]);
        }

        if(trustMap.size() == 1){
            Optional<Map.Entry<Integer, Integer>> judgeOptional = trustMap.entrySet().stream().filter(entry -> entry.getValue() + 1 == trust.length).findFirst();
            if(judgeOptional.isPresent())
                return judgeOptional.get().getKey();
            else return -1;
        }
        else
            return -1;
    }


}