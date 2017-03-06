package structures;

public class BinaryTree<E> {

	private class Node {
		private E data;
		private Node left;
		private Node right;

		public Node(E data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

		public E data() {
			return data;
		}

		public Node left() {
			return left;
		}

		public Node right() {
			return right;
		}
	}

	private Node root;
	private int size;
	private Node current;

	public BinaryTree() {
		root = null;
		size = 0;
	}

	public void add(E data) {
		if (root == null) {
			root = new Node(data, null, null);
		} else {

		}
		size++;
	}
	
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return root == null;
	}
	
	public E low(){
		return null;
	}
	
	public E high(){
		return null;
	}

	public void inorder(){
		
	}
	
	public void preorder(){
		
	}
	
	public void postorder(){
		
	}
}
