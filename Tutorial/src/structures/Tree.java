package structures;

import java.util.Iterator;
import java.util.List;

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
	/*
	 * private class TreeNode { private E data; private TreeNode parent; private
	 * List<TreeNode> children;
	 * 
	 * public TreeNode(E data, TreeNode parent, List<TreeNode> children) {
	 * this.data = data; this.parent = parent; this.children = children; }
	 * 
	 * public E getData() { return data; }
	 * 
	 * // Same functionality as getData but just having both for naming purpose
	 * public E element() { return data; }
	 * 
	 * public TreeNode getParent() { return parent; }
	 * 
	 * public List<TreeNode> getChildren() { return children; } }
	 */

	// private Tree<E> root;
	// private int size;
	private E data;
	private List<Tree<E>> children;
	private Tree<E> parent;

	public Tree() {
		parent = null;
		data = null;
		children = new ArrayList<Tree<E>>();
	}

	public Tree(E data) {
		parent = null;
		this.data = data;
		children = new ArrayList<Tree<E>>();
	}

	public Tree(E data, Tree<E> parent) {
		this.parent = parent;
		this.data = data;
		children = new ArrayList<Tree<E>>();
	}

	public List<Tree<E>> getChildren() {
		return children;
	}

	public void addChild(E data) {
		children.add(new Tree<E>(data));
	}

	public void addChildren(List<E> children) {
		for (E element : children)
			addChild(element);
	}

	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public void setParent(Tree<E> parent) {
		this.parent = parent;
		if (this.parent != null)
			this.parent.addChild(this.data);
	}

	public boolean isEmpty() {
		return parent == null && children.size() == 0 && data == null;
	}

	public boolean isLeaf() {
		return children.size() == 0;
	}

	/*
	 * public int size() { return size; }
	 * 
	 * public boolean isEmpty() { return size == 0; }
	 */

	/*
	 * public Iterator<E> iterator() { return null; }
	 * 
	 * public Iterable<E> positions() { return null; } public TreeNode<E> root()
	 * { return root; }
	 * 
	 * public TreeNode<E> parent(TreeNode<E> node) { return node.getParent(); }
	 * 
	 * public Iterable<E> children(TreeNode<E> node) { return null; }
	 * 
	 * public boolean isInternal(TreeNode<E> node) { return false; }
	 * 
	 * public boolean isExternal(TreeNode<E> node) { return false; }
	 * 
	 * public boolean isRoot(TreeNode<E> node) { return root.equals(node); }
	 * 
	 * public E replace() { return null; }
	 * 
	 * public void addChild(TreeNode<E> node, E element){
	 * 
	 * }
	 */
}
