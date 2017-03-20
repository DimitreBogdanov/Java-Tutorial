package structures;

import java.util.Iterator;

/**
 * Tree data structure implementation. Most of these operations can be directly
 * applied to the node and do not need to be encapsulated in a Tree class,
 * however we are implementing it that way to demonstrate the implementation of
 * the Tree ADT.
 * 
 * @author Dimitre Bogdanov
 *
 * @param <E>
 */
public class Tree<E> {

	private TreeNode<E> root;
	private int size;

	public Tree() {
		root = null;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
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

	public E replace() {
		return null;
	}
	
	public void addChild(TreeNode<E> node, E element){
		
	}

}
