package structures;

import java.util.Iterator;

public class Tree<E> {

	private TreeNode<E> root;

	public Tree() {
		root = null;
	}

	public Tree(TreeNode<E> root) {
		this.root = root;
	}

	public int size() {
		return 0;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public Iterator<E> iterator() {
		return null;
	}

	public Iterable<E> positions() {
		return null;
	}

	public TreeNode<E> root() {
		return root;
	}

	public TreeNode<E> parent(TreeNode<E> node) {
		return node.getParent();
	}

	public Iterable<E> children(TreeNode<E> node) {
		return null;
	}

	public boolean isInternal(TreeNode<E> node) {
		return false;
	}

	public boolean isExternal(TreeNode<E> node) {
		return false;
	}

	public boolean isRoot(TreeNode<E> node) {
		return root.equals(node);
	}
	
	public E replace(TreeNode<E> node, E element){
		return null;
	}

}
