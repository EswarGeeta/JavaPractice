package org.practice.problemsolving;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Stack;

public class OverlapIntervals {
    public static void main(String[] args) {

        ArrayList<pair> vec = new ArrayList<>();
        vec.add(new pair(6,8));
        vec.add(new pair(1,9));
        vec.add(new pair(2,4));
        vec.add(new pair(4,7));
        ArrayList<pair> result = overlappedInterval(vec, vec.size());
        System.out.println("--------");
        result.forEach(pair -> System.out.println(pair.first + " " + pair.second));
    }

    public static ArrayList<pair> overlappedInterval(ArrayList<pair> vec, int n)
    {
        // code here
        vec.sort(Comparator.comparing((a) -> a.first));
        Stack<pair> intervalStack = new Stack<>();
        for(pair interval : vec) {
            if(intervalStack.isEmpty()) {
                System.out.println(interval.first + " " + interval.second);
                intervalStack.push(interval);
                continue;
            }
            System.out.println(interval.first + " " + interval.second);
            pair prevInterval = intervalStack.peek();
            if(prevInterval.second > interval.first) {
                System.out.println(prevInterval.second + " " + interval.first);
                intervalStack.pop();
                intervalStack.push(new pair(prevInterval.first, Math.max(prevInterval.second, interval.second)));
            } else
                intervalStack.push(interval);
        }

        ArrayList<pair> result = new ArrayList<>();
        while(! intervalStack.isEmpty())
            result.add(0, intervalStack.pop());
        return result;
    }
}


class pair
{
    int first;
    int second;
    pair(int first, int second)
    {
        this.first = first;
        this.second = second;
    }
}