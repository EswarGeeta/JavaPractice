package org.practice.problemsolving;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int [] positions = new int[n];
        for(int i=0; i<positions.length; i++) {
            positions[i] = -1;
        }
        solveNQueensRecursive(0, positions, result);
        return result;
    }

    private void solveNQueensRecursive(int curr, int[] positions, List<List<String>> result) {
        for(int i=0;i<positions.length; i++) {

        }
    }

    public static void main(String[] args) {
        NQueen obj = new NQueen();
        obj.solveNQueens(4);
    }
}
