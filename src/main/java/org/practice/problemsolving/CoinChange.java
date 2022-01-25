package org.practice.problemsolving;

import java.util.HashMap;
import java.util.Map;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> dpSubAnswers = new HashMap<>();
        dpSubAnswers.put(0, 0);
        int answer = _coinChange(coins, amount, dpSubAnswers);
        return (answer == Integer.MAX_VALUE) ? -1 : answer;
    }

    private int _coinChange(int[] coins, int amount, Map<Integer, Integer> dpSubAnswers) {
        if(amount == 0)
            return 0;
        int currentMinAnswer = Integer.MAX_VALUE;
        for(int i=0; i<coins.length; i++) {
            int remaining = amount - coins[i];
            int subAnswer;
            if(remaining >= 0) {
                if(dpSubAnswers.containsKey(remaining)) {
                    subAnswer = dpSubAnswers.get(remaining);
                } else {
                    subAnswer = _coinChange(coins, remaining, dpSubAnswers);
                }
                if(subAnswer != Integer.MAX_VALUE && subAnswer + 1 < currentMinAnswer){
                    currentMinAnswer = subAnswer + 1;
                }
            }
        }
        dpSubAnswers.put(amount, currentMinAnswer);
        return currentMinAnswer;
    }

    public static void main(String[] args) {
        int[] coins = new int[]{3, 5, 7};
        CoinChange cc = new CoinChange();
        int answer = cc.coinChange(coins, 4);
        System.out.println(answer);
    }


}
