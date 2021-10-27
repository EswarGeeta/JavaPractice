package org.practice.problemsolving;

public class kthGrammar {
    public int kthGrammar(int n, int k) {
        return kth_recursive(k);
    }

    private int kth_recursive(int k) {
        if(k == 1)
            return 0;
        int i=0;
        while(Math.pow(2, i) < k) {
            i++;
        }
        i--;
        return (kth_recursive(k - (int) Math.pow(2, i)) == 1) ? 0 : 1;
    }
}