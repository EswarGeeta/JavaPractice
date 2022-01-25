package org.practice.problemsolving;

import java.util.*;
import java.util.stream.Collectors;

public class LetterCombinationsOfPhoneNumber {
    public List<String> letterCombinations(String digits) {
        Map<Integer, Character[]> letterMappings = new HashMap<>();
        letterMappings.put(2, new Character[]{'a', 'b', 'c'});
        letterMappings.put(3, new Character[]{'d', 'e', 'f'});
        letterMappings.put(4, new Character[]{'g', 'h', 'i'});
        letterMappings.put(5, new Character[]{'j', 'k', 'l'});
        letterMappings.put(6, new Character[]{'m', 'n', 'o'});
        letterMappings.put(7, new Character[]{'p', 'q', 'r', 's'});
        letterMappings.put(8, new Character[]{'t', 'u', 'v'});
        letterMappings.put(9, new Character[]{'w', 'x', 'y', 'z'});

        return letterCombinationsRecursive(digits, letterMappings);
    }

    private List<String> letterCombinationsRecursive(String digits, Map<Integer, Character[]> letterMappings) {
        if(digits.equals(""))
            return new ArrayList<String>();
        List<String> currResult = new ArrayList<>();
        Character[] chars = letterMappings.get(Character.getNumericValue(digits.charAt(0)));
        if(digits.length() == 1){
            return Arrays.stream(chars).map(ch -> ch.toString()).collect(Collectors.toList());
        }
        List<String> subCombinations = letterCombinationsRecursive(digits.substring(1, digits.length()), letterMappings);
        Arrays.stream(chars).forEach(ch -> {
            List<String> currCombs = subCombinations.stream().map(comb -> ch + comb).collect(Collectors.toList());
            currResult.addAll(currCombs);
        });
        return currResult;
    }

    public static void main(String[] args) {
        LetterCombinationsOfPhoneNumber obj = new LetterCombinationsOfPhoneNumber();
        List<String> result = obj.letterCombinations("");
        System.out.println(result);

    }

}
