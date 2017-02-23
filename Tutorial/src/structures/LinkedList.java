package structures;

/**
 * LinkedList data structure implementation
 * 
 * @author Dimitre Bogdanov
 *
 * @param <E>
 *            Type of data to me contained within the nodes of the LinkedList
 */
public class LinkedList<E> {

	private class Node<T extends E> {
		private T data;
		private Node<T> next;

		public Node(T data, Node<T> next) {
			this.data = data;
			this.next = next;
		}

		public T getData() {
			return data;
		}
	}

	private Node<E> head;
	private int size;

	public LinkedList() {
		head = null;
		size = 0;
	}

	public void addFirst(E element) {
		head = new Node<E>(element, head);
		size++;
	}

	public void addLast(E element) {
		if (head == null) {
			addFirst(element);
		} else {
			Node<E> current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = new Node<E>(element, null);
			size++;
		}
	}

	// Add after only if you find that element
	public void addAfter(E after, E element) {
		Node<E> current = head;
		while (current != null && !current.getData().equals(after)) {
			current = current.next;
		}
		if (current != null) {
			current.next = new Node<E>(element, current.next);
			size++;
		}
	}

	// Add before only if you find that element
	public void addBefore(E before, E element) {
		Node<E> current = head;
		Node<E> prev = null;
		while (current != null && !current.getData().equals(before)) {
			prev = current;
			current = current.next;
		}
		if (current != null) {
			prev.next = new Node<E>(element, current);
			size++;
		}
	}

	public void remove(E element) {
		Node<E> current = head;
		Node<E> prev = null;
		while (current != null && !current.getData().equals(element)) {
			prev = current;
			current = current.next;
		}
		if (current != null) {
			prev.next = current.next;
			size--;
		}
	}

	public E get(int index) {
		Node<E> current = head;
		for (int i = 0; i < index && current != null; i++) {
			current = current.next;
		}
		if (current != null)
			return current.getData();
		return null;
	}

	public int size() {
		return size;
	}

}
