package structures;

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
		if (data.compareTo(previous.data) == -1) {
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

	public E remove(E data) {
		return null;// TODO
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public E low() {
		if (root == null)
			return null;
		Node current = root;
		while (current.left != null)
			current = current.left;
		return current.data;
	}

	public E high() {
		if (root == null)
			return null;
		Node current = root;
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

	private boolean find(Node node, E content) {
		if (node != null) {
			// to complete
		}
		return false;
	}
}
