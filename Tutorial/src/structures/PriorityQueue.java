package structures;

public class PriorityQueue<T extends Comparable<T>> {

	/*
	 * private class Node implements Comparable<K> {
	 * 
	 * private K key; private V value;
	 * 
	 * public Node(K key, V value) { this.key = key; this.value = value; }
	 * 
	 * public K getKey() { return key; }
	 * 
	 * public V getValue() { return value; }
	 * 
	 * @Override public int compareTo(K arg0) { return key.compareTo(arg0); } }
	 */

	// There are various different ways of implementing a PQ, some of which will
	// include internal nodes with K/V pairs, some with primitive data types
	// such as int, some will take a Comparator as argument in order to give the
	// user more options in terms of the order, this is one of many ways to go
	// about it

	// Going to use a heap and have the priority queue sorted in ascending order
	// arbitrarily.
	private Heap<T> data;

	public PriorityQueue() {
		data = new Heap<T>();
	}

	public void insert(T element) {
		data.add(element);
	}

	public T remove() {
		return data.removeMin();
	}

	// Same as having something such as public T first()
	// since we are doing it purely on ascending order based on Comparable
	public T min() {
		return data.min();
	}

	public int size() {
		return data.size();
	}

	public boolean isEmpty() {
		return size() == 0;
	}

}
