import java.util.Iterator;

public class SortedLinkedList<T extends Comparable<T>> extends OrderedDataStructure<T> {

	private LinkedListNode head = null;

	/**
	 * method to return the number of elements in the list
	 */
	@Override
	public synchronized int size() {
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

	/**
	 * method to get the value at a given index in the list
	 */
	@Override
	public T get(int index) {
		if (head == null) {	
			throw new NullPointerException();
		} 
		else if (index < 0 || index >= this.size()) { 
			throw new IndexOutOfBoundsException();	
		} 
		else {
			LinkedListNode tmp = head;
			
			for (int i = 0; i < index; i++) {	
				if (tmp.getNext() != null) {
					tmp = tmp.getNext();
				}
			}
			return tmp.getValue();
		}
	}

	/**
	 * method to add a value into the list
	 */
	@Override
	public synchronized void add(T value) {
		if (head == null) {
			head = new LinkedListNode(value, head);	
			return;
		} 
		else {	
			LinkedListNode tmp = head;		
			
			for (T item : this) {				
				if (tmp.getNext() != null) { 	
					if (tmp.getValue().compareTo(value)<=0) {
						tmp = tmp.getNext();
					}
					
				}	
			}													
			LinkedListNode next = new LinkedListNode(value, null);
			tmp.setNext(next);							
			return;
		}
	}

	/**
	 * method to search for a value in the list and return true if found
	 */
	@Override
	public boolean Search(T value) {
		
		for (T item : this) {
			if (item.compareTo(value)==0) {
				return true;	
			}
		}
		return false; 
	}

	/**
	 * grabbed from the notes
	 */
	@Override
	public Iterator<T> iterator() {
		Iterator<T> rtnIter = new Iterator<T>(){	
			private LinkedListNode current = head;	

			@Override
			public boolean hasNext() {				
				if (current != null){				
					return true;				
				} 
				else {
					return false;					
				}
			}

			@Override
			public T next() {							
				LinkedListNode currentValue = current;	
				current = current.getNext();			
				return currentValue.getValue();			
			}
		};
		return rtnIter;
	}

	/**
	 * method to create the nodes of the linked list
	 * @author jdyla
	 *
	 */
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