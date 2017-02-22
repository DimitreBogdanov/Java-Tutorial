package structures;

/**
 * LinkedList data structure implementation
 * @author Dimitre Bogdanov
 *
 * @param <E> Type of data to me contained within the nodes of the LinkedList
 */
public class LinkedList<E> {
	
	private class Node<T extends E>{
		private T data;
		private Node<T> next;
		
		public Node(){
			data = null;
			next = null;
		}
		public Node(T data, Node<T> next){
			this.data = data;
			this.next = next;
		}
	}
	
	private Node<E> head;
	
	public LinkedList(){
		head = null;
	}
	
	public LinkedList(Node<E> head){
		this.head = head;
	}
	
	public void addFirst(E element){
		
	}
	
	public void addLast(E element){
		
	}
	
	public void addAfter(E after, E element){
		
	}
	
	public void addBefore(E before, E element){
		
	}
	
	public void remove(E element){
		
	}

}
