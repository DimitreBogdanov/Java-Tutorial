package structures;

public class PriorityQueue<K implements Comparable, V> {

	private class Node {

		private K key;
		private V value;

		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public K getKey() {
			return key;
		}

		public V getValue() {
			return value;
		}
	}

	public PriorityQueue() {

	}

	public void insert(K key, V value) {
		Node n = new Node(key, value);
	}
	
	public V remove(){
		return null;
	}
	
	public V min(){
		return null;
	}
	
	public int size(){
		return -1;
	}
	
	public boolean isEmpty(){
		return size() == 0;
	}

}
