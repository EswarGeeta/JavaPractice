package org.practice.problemsolving;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;

public class TopKFrequent {
    public int[] topKFrequent(int[] nums, int k) {

        @Data
        class Element {
            private int num;
            private int frequency;

            public Element(int num, int frequency) {
                this.num = num;
                this.frequency = frequency;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Element element = (Element) o;
                return num == element.num;
            }

            @Override
            public int hashCode() {
                return Objects.hash(num);
            }
        }

        Map<Integer, Integer> numsFreqMap = new HashMap<>();
        for(int num: nums) {
            if(numsFreqMap.containsKey(num))
                numsFreqMap.put(num, numsFreqMap.get(num) + 1);
            else
                numsFreqMap.put(num, 1);
        }

        Queue<Element> frequentNums = new PriorityQueue<>((ele1, ele2) -> ele2.frequency - ele1.frequency);


        for(Map.Entry<Integer, Integer> entry: numsFreqMap.entrySet())
            frequentNums.add(new Element(entry.getKey(), entry.getValue()));

        int[] result = new int[k];
        for(int i=0; i<result.length; i++) {
            result[i] = frequentNums.poll().getNum();
        }
        return result;
//        return frequentNums.stream().mapToInt(element -> element.getNum()).toArray();
    }

    public static void main(String[] args) {
        TopKFrequent topKFrequent = new TopKFrequent();
        int[] nums = new int[]{4,2,6,3,6,8,3,12,4,7,4,2,9,7,6,5,3,2,4,9};
        int[] result = topKFrequent.topKFrequent(nums, 5);
        for(int i: result)
            System.out.println(i);


    }
}
