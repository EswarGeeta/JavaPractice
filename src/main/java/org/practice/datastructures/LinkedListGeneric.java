//import java.util.Comparator;
//
//public class LinkedListGeneric<T> {
//	Node<T> head;
//	Comparator<T> comparator;
//
//	public LinkedListGeneric(Comparator<T> comparator){
//		this.comparator = comparator;
//	}
//
//	public boolean isEmpty() {
//		return head == null;
//	}
//
//	public T checkFirst() {
//		return head.data;
//	}
//
//	public T removeFirst() throws Exception{
//		if(head == null)
//			throw new Exception("List empty");
//		T data = head.data;
//		head = head.next;
//		return data;
//	}
//
//	public void insert(T data) {
//		Node<T> curr = new Node<T>(data);
//		Node<T> temp = head, prev = null;
//		while(temp != null && comparator.compare(temp.data, data) < 0) {
//			prev = temp;
//			temp = temp.next;
//		}
//		curr.next = temp;
//		if(prev == null)
//			head = curr;
//		else
//			prev.next = curr;
//	}
//
//	public void printQueue() {
//		Node<T> temp = head;
//		while (temp != null) {
//			System.out.println(temp.data);
//			temp = temp.next;
//		}
//	}
//	public static void main(String args[]) {
//		LinkedListGeneric<Employee> queue = new LinkedListGeneric<>((e1, e2) -> Integer.valueOf((int) (e1.salary - e2.salary)));
//		queue.insert(new Employee(1, "eswar", 100));
//		queue.insert(new Employee(2, "geeta", 80));
//		queue.insert(new Employee(3, "lakhit", 90));
//		queue.printQueue();
//
//	}
//}
//
//class Node<T>{
//	T data;
//	Node<T> next;
//
//	public Node(T data) {
//		this.data = data;
//		next = null;
//	}
//}
//
////class Employee {
////	int id;
////	String name;
////	double salary;
////	public Employee(int id, String name, double salary) {
////		this.id = id;
////		this.salary = salary;
////		this.name = name;
////	}
////	public String toString() {
////		return "Employee: [" + id + ", " + name + ", " + salary + "]";
////	}
////}