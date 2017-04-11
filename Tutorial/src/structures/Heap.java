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
		data.add(null);

	}

}
