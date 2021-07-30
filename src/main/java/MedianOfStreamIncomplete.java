import java.util.PriorityQueue;

public class MedianOfStreamIncomplete {

	private static final PriorityQueue<Integer> minQueue = new PriorityQueue<>((a, b) -> b - a);
	private static final PriorityQueue<Integer> maxQueue = new PriorityQueue<>((a, b) -> a - b);

	public static void main(String[] args) {
		int[] elements = new int[]{10, 20, 15, 12, 16, 19, 32, 57, 43, 56, 39};

		for (int num : elements) {
			if (minQueue.isEmpty() && maxQueue.isEmpty()) {
				minQueue.add(num);
				System.out.println(minQueue.peek());
			} else if (maxQueue.isEmpty()) {
				if (num >= minQueue.peek()) {
					maxQueue.add(num);
				} else {
					maxQueue.add(minQueue.poll());
					minQueue.add(num);
				}
				System.out.println((minQueue.peek() + maxQueue.peek()) / 2);
/*		Commented code just to temporaily mask the errors
			} else if(minQueue.size() == maxQueue.size()) {
				if(num >= minQueue.peek() && num <= maxQueue.peek()) {
					minQueue.add(num);
				} else if(num )
				else {
					maxQueue.add(minQueue.poll());
					minQueue.add(num);
				}
				System.out.println((minQueue.peek() + maxQueue.peek())/2);

			}
 */

				/*		} else if(minQueue.size() == maxQueue.size() && ) {
				
			} else if(minQueue.size() >  maxQueue.size()) {
				maxQueue.add(minQueue.poll());
				minQueue.add(element);
				System.out.println((minQueue.peek() + maxQueue.peek())/2);
			} else if(minQueue.size() == maxQueue.size()){
				
			}
*/
			}
		}

	}
}