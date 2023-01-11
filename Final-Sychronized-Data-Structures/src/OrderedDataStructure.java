import java.util.ArrayList;
import java.util.Iterator;

abstract class OrderedDataStructure<T extends Comparable<T>> extends Thread implements Iterable<T> {
	
	abstract int size();
	abstract T get(int index);
	abstract void add(T value);
	abstract boolean Search(T value);
	public abstract Iterator<T> iterator();
	
	/**
	 * method to create and return an array list for each item
	 * @return
	 */
	public ArrayList<T> toArrayList() {
		ArrayList<T> returnList = new ArrayList<>();
		
		for (T item : this) {
			returnList.add(item);
		}
		
		return returnList;
	}
	
	/**
	 * method to print all the values of the ordered data structure
	 * @return
	 */
	public String printAllValues() {
		String output = "";
		
		for (T item : this) {
			output += ", " + item.toString();
		}
		System.out.println(output);
		return output;
		
	}
}