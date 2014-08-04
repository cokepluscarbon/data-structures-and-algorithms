package io.cokepluscarbon.collection;

public class BinarySearchTree<E extends Comparable<E>> {
	private BinaryNode<E> root;

	public BinarySearchTree() {
		root = null;
	}

	public void makeEmpty() {
		root = null;
	}

	public boolean isEmpty() {
		return root == null;
	}

	public boolean contains(E element) {
		return contains(element, root);
	}

	public E findMin() {
		if (isEmpty()) {
			throw new NullPointerException();
		}
		return findMin(root).element;
	}

	public E findMax() {
		if (isEmpty()) {
			throw new NullPointerException();
		}
		return findMax(root).element;
	}

	public void insert(E element) {
		root = insert(element, root);
	}

	public void remove(E element) {

	}

	public void printTree() {

	}

	private boolean contains(E element, BinaryNode<E> binaryNode) {
		if (binaryNode == null) {
			return false;
		}

		int rs = element.compareTo(binaryNode.element);
		if (rs == 0) {
			return true;
		} else if (rs < 0) {
			return contains(element, binaryNode.left);
		} else {
			return contains(element, binaryNode.right);
		}
	}

	public BinaryNode<E> findMin(BinaryNode<E> binaryNode) {
		if (binaryNode.left == null) {
			return binaryNode;
		}
		return findMin(binaryNode);
	}

	public BinaryNode<E> findMax(BinaryNode<E> binaryNode) {
		if (binaryNode.right == null) {
			return binaryNode;
		}
		return findMax(binaryNode.right);
	}

	private BinaryNode<E> insert(E element, BinaryNode<E> binaryNode) {
		if (binaryNode == null) {
			binaryNode = new BinaryNode<E>(element);
		}
		int rs = element.compareTo(binaryNode.element);
		if (rs < 0) {
			binaryNode.left = insert(element, binaryNode.left);
		} else if (rs > 0) {
			binaryNode.right = insert(element, binaryNode.right);
		}
		return binaryNode;
	}

	private static class BinaryNode<E> {
		E element;
		BinaryNode<E> left;
		BinaryNode<E> right;

		public BinaryNode(E element) {
			this(null, element, null);
		}

		public BinaryNode(BinaryNode<E> left, E element, BinaryNode<E> right) {
			this.left = left;
			this.element = element;
			this.right = right;
		}
	}

}
