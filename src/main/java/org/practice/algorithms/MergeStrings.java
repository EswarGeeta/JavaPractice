package org.practice.algorithms;

import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Stream;

public class MergeStrings {
	public static void main(String[] args) {
		Map<String, Integer> fruitCounts = new HashMap<>();
		PriorityQueue<Fruit> queue = new PriorityQueue<Fruit>(Comparator.comparing(Fruit::getCount, Comparator.reverseOrder()));
		try(Scanner sc = new Scanner(System.in)) {
			String[] fruits = sc.nextLine().split(",");
			Stream.of(fruits).forEach(fruit -> {
				if(fruitCounts.containsKey(fruit)) 
					fruitCounts.put(fruit, fruitCounts.get(fruit)+1 );
				else
					fruitCounts.put(fruit, 1);
			});
			
			for(Entry<String, Integer> entry : fruitCounts.entrySet()) {
				queue.add(new Fruit(entry.getKey(), entry.getValue()));
			}

			int sum = queue.stream().mapToInt(Fruit::getCount).sum();
			OptionalInt max = queue.stream().mapToInt(Fruit::getCount).max();

			if(max.isPresent() && max.getAsInt() > sum+1- max.getAsInt()) {
				System.out.println("Not possible");
				return;
			}


			StringBuilder result = new StringBuilder();
			String fruitName = "";
			
			Fruit repeatedFruit = null;
			while(!queue.isEmpty()) {
				Fruit fruit = queue.poll();
				if(fruit.getName().equals(fruitName)) {
					repeatedFruit = fruit;
					fruit = queue.poll();
				}
				fruitName = fruit.getName();
				if(fruit.getCount() > 1) {
					fruit.setCount(fruit.getCount() -1 );
					queue.add(fruit);
				}
				result.append(fruitName+ ", ");
				
				if(Objects.nonNull(repeatedFruit)) {
					queue.add(repeatedFruit);
					repeatedFruit = null;
				}
			}
			System.out.println(result);
			
		}
	}
	
	
	
	static class Fruit {
		String name;
		int count;
		
		public Fruit(String name, int count) {
			super();
			this.name = name;
			this.count = count;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
	}
}
