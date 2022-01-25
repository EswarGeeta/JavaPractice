package org.practice.problemsolving;

import java.lang.reflect.Array;
import java.util.*;

public class PalindromePartitioning {

    public List<List<String>> partition(String s) {
        Map<String, Boolean> palindromMap = new HashMap<>();
        List<List<String>>[] results = (List<List<String>>[])new Object[10];
        for(int i=0; i<s.length(); i++) {
            for(int j=i; j<s.length(); j++) {
                String sub = s.substring(i, j+1);
                if(isPalindrom(s, palindromMap)) {
                    List<List<String>> prevResult;
                    if(i == 0) {
                        prevResult = new ArrayList<List<String>>();
                    } else {
                        prevResult = results[i-1];
                    }
                }

            }

        }
        return null;
    }

    private boolean isPalindrom(String s, Map<String, Boolean> palindromMap) {
        if(palindromMap.containsKey(s))
            return palindromMap.get(s);
        int i=0, j=s.length()-1;
        while(i<j && s.charAt(i) == s.charAt(j)) {
            i++; j--;
        }
        if(i>=j) {
            palindromMap.put(s, true);
            return true;
        } else {
            palindromMap.put(s, false);
            return false;
        }
    }

    public static void main(String[] args) {
        PalindromePartitioning obj = new PalindromePartitioning();
        obj.partition("ababcbcd");


    }
}
