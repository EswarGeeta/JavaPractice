package org.practice.problemsolving;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

class MedianFinder {
    private Queue<Integer> lowers;
    private Queue<Integer> highers;

    public MedianFinder() {
        lowers = new PriorityQueue<>(Collections.reverseOrder());
        highers = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(lowers.isEmpty()) {
            lowers.add(num);
            return;
        }
        if(lowers.size() ==  1 && highers.isEmpty()) {
            if(lowers.peek() < num)
                highers.add(num);
            else if(lowers.peek() > num) {
                int leftTop = lowers.poll();
                highers.add(leftTop);
                lowers.add(num);
            }
            return;
        }
        if(num < highers.peek() && num >= lowers.peek()) {
            if(lowers.size() > highers.size())
                highers.add(num);
            else
                lowers.add(num);
        }
        if(num < lowers.peek()) {
            if(lowers.size() > highers.size()) {
                int leftTop = lowers.poll();
                highers.add(leftTop);
            }
            lowers.add(num);
        }
        if(num >= highers.peek()) {
            if (lowers.size() <= highers.size()) {
                int rightTop = highers.poll();
                lowers.add(rightTop);
            }
            highers.add(num);
        }
    }
    
    public double findMedian() {
        if(lowers.size() > highers.size()) {
            return lowers.peek();
        } else {
            return (lowers.peek() + highers.peek())/2;
        }
    }

    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        int[] nums = new int[]{6, 10, 2, 6,5, 0, 6};
        for(int num: nums) {
            obj.addNum(num);
            System.out.print("left heap");
            for(int i : obj.lowers){
                System.out.print(i);
            }
            System.out.print("\nright heap");
            for(int i : obj.highers){
                System.out.println(i);
            }
            System.out.println();
        }
        double result = obj.findMedian();
        System.out.println(result);
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */