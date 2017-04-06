package algorithms;

import java.util.LinkedList;
import java.util.List;

import structures.ArrayList;

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

	public static Comparable[] mergeSort(Comparable[] array) {

		if (array.length > 1) {
			Comparable[] s1 = begin(array);
			Comparable[] s2 = end(array);
			s1 = mergeSort(s1);
			s2 = mergeSort(s2);
			array = merge(array, s1, s2);
		}

		return array;
	}

	private static Comparable[] merge(Comparable[] result, Comparable[] s1, Comparable[] s2) {
		result = new Comparable[s1.length + s2.length];

		int firstIndex = 0;
		int secondIndex = 0;
		int resultIndex = 0;
		while (firstIndex != s1.length && secondIndex != s2.length) {
			if (s1[firstIndex].compareTo(s2[secondIndex]) < 0) {
				result[resultIndex++] = s1[firstIndex++];
			} else {
				result[resultIndex++] = s2[secondIndex++];
			}
		}
		while (firstIndex != s1.length) {
			result[resultIndex++] = s1[firstIndex++];
		}
		while (secondIndex != s2.length) {
			result[resultIndex++] = s2[secondIndex++];
		}

		return result;
	}

	private static Comparable[] begin(Comparable[] array) {
		Comparable[] result = new Comparable[array.length / 2];
		for (int i = 0; i < result.length; i++)
			result[i] = array[i];
		return result;
	}

	private static Comparable[] end(Comparable[] array) {
		int length = (array.length % 2 == 0) ? array.length / 2 : array.length / 2 + 1;
		Comparable[] result = new Comparable[length];
		for (int i = 0; i < length; i++)
			result[i] = array[array.length / 2 + i];
		return result;
	}

	// Can do another version where you input a starting pivot point but the
	// algorithm is pretty much the same
	public static Comparable[] quick(Comparable[] array) {

		// Arbitrarily we are taking the last element as the pivot point every
		// time
		if (array.length <= 1)
			return array;

		Comparable pivot = array[array.length - 1];

		List<Comparable> lower = new ArrayList<Comparable>();
		List<Comparable> higher = new ArrayList<Comparable>();
		int equal = 0;

		for (int i = 0; i < array.length - 1; i++) {
			Comparable current = array[i];

			if (current.compareTo(pivot) < 0) {
				// Current element is smaller
				lower.add(current);
			} else if (current.compareTo(pivot) > 0) {
				// Current element is bigger
				higher.add(current);
			} else {
				// Current element is equal to
				equal++;
			}
		}

		array = union(quick(toArray(lower)), pivot, equal, quick(toArray(higher)));

		return array;
	}

	private static Comparable[] toArray(List<Comparable> list) {
		Comparable[] result = new Comparable[list.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = list.get(i);
		}
		return result;
	}

	private static Comparable[] union(Object[] lower, Comparable pivot, int pivotCount, Object[] higher) {
		int size = lower.length + higher.length;
		size += pivotCount + 1;

		Comparable[] result = new Comparable[size];

		int n = 0;
		if (lower.length > 0) {
			for (int i = 0; i < lower.length; i++, n++) {
				result[n] = (Comparable) lower[i];
			}
		}
		for (int i = 0; i <= pivotCount; i++, n++) {
			result[n] = pivot;
		}

		if (higher.length > 0) {
			for (int i = 0; i < higher.length; i++, n++) {
				result[n] = (Comparable) higher[i];
			}
		}

		return result;
	}

	public static Comparable[] bubble(Comparable[] array) {
		boolean swap;
		do {
			swap = false;
			for (int i = 1; i < array.length; i++) {
				// If the right element is smaller than the left element, swap
				if (array[i].compareTo(array[i - 1]) < 0) {
					Comparable temp = array[i];
					array[i] = array[i - 1];
					array[i - 1] = temp;
					swap = true;
				}
			}
		} while (swap);
		return array;
	}

	public static Comparable[] selection(Comparable[] array) {

		for (int i = 0; i < array.length - 1; i++) {
			int swap = i;
			Comparable min = array[i];
			int j = i + 1;
			for (; j < array.length; j++) {
				if (array[j].compareTo(min) < 0) {
					min = array[j];
					swap = j;
				}
			}
			if (i != j) {
				Comparable temp = array[i];
				array[i] = min;
				array[swap] = temp;
			}
		}

		return array;
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
