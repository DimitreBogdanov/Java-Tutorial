package structures;

public class DoublyLinkedList<E> {

	private class Node<T extends E> {
		private T data;
		private Node<T> next;
		private Node<T> previous;

		public Node(T data, Node<T> next, Node<T> previous) {
			this.data = data;
			this.next = next;
			this.previous = previous;
		}

		public T getData() {
			return data;
		}
	}

	private Node<E> head;
	private Node<E> tail;
	private int size;

	//Review this => head = tail when you have a single element
	public DoublyLinkedList() {
		head = null;
		tail = null;
		size = 0;
	}

	public void addFirst(E element) {
		head = new Node<E>(element, head, null);
		size++;
	}

	public void addLast(E element) {
		tail = new Node<E>(element, null, tail);
		size++;
	}

	// Add after only if you find that element
	public void addAfter(E after, E element) {
		Node<E> current = head;
		while (current != null && !current.getData().equals(after)) {
			current = current.next;
		}
		if (current != null) {
			current.next = new Node<E>(element, current.next, current);
			size++;
		}
	}

	public void addBefore(E before, E element) {
		Node<E> current = head;
		while (current != null && !current.getData().equals(before)) {
			current = current.next;
		}
		if (current != null) {
			Node<E> newNode = new Node<E>(element, current, current.previous);
			current.previous.next = newNode;
			current.previous = newNode;
			size++;
		}
	}

	public void remove(E element) {
		Node<E> current = head;
		while (current != null && !current.getData().equals(element)) {
			current = current.next;
		}
		if (current != null) {
			current.previous.next = current.next;
			size--;
		}
		size--;
	}

	public void removeLast() {

		size--;
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
