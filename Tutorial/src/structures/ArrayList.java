package structures;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayList<E> implements List<E> {

	private Object[] data;
	private static final int CAPACITY = 10;
	private int index;// this is also the size => represents the index at
						// which the next element is to be inserted
	private int capacity;

	public ArrayList() {
		data = new Object[CAPACITY];
		index = 0;
		capacity = CAPACITY;
	}

	public ArrayList(int capacity) {
		if (capacity >= 0) {
			data = new Object[capacity];
			index = 0;
			this.capacity = capacity;
		} else
			throw new IllegalArgumentException("Capacity must be bigger than or equal to 0");
	}

	private void ensureCapacity() {
		if (index + 1 > capacity)
			transfer();
	}

	private void transfer() {
		int newCapacity = (2 * capacity) + 1;
		Object[] temp = new Object[newCapacity];
		for (int i = 0; i < capacity; i++) {
			temp[i] = data[i];
		}
		data = temp;
	}

	private void pushElements(int start) {
		ensureCapacity();
		Object temp = null;
		Object insert = null;
		for (int i = start; i <= index; i++) {
			temp = data[i];
			data[i] = insert;
			insert = temp;
		}
		index++;
	}

	@Override
	public boolean add(E arg0) {
		ensureCapacity();
		data[index++] = arg0;
		return true;
	}

	@Override
	public void add(int arg0, E arg1) {
		pushElements(arg0);
		data[arg0] = arg1;
	}

	@Override
	public boolean addAll(Collection<? extends E> arg0) {
		Iterator<? extends E> iterator = arg0.iterator();
		while (iterator.hasNext()) {
			add(iterator.next());
		}
		return true;
	}

	@Override
	public boolean addAll(int arg0, Collection<? extends E> arg1) {
		Iterator<? extends E> iterator = arg1.iterator();
		while (iterator.hasNext()) {
			add(arg0++, iterator.next());
		}
		return true;
	}

	@Override
	public void clear() {
		data = new Object[capacity];
	}

	@Override
	public boolean contains(Object arg0) {
		return indexOf(arg0) != -1;
	}

	@Override
	public boolean containsAll(Collection<?> arg0) {
		if (arg0 == null)
			return false;
		if (arg0.size() > index || arg0.size() == 0)
			return false;

		Iterator<?> iterator = arg0.iterator();
		while (iterator.hasNext())
			if (indexOf(iterator.next()) == -1)
				return false;

		return true;
	}

	@Override
	public E get(int arg0) {
		return (E) data[arg0];
	}

	@Override
	public int indexOf(Object arg0) {
		if (arg0 == null)
			return -1;
		for (int i = 0; i <= index; i++)
			if (arg0.equals(data[i]))
				return i;
		return -1;
	}

	@Override
	public boolean isEmpty() {
		return index == 0;
	}

	@Override
	public Iterator<E> iterator() {
		return new Iter<E>();
	}

	@Override
	public int lastIndexOf(Object arg0) {
		for (int i = index - 1; i >= 0; i--)
			if (data[i].equals(arg0))
				return i;
		return -1;
	}

	@Override
	public ListIterator<E> listIterator() {
		return new ListIter<E>();
	}

	@Override
	public ListIterator<E> listIterator(int arg0) {
		return new ListIter<E>(arg0);
	}

	@Override
	public boolean remove(Object arg0) {
		boolean result = false;

		for (int i = 0; i < index; i++) {
			if (result) {
				data[i] = data[i + 1];
				continue;
			}
			if (data[i].equals(arg0)) {
				result = true;
				data[i] = data[i + 1];
				index--;
			}
		}

		return result;
	}

	@Override
	public E remove(int arg0) {
		E temp = (E) data[arg0];
		for (int i = arg0; i < index; i++) {
			data[i] = data[i + 1];
		}
		index--;
		return temp;
	}

	@Override
	public boolean removeAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E set(int arg0, E arg1) {
		Object temp = data[arg0];
		data[arg0] = arg1;
		return (E) temp;
	}

	@Override
	public int size() {
		return index;
	}

	@Override
	public List<E> subList(int arg0, int arg1) {
		if(arg0 < 0 || arg1 >= capacity)
			throw new IllegalArgumentException("Invalid sublist range");
		
		List<E> list = new ArrayList<E>();
		for (int i = arg0; i < arg1; i++) {
			list.add((E)data[i]);
		}
		return list;
	}

	@Override
	public Object[] toArray() {
		return trim();
	}

	// trims the end
	private Object[] trim() {
		Object[] temp = new Object[index];
		for (int i = 0; i < index; i++)
			temp[i] = data[i];
		return temp;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	private class Iter<E> implements Iterator<E> {

		private Object[] elements;
		private int iteratorIndex;
		private int size;

		public Iter() {
			elements = data;
			iteratorIndex = 0;
			size = index;
		}

		@Override
		public boolean hasNext() {
			return iteratorIndex < size;
		}

		@Override
		public E next() {
			if (hasNext())
				return (E) elements[iteratorIndex++];
			return null;
		}

	}

	private class ListIter<E> implements ListIterator<E> {

		private Object[] elements;
		private int iteratorIndex;
		private int min;
		private int size;

		public ListIter() {
			elements = data;
			iteratorIndex = 0;
			min = 0;
			size = index;
		}

		public ListIter(int arg0) {
			elements = data;
			iteratorIndex = arg0;
			min = arg0;
			size = index;
		}

		@Override
		public boolean hasNext() {
			return iteratorIndex < size;
		}

		@Override
		public E next() {
			if (hasNext())
				return (E) elements[iteratorIndex++];
			return null;
		}

		@Override
		public boolean hasPrevious() {
			return (iteratorIndex - 1) > min;
		}

		@Override
		public E previous() {
			if (hasPrevious())
				return (E) elements[iteratorIndex--];
			return null;
		}

		// is next and previous relative to the iterator or to the whole data
		// set?
		@Override
		public int nextIndex() {
			return iteratorIndex + 1;
		}

		@Override
		public int previousIndex() {
			return iteratorIndex - 1;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub

		}

		@Override
		public void set(E paramE) {
			elements[iteratorIndex] = paramE;
		}

		@Override
		public void add(E paramE) {
			// ensure capacity first here
		}

	}

}
