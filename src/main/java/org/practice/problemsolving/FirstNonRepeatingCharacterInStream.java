package org.practice.problemsolving;

import java.util.LinkedList;
import java.util.*;
import java.util.stream.Stream;

class FirstNonRepeatingCharacterInStream {
	private final Set<String> nonRepeated = new HashSet<>();
	private final Set<String> repeated = new HashSet<>();
	private final Queue<String> printQueue = new LinkedList<>();

	private void processElement(String ch) {
		if(nonRepeated.contains(ch)) {
			nonRepeated.remove(ch);
			repeated.add(ch);
		} else if(!repeated.contains(ch)){
			nonRepeated.add(ch);
			printQueue.add(ch);
		}
		while(!printQueue.isEmpty() && repeated.contains(printQueue.peek()))
			printQueue.poll();
		if(printQueue.isEmpty())
			System.out.print(-1 + " ");
		else 
			System.out.print(printQueue.peek() + " ");

	}

	public static void main (String[] args) {
		FirstNonRepeatingCharacterInStream gfg = new FirstNonRepeatingCharacterInStream();

		Scanner sc = new Scanner(System.in);
		int count = sc.nextInt();
		sc.nextLine();
		for(int i=0; i < count; i++) {
			gfg.nonRepeated.clear();
			gfg.repeated.clear();
			gfg.printQueue.clear();
			sc.nextLine();
			String input = sc.nextLine();
			String[] elements = input.split(" ");
			Stream.of(elements).forEach(gfg::processElement);
		}
		sc.close();
	}
}