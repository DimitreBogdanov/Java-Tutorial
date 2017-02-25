package structures;

/**
 * Double LinkedList structure implementation
 * 
 * @author Dimitre Bogdanov
 *
 * @param <E>
 *            Type of data to me contained within the nodes of the
 *            DoublyLinkedList
 */
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
	private int size;

	public DoublyLinkedList() {
		head = null;
		size = 0;
	}

	public void addFirst(E element) {
		if (head == null) {
			head = new Node<E>(element, null, null);
		} else {
			head = new Node<E>(element, head, null);
		}
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
			current.next = new Node<E>(element, null, current);
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
			if (current.previous == null) {
				addFirst(element);
			} else {
				Node<E> newNode = new Node<E>(element, current, current.previous);
				current.previous.next = newNode;
				current.previous = newNode;
				size++;
			}
		}
	}

	public void remove(E element) {
		Node<E> current = head;
		while (current != null && !current.getData().equals(element)) {
			current = current.next;
		}
		if (current != null) {
			if (current.previous == null) {
				head = current.next;
			} else {
				current.previous.next = current.next;
			}
			size--;
		}
	}

	public void removeLast() {
		Node<E> current = head;
		if (current == null)
			return;
		while (current.next != null) {
			current = current.next;
		}
		if (current != null) {
			current.previous.next = null;
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
