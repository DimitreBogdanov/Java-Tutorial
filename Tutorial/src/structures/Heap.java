package structures;

import java.util.List;

public class Heap<E extends Comparable<E>> {

	// Would usually be done using an array but using a list here so that we
	// don't have to worry about expanding or trimming the array since it is
	// part of the list ADT
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
		if (((2 * index) + 1) > size())
			return null;
		return data.get((2 * index) + 1);
	}

	private int rightIndex(int index) {
		return (2 * index) + 1;
	}

	private int leftIndex(int index) {
		return (2 * index);
	}

	private E left(int index) {
		if ((2 * index) > size())
			return null;
		return data.get(2 * index);
	}

	public void add(E element) {
		data.add(element);
		up(size());
	}

	private void up(int start) {
		if (start == 1)
			return;
		// If the parent is bigger than the current element, swap and continue
		// recursively
		if (data.get(parentIndex(start)).compareTo(data.get(start)) > 0) {
			swap(start, parentIndex(start));
			up(parentIndex(start));
		}
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

		// If it is a leaf, this is as far as it goes, return
		if (right == null && left == null) {
			return;
		} else if (right == null) {
			// If there is no right node, select the left
			selected = left;
			selectedIndex = leftIndex(start);
		} else {
			// If there are both left and right nodes, select the smallest side
			if (left.compareTo(right) <= 0) {
				selected = left;
				selectedIndex = leftIndex(start);
			} else {
				selected = right;
				selectedIndex = rightIndex(start);
			}
		}

		// Swap selected side and continue recursively
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
