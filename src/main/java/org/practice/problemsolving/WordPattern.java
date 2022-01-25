package org.practice.problemsolving;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        char[] chs = pattern.toCharArray();
        String[] words = s.split(" ");
        Map<Character, String> wordMap = new HashMap<>();
        for(int i=0; i < chs.length; i++) {
            if(wordMap.containsKey(chs[i]) && !wordMap.get(chs[i]).equals(words[i])) {
                return false;
            }
            wordMap.put(chs[i], words[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        WordPattern obj = new WordPattern();
        System.out.println(obj.wordPattern("abba", "dog dog dog dog"));
    }
}
