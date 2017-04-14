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

	private int parentIndex(int index) {
		return index / 2;
	}

	private E right(int index) {
		return data.get((2 * index) + 1);
	}

	private int rightIndex(int index) {
		return (2 * index) + 1;
	}

	private int leftIndex(int index) {
		return (2 * index);
	}

	private E left(int index) {
		return data.get(2 * index);
	}

	public void add(E element) {
		int index = size() + 1;
		for (; index > 1 && element.compareTo(data.get(index / 2)) < 0; index /= 2) {
			data.set(index, data.get(index / 2));
		}
		data.add(index, element);
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

	public E last() {
		return data.get(size());
	}

	public E removeMin() {
		E element = min();

		// Set the root to the last element
		data.set(1, last());
		data.remove(size());

		down(1);

		return element;
	}

	private void down(int start) {

		E right = right(start);
		E left = left(start);
		E selected;
		int selectedIndex;

		if (right == null && left == null) {
			return;
		} else if (right == null) {
			selected = left;
			selectedIndex = leftIndex(start);
		} else {
			if (left.compareTo(right) <= 0) {
				selected = left;
				selectedIndex = leftIndex(start);
			} else {
				selected = right;
				selectedIndex = rightIndex(start);
			}
		}

		if (data.get(start).compareTo(selected) > 0) {
			swap(start, selectedIndex);
			down(selectedIndex);
		}

	}

	private void swap(int a, int b) {
		E temp = data.get(a);
		data.set(a, data.get(b));
		data.set(b, temp);
	}

	@Override
	public String toString() {
		String str = "Heap [ ";

		for (int i = 1; i < data.size(); i++) {
			str += data.get(i);
			str += ",";
		}

		str = str.substring(0, str.length() - 1);

		str += "]";
		return str;
	}

}
