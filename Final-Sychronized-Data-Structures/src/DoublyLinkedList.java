import java.util.Iterator;

public class DoublyLinkedList<T extends Comparable<T>> extends OrderedDataStructure<T> {
	
	private DoubleLinkedListNode head = null;
	private DoubleLinkedListNode tail = null;

	/**
	 * method to get the number of elements in the list
	 */
	@Override
	public int size() {
		if (head == null) {
			return 0;		// if the head doesn't exists, the size is zero
		} 
		else {
			int count = 1;	// start count at 1
			DoubleLinkedListNode tmp = head;	// create a temporary LinkedListNode to hold each value
			while (tmp.getNext() != null) {	// while there is another node after the current temp
				count++;	// increase count by 1
				tmp = tmp.getNext();	// set the temp to the next node
			}
			return count;	// return the count at the end
		}
	}

	/**
	 * method to get the value of an element at a certain index
	 */
	@Override
	public T get(int index) {
		if (head == null) {	
			throw new NullPointerException();	// if head = null, throw an exception
		} 
		else if (index < 0 || index >= this.size()) { // when index is out of bounds
			throw new IndexOutOfBoundsException();	// throw an exception
		} 
		else {
			DoubleLinkedListNode tmp = head;	// create temp to hold current value
			for (int i = 0; i < index; i++) {	// go to the node entered
				if (tmp.getNext() != null) {
					tmp = tmp.getNext();
				}
			}
			return tmp.getValue();
		}
	}

	/**
	 * method to add an element at a certain index in the list
	 */
	@Override
	public synchronized void add(T value) {
		if (head == null) {
			head = new DoubleLinkedListNode(value, head, null);		// if the head doesn't exist, make one
			tail = head;
			return;
		} 
		else {	// otherwise
			DoubleLinkedListNode tmp = head;			// create a temp and itererate
			for (T item : this) {				// loop through each item in this
				if (tmp.getNext() != null) { 	// if the next exists, get it
					tmp = tmp.getNext();		
				}
			}
			DoubleLinkedListNode next = new DoubleLinkedListNode(value, null, tmp);	// add one more element
			tmp.setNext(next);										// insert it as the next of temp
			tail = next;
			return;
		}
	}

	/**
	 * method to search for a certain value in the list, returning true if it is found
	 */
	@Override
	public boolean Search(T value) {
		for (T item : this) {
			if (item.compareTo(value)==0) {
				return true;		// if the item exists, return true
			}
		}
		return false; 				// return false by default
	}

	/**
	 * pulled these from notes
	 */
	@Override
	public Iterator<T> iterator() {
		// code from the notes, needs no changes so made none.
		Iterator<T> rtnIter = new Iterator<T>(){	// create anonymous iterator
			private DoubleLinkedListNode current = head;	// current is the head

			@Override
			public boolean hasNext() {				// check for iterationabillity
				if (current != null){				// if the current exists
					return true;					// return true
				} else {
					return false;					// otherwise return false
				}
			}

			@Override
			public T next() {							// get the next T value
				DoubleLinkedListNode currentValue = current;	// save the current value
				current = current.getNext();			// iterate the current variable
				return currentValue.getValue();			// return the value of currentValue
			}
		};
		return rtnIter; // return the anonymous iterator
	}

	/**
	 * method to create the nodes as a private inner class
	 *
	 */
	private class DoubleLinkedListNode {
		private T value;
		private DoubleLinkedListNode next;
		private DoubleLinkedListNode prev;
		
		private DoubleLinkedListNode(T value, DoubleLinkedListNode next, DoubleLinkedListNode prev) {
			this.value = value;
			this.next = next;
			this.prev = prev;
		}
		
		private T getValue() {
			return value;
		}
		private void setValue(T value) {
			this.value = value;
		}
		private DoubleLinkedListNode getNext() {
			return next;
		}
		private void setNext(DoubleLinkedListNode next) {
			this.next = next;
		}
		private DoubleLinkedListNode getPrev() {
			return prev;
		}
		private void setPrev(DoubleLinkedListNode prev) {
			this.prev = prev;
		}
		


	}

}