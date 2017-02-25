package structures;

import java.util.NoSuchElementException;

public class Stack<E>{
	
	private Object[] data;
	private final int CAPACITY = 10;
	private int size;//also represents the next index to store at
	private int capacity;
	
	public Stack(){
		data = new Object[CAPACITY];
		capacity = CAPACITY;
		size = 0;
	}
	
	//add validation for capacity
	public Stack(int capacity){
		if(capacity < 0)
			throw new IllegalArgumentException("Capacity cannot be below zeor");
		data = new Object[capacity];
		this.capacity = capacity;
		size = 0;
	}
	
	private void ensureCapacity() {
		if (size + 1 > capacity)
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
	
	public void push(E element){
		ensureCapacity();
		data[size++] = element;
	}
	
	public E pop(){
		if(isEmpty())
			throw new NoSuchElementException("Cannot pop from an empty stack");
		E element = (E)data[size-1];
		data[--size] = null;
		return element;
	}
	
	public E peek(){
		if(isEmpty())
			throw new NoSuchElementException("Cannot peek from an empty stack");
		return (E)data[size-1];
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}

}
