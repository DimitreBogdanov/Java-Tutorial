package algorithms;

public class Search {

	private Search() {
	}

	/**
	 * Binary search on array of comparable elements. Only works on sorted
	 * array.
	 * 
	 * @param array
	 *            Sorted array of comparable elements to search
	 * @param find
	 *            Comparable element to be found
	 * @return Index of the object, -1 if it is not present
	 */
	public static <T extends Comparable<T>> int binary(T[] array, T find) {
		int low = 0;
		int high = array.length - 1;

		while (high >= low) {
			int mid = (low + high) / 2;

			// Found the element since they are equal
			if (array[mid].compareTo(find) == 0) {
				return mid;
			}
			// The element we are looking for is smaller than the middle, adjust
			// the high to be the middle - 1 in order to start looking at the
			// bottom or higher half of the collection
			if (array[mid].compareTo(find) > 0) {
				high = mid - 1;
			}
			// The element we are looking for is bigger than the middle, adjust
			// the low to be the middle + 1 in order to start looking at the
			// upper or smaller half of the collection
			if (array[mid].compareTo(find) < 0) {
				low = mid + 1;
			}
		}

		return -1;
	}

	public static int linear(Object[] array, Object find) {
		for (int i = 0; i < array.length; i++)
			if (array[i].equals(find))
				return i;
		return -1;
	}
}
