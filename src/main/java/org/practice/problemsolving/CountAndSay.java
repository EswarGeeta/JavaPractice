package org.practice.problemsolving;

public class CountAndSay {
    public String countAndSay(int n) {
        if(n == 1)
            return String.valueOf(1);
        String prev = countAndSay(n-1);
        String result = "";
        int i=0, count=1;
        while(i<prev.length()) {
            if(i!=prev.length()-1 &&  prev.charAt(i) == prev.charAt(i+1) ) {
                i++;
                count++;
            } else {
                result += String.valueOf(count) + prev.charAt(i);
                count = 1;
                i++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        CountAndSay obj = new CountAndSay();
        System.out.println(obj.countAndSay(10));
    }
}
