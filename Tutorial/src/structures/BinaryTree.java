package structures;

/**
 * Binary Tree data structure implementation.
 * 
 * @author Dimitre Bogdanov
 *
 * @param <E>
 *            Type of data to me contained within the nodes of the Binary Tree.
 *            Must be Comparable
 */
public class BinaryTree<E extends Comparable<E>> {

	private class Node {
		private E data;
		private Node left;
		private Node right;

		public Node(E data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}

	private Node root;
	private int size;

	public BinaryTree() {
		root = null;
		size = 0;
	}

	public void add(E data) {
		if (root == null) {
			root = new Node(data, null, null);
		} else {
			add(root, data);
		}
		size++;
	}

	private void add(Node previous, E data) {
		// New data smaller, put it on the left
		if (data.compareTo(previous.data) < 0) {
			if (previous.left == null)
				previous.left = new Node(data, null, null);
			else
				add(previous.left, data);
		} else {
			// New data bigger or equal, put it on the right
			if (previous.right == null)
				previous.right = new Node(data, null, null);
			else
				add(previous.right, data);
		}
	}

	/**
	 * Removes the first occurence
	 * 
	 * @param data
	 *            Data contained in the Node to be removed
	 */
	public void remove(E data) {
		internalRemove(root, data);
		// size--;
	}

	private Node internalRemove(Node node, E data) {

		// Base case if empty
		if (node == null)
			return node;

		// Go through the tree
		if (data.compareTo(node.data) < 0) {
			node.left = internalRemove(node.left, data);
		} else if (data.compareTo(node.data) > 0) {
			node.right = internalRemove(node.right, data);
		} else {
			size--;
			// At this point, we have found the node to remove

			// If there is only one child, left or right
			if (node.left == null) {
				return node.right;
			} else if (node.right == null) {
				return node.left;
			}

			// If it gets to here, node has two children, both left and right,
			// replace data and delete
			node.data = low(node.right);
			node.right = internalRemove(node.right, node.data);
		}

		return node;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public E low() {
		return low(root);
	}

	public E low(Node start) {
		if (start == null)
			return null;
		Node current = start;
		while (current.left != null)
			current = current.left;
		return current.data;
	}

	public E high() {
		return high(root);
	}

	public E high(Node start) {
		if (start == null)
			return null;
		Node current = start;
		while (current.right != null)
			current = current.right;
		return current.data;
	}

	public void inorder() {
		internalInorder(root);
	}

	private void internalInorder(Node node) {
		if (node != null) {
			internalInorder(node.left);
			System.out.println(node.data.toString());
			internalInorder(node.right);
		}
	}

	public void preorder() {
		internalPreorder(root);
	}

	private void internalPreorder(Node node) {
		if (node != null) {
			System.out.println(node.data.toString());
			internalPreorder(node.left);
			internalPreorder(node.right);
		}
	}

	public void postorder() {
		internalPostorder(root);
	}

	private void internalPostorder(Node node) {
		if (node != null) {
			internalPostorder(node.left);
			internalPostorder(node.right);
			System.out.println(node.data.toString());
		}
	}

	public boolean contains(E content) {
		return find(root, content);
	}

	public boolean contains(E content, boolean iterative) {
		if (iterative)
			return iterativeFind(root, content);
		return find(root, content);
	}

	// Preorder-based algorithm
	private boolean find(Node node, E content) {
		if (node != null) {
			if (content.equals(node.data))
				return true;
			return find(node.left, content) || find(node.right, content);
		}
		return false;
	}

	private boolean iterativeFind(Node root, E content) {
		if (root != null) {
			Queue<Node> queue = new Queue<>();

			queue.enqueue(root);

			while (!queue.isEmpty()) {
				Node current = queue.dequeue();

				if (current.data.equals(content)) {
					return true;
				}

				if (current.left != null) {
					queue.enqueue(current.left);
				}

				if (current.right != null) {
					queue.enqueue(current.right);
				}
			}

			return false;
		}
		return false;
	}
}
