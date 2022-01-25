package org.practice.problemsolving;

public class LongestPalindromicSubstring {

    public String longestPalindrome(String s) {
        String result = "";
        for(int i=0; i<s.length(); i++) {
            int j = i-1, k = i+1;
            while(j>=0 && k < s.length() && s.charAt(j) == s.charAt(k)){
                j--;
                k++;
            }
            int length = k - j - 1;
            if(length > result.length()) {
                result = s.substring(j+1, k);
            }

            j = i; k = i+1;
            while(j>=0 && k < s.length() && s.charAt(j) == s.charAt(k)){
                j--;
                k++;
            }
            length = k - j - 1;
            if(length > result.length()) {
                result = s.substring(j+1, k);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring obj = new LongestPalindromicSubstring();
        System.out.println(obj.longestPalindrome("abba"));
    }
}
