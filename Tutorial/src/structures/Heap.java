package structures;

import java.util.List;

public class Heap<E extends Comparable<E>> {

	private List<E> data;

	// Left child 2n
	// Right child 2n + 1
	// Parent is n/2

	public Heap() {
		data = new ArrayList<E>();
		// Add the empty space as the first index for the sake of implementation
		// in order to make the first element at 'index' 1
		data.add(null);
	}

	public Heap(E root) {
		data = new ArrayList<E>();
		// Add the empty space as the first index for the sake of implementation
		// in order to make the first element at 'index' 1
		data.add(null);
		data.add(root);
	}

	private E parent(int index) {
		return data.get(index / 2);
	}

	private E right(int index) {
		return data.get((2 * index) + 1);
	}

	private E left(int index) {
		return data.get(2 * index);
	}

	public void add(E element) {
		int index = size() + 1;
		for (; index > 1 && element.compareTo(data.get(index / 2)) < 0; index /= 2) {
			data.set(index, data.get(index / 2));
		}
		data.set(index, element);
	}

	public int size() {
		return data.size() - 1;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public E min() {
		return data.get(1);
	}

	public E removeMin() {
		E element = data.get(0);

		// TODO upheap

		return element;
	}

}
