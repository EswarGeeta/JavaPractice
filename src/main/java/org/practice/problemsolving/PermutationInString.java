package org.practice.problemsolving;

import java.util.Arrays;
import java.util.HashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
   Problem: https://leetcode.com/problems/permutation-in-string/
 */
public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        // Loop through s1 until all chars
        // If char not equal, empty the reset the hashmap
        // If the char is found, reduce element from hashmap, remove element from map when count goes to 0
        // Check if the map is empty, if yes, return true
        // If the loop completes, return false

        HashMap<Character, Integer> charCounts = new HashMap<>();
        for (char c : s1.toCharArray()) {
            if(charCounts.containsKey(c))
                charCounts.put(c, charCounts.get(c) + 1);
            else
                charCounts.put(c,1);
        }
        HashMap<Character, Integer> bkpMap = (HashMap<Character, Integer>) charCounts.clone();
        for(char c: s2.toCharArray()) {
            if(charCounts.containsKey(c)) {
                if(charCounts.get(c) == 1)
                    charCounts.remove(c);
                else
                    charCounts.put(c, charCounts.get(c) -1);
                if(charCounts.isEmpty())
                    return true;
            } else {
                charCounts = (HashMap<Character, Integer>) bkpMap.clone();
            }
        }
        return false;
    }

}
