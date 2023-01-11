import java.util.Iterator;

public class Queue<T extends Comparable<T>> extends OrderedDataStructure<T>{
	
	LinkedListNode head = null;
	LinkedListNode tail = null;
	
	/**
	 * Push a value onto the queue. Pushing onto the tail for ease of access to the data for pop() and top()
	 * @param value the value to be pushed onto the tail
	 */
	public synchronized void push(T value) {
		if (head == null) {
			head = new LinkedListNode(value, null);
		} 
		else if (tail == null) {
			head.setNext(new LinkedListNode(value, null));
			tail = head.getNext();
		} 
		else {
			tail.setNext(new LinkedListNode(value, null));
			tail = tail.getNext();
		}
	}
	
	/**
	 * Returns the value of the head and removes the head from the queue
	 * @return the value of the head, or null if the head is null
	 */
	public synchronized T pop() {
		T output = null;
		if (head != null) {
			output = head.getValue();
			head = head.getNext();
		}
		return output;
	}
	
	/**
	 * Returns the value of the head
	 * @return the value of the head, or null if the head is null
	 */
	public T top() {
		T output = null;
		if (head != null) {
			output = head.getValue();
		}
		return output;
	}

	@Override
	int size() {
		if (head == null) {
			return 0;
		} 
		else {
			int count = 1;
			LinkedListNode tmp = head;
			while (tmp.getNext() != null) {	
				count++;
				tmp = tmp.getNext();
			}
			return count;
		}
	}

	@Override
	T get(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	void add(T value) {
		// TODO Auto-generated method stub
		
	}

	@Override
	boolean Search(T value) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	private class LinkedListNode {
		private T value;
		private LinkedListNode next;
		
		private LinkedListNode(T value, LinkedListNode next) {
			this.value = value;
			this.next = next;
		}
		
		private T getValue() {
			return value;
		}
	
		@SuppressWarnings("unused")
		private void setValue(T value) {
			this.value = value;
		}

		private LinkedListNode getNext() {
			return next;
		}

		private void setNext(LinkedListNode next) {
			this.next = next;
		}


	}
}