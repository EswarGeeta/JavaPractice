package org.practice.problemsolving;

import java.math.BigInteger;

public class SmallestNumberDivisibleByK {
    public int smallestRepunitDivByK(int k) {
        if(k % 2 == 0 || k % 5 == 0)
            return -1;
        int n = 1;
        for(int digitCount = 1; true; digitCount++) {
            int reminder = n % k;
            if( reminder == 0) {
                return digitCount;
            } else {
                n = reminder * 10 + 1;
                System.out.println(n);
            }
        }
    }

    public static void main(String[] args) {
        int k = 21;
        SmallestNumberDivisibleByK obj = new SmallestNumberDivisibleByK();
        System.out.println(obj.smallestRepunitDivByK(k));
    }
}
