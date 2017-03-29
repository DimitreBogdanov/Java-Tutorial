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
		int[] finalArray = new int[array.length];

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

		return finalArray;
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
		if (array == null)
			throw new IllegalArgumentException("List is null");

		int size = array.length;

		T[] tempList = (T[]) new Object[size];

		// the size of the sublists, constantly increasing by 2
		int subListSize;

		// the start index for the left sub array to compare
		int leftStartIndex = 0;

		// the end index for the left sub array to compare
		int leftEndIndex = 0;

		// the start index for the right sub array to compare
		int rightStartIndex = 0;

		// the end index for the right sub array to compare
		int rightEndIndex = 0;

		// the position within the temp array.
		int tempPosition = 0;

		// the number of sublists to compare, starting at the size of the list.
		int numOfSubLists = size;

		int startLeftPositionForPass = 0;

		for (subListSize = 1; subListSize < size; subListSize *= 2) {

			for (int pass = 0; pass < (numOfSubLists / 2); pass++) {

				leftStartIndex = startLeftPositionForPass;
				rightStartIndex = startLeftPositionForPass + subListSize;
				leftEndIndex = startLeftPositionForPass + subListSize;
				rightEndIndex = Math.min(startLeftPositionForPass + (2 * subListSize), size);

				if (array[leftEndIndex].compareTo(array[rightStartIndex]) <= 0) {

					while (leftStartIndex < leftEndIndex && (rightStartIndex < rightEndIndex)) {
						if (array[leftStartIndex].compareTo(array[rightStartIndex]) <= 0) {
							tempList[tempPosition] = array[leftStartIndex];
							tempPosition++;
							leftStartIndex++;
						} else {
							tempList[tempPosition] = array[rightStartIndex];
							tempPosition++;
							rightStartIndex++;
						}

					}
				}

				// Transfer remaining values to tempList while there's still
				// values to transfer within the first subList
				while (leftStartIndex < leftEndIndex) {
					tempList[tempPosition] = array[leftStartIndex];
					tempPosition++;
					leftStartIndex++;
				}

				// Transfer remaining values to tempList while there's still
				// values to transfer within the second subList
				while (rightStartIndex < rightEndIndex) {
					tempList[tempPosition] = array[rightStartIndex];
					tempPosition++;
					rightStartIndex++;
				}

			} // end second for loop.

			for (int i = 0; i < tempPosition; i++) {
				array[i] = tempList[i];
			}

			// divide numOfSubLists by 2 and add remainder if necessary
			numOfSubLists = (numOfSubLists / 2) + (numOfSubLists % 2);

			// reset tempPosition
			tempPosition = 0;

		}

		return tempList;
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
