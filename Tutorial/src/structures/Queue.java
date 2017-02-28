package structures;

/**
 * Array-based implementation of a queue. Can be done using other structures
 * such as a linkedlist.
 * 
 * @author Dimitre Bogdanov
 *
 * @param <E>
 */
public class Queue<E> {

	private Object[] data;
	private final int CAPACITY = 10;
	private int size;
	private int capacity;

	private int front;// next index to dequeue at
	private int rear;// next index to enqueue at

	public Queue() {
		data = new Object[CAPACITY];
		capacity = CAPACITY;
		size = 0;
	}

	public Queue(int capacity) {
		if (capacity < 0)
			throw new IllegalArgumentException("Capacity cannot be below zeor");
		data = new Object[capacity];
		this.capacity = capacity;
		size = 0;
	}

	private void ensureCapacity() {
		if (size + 1 == capacity)
			transfer();
	}

	private void transfer() {
		int newCapacity = (2 * capacity) + 1;
		Object[] temp = new Object[newCapacity];
		int i = front;
		for (int j = 0; i != rear; i = (i + 1) % capacity, j++) {
			temp[j] = data[i];
		}
		front = 0;
		rear = i;
		data = temp;
		capacity = newCapacity;
	}

	public boolean isEmpty() {
		return size == 0;
		// can also do return front == rear
		// in the array-based implementation when keeping an open space for the
		// rear, if front == rear then it is empty
	}

	public void enqueue(E element) {
		ensureCapacity();
		data[rear] = element;
		rear = (rear + 1) % capacity;
		size++;
	}

	public E front() {
		return (E) data[front];
	}

	public E dequeue() {
		E element = (E) data[front];
		// this is optional, you'll just overwrite it later
		data[front] = null;
		front = (front + 1) % capacity;
		size--;
		return element;
	}

	// check formula to calculate size based on front and rear mod capacity
	public int size() {
		return size;
	}

}
