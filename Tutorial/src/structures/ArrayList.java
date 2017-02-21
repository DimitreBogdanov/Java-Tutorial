package structures;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayList<E> implements List<E> {

	private Object[] data;
	private static final int CAPACITY = 10;
	private int index = 0;// this is also the size
	private int capacity = 0;

	public ArrayList() {
		data = new Object[CAPACITY];
	}

	public ArrayList(int capacity) {
		if (capacity >= 0)
			data = new Object[capacity];
		else
			throw new IllegalArgumentException("Capacity must be bigger than or equal to 0");
	}

	private void ensureCapacity() {
		if (index + 1 < capacity)
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
		// might need to add at the end here;
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(int arg0, Collection<? extends E> arg1) {
		// TODO Auto-generated method stub
		return false;
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E get(int arg0) {
		return (E)data[arg0];
	}

	@Override
	public int indexOf(Object arg0) {
		for(int i = 0;i <= index;i++)
			if(data[i].equals(arg0))
				return i;
		return -1;
	}

	@Override
	public boolean isEmpty() {
		return index == 0;
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int lastIndexOf(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public E remove(int arg0) {
		// TODO Auto-generated method stub
		return null;
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
		return (E)temp;
	}

	@Override
	public int size() {
		return index;
	}

	@Override
	public List<E> subList(int arg0, int arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		return trim();
	}
	
	private Object[] trim(){
		Object[] temp = new Object[index];
		for(int i = 0; i < index; i++)
			temp[i] = data[i];
		return temp;
	}

	@Override
	public <T> T[] toArray(T[] arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
