package algorithms;

import java.util.LinkedList;

public class Sorting {

	private Sorting() {
	}

	/**
	 * Radix sort is a sorting algorithm which only work for numbers. Time
	 * complexity of O(n)
	 * 
	 * @param array
	 *            The array of numbers to be sorted
	 * @return Sorted array of numbers
	 */
	public static int[] radix(int[] array) {
		LinkedList<Integer>[] result = new LinkedList[10];
		// Always 10 times, therefore O(1)
		for (int i = 0; i < result.length; i++) {
			result[i] = new LinkedList<Integer>();
		}

		int max = max(array);
		// Get the number of digits. Can be done using binary conversion as well
		int digits = String.valueOf(max).length();
		int size = array.length;

		for (int i = 0; i < digits; i++) {
			for (int j = 0; j < array.length; j++) {
				int mod = (int) (Math.pow(10, i + 1));
				int divisor = (int) (Math.pow(10, i));
				int digit = (array[j] % mod) / divisor;
				result[digit].addLast(array[j]);
			}

			array = toArray(result, size);

			// Always going to be 10, therefor O(1)
			for (int m = 0; m < result.length; m++) {
				result[m] = new LinkedList<Integer>();
			}
		}

		return array;
	}

	/**
	 * Convert a LinkedList of integers to an array.
	 * 
	 * @param list
	 * @param size
	 * @return
	 */
	public static int[] toArray(LinkedList<Integer>[] list, int size) {
		int[] result = new int[size];
		int j = 0;
		// Always 10, therefore O(1)
		for (int i = 0; i < list.length; i++) {
			// Maximum n-times if all elements are on the same linkedlist,
			// therefore O(n)
			for (int n : list[i]) {
				result[j] = n;
				j++;
			}
		}
		return result;
	}

	private static int max(int[] array) {
		int max = Integer.MIN_VALUE;
		for (int i : array)
			if (max < i)
				max = i;
		return max;
	}

	public static <T extends Comparable<T>> T[] merge(T[] array) {
		T[] result = (T[]) new Object[array.length];
		return null;
	}

	public static Object[] quick(Object[] array) {
		return null;
	}

	public static Object[] bubble(Object[] array) {
		return null;
	}

	public static Object[] selection(Object[] array) {
		return null;
	}

	public static Object[] insertion(Object[] array) {
		return null;
	}

	public static Object[] heap(Object[] array) {
		return null;
	}

	public static Object[] tree(Object[] array) {
		return null;
	}

}
