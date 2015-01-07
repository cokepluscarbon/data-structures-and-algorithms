package io.cokepluscarbon.collection;

import java.util.Stack;

/**
 * Comparator与Comparable && Iterator与Iterable 叶节点采用null节点，可以去掉很多不必要的判断
 * 
 * @author cokepluscarbon
 *
 */
public class BinarySearchTree<E extends Comparable<? super E>> {
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
			throw new UnderflowException();
		}

		return findMin(root).element;
	}

	public E findMax() {
		if (isEmpty()) {
			throw new UnderflowException();
		}

		return findMax(root).element;
	}

	public void insert(E element) {
		if (isEmpty()) {
			root = new BinaryNode<E>(element);
		} else {
			insert(element, root);
		}

	}

	public void remove(E element) {
		root = remove(element, root);
	}

	/******************* 辅助方法 ***********************/
	private boolean contains(E element, BinaryNode<E> binaryNode) {
		if (binaryNode == null) {
			return false;
		}

		int result = element.compareTo(binaryNode.element);
		if (result < 0) {
			return contains(element, binaryNode.leftChild);
		} else if (result > 0) {
			return contains(element, binaryNode.rightChild);
		} else {
			return true;
		}
	}

	private BinaryNode<E> findMin(BinaryNode<E> binaryNode) {
		if (binaryNode.leftChild != null) {
			return findMin(binaryNode.leftChild);
		}

		return binaryNode;

	}

	private BinaryNode<E> findMax(BinaryNode<E> binaryNode) {
		if (binaryNode.rightChild != null) {
			return findMax(binaryNode.rightChild);
		}

		return binaryNode;
	}

	public void insert(E element, BinaryNode<E> binaryNode) {
		int result = element.compareTo(binaryNode.element);
		if (result < 0) {
			if (binaryNode.leftChild != null) {
				insert(element, binaryNode.leftChild);
			} else {
				binaryNode.leftChild = new BinaryNode<E>(element);
			}
		} else if (result > 0) {
			if (binaryNode.rightChild != null) {
				insert(element, binaryNode.rightChild);
			} else {
				binaryNode.rightChild = new BinaryNode<E>(element);
			}
		} else {
			// 元素相等则不处理
		}
	}

	/**
	 * 采用返回值的方式，可以绕过BinaryNode减少对parent的引用
	 */
	public BinaryNode<E> remove(E element, BinaryNode<E> binaryNode) {
		if (binaryNode == null) {
			return null;
		}

		int result = element.compareTo(binaryNode.element);
		if (result < 0) {
			binaryNode.leftChild = remove(element, binaryNode.leftChild);
		} else if (result > 0) {
			binaryNode.rightChild = remove(element, binaryNode.rightChild);
		} else if (binaryNode.leftChild != null && binaryNode.rightChild != null) { // 处理两个节点的情况
			binaryNode.element = findMin(binaryNode.rightChild).element;
			binaryNode.rightChild = remove(binaryNode.element, binaryNode.rightChild); // 递归调用remove
		} else { // 处理只有一个节点或没有子节点的情况
			binaryNode = (binaryNode.rightChild == null ? binaryNode.leftChild : binaryNode.rightChild);
		}

		return binaryNode;
	}

	public void preOrder() {
		printPreOrder(root);
		System.out.println();
	}

	public void inOrder() {
		printInOrder(root);
		System.out.println();
	}

	public void postOrder() {
		printPostOrder(root);
		System.out.println();
	}

	private void printPreOrder(BinaryNode<E> binaryNode) {
		Stack<BinaryNode<E>> stack = new Stack<BinaryNode<E>>();
		stack.push(binaryNode);

		while (!stack.isEmpty()) {
			BinaryNode<E> currentNode = stack.pop();
			System.out.printf("%3s", currentNode.element);

			if (currentNode.rightChild != null) {
				stack.push(currentNode.rightChild);
			}
			if (currentNode.leftChild != null) {
				stack.push(currentNode.leftChild);
			}
		}
		/**
		 * if (binaryNode == null) { return; } System.out.printf("%3s",
		 * binaryNode.element); printPreOrder(binaryNode.leftChild);
		 * printPreOrder(binaryNode.rightChild);
		 **/
	}

	private void printInOrder(BinaryNode<E> binaryNode) {
		Stack<BinaryNode<E>> stack = new Stack<BinaryNode<E>>();

		while (true) {
			goAloneLeftBranch(stack, binaryNode);

			if (stack.isEmpty()) {
				break;
			}

			binaryNode = stack.pop();
			System.out.printf("%3s", binaryNode.element);
			binaryNode = binaryNode.rightChild;
		}

		// if (binaryNode == null) {
		// return;
		// }
		// printInOrder(binaryNode.leftChild);
		// System.out.printf("%3s", binaryNode.element);
		// printInOrder(binaryNode.rightChild);

	}

	private void goAloneLeftBranch(Stack<BinaryNode<E>> stack, BinaryNode<E> node) {
		while (node != null) {
			stack.push(node);
			node = node.leftChild;
		}
	}

	private void printPostOrder(BinaryNode<E> binaryNode) {
		if (binaryNode == null) {
			return;
		}
		printPostOrder(binaryNode.leftChild);
		printPostOrder(binaryNode.rightChild);
		System.out.printf("%3s", binaryNode.element);
	}

	// 有无static的区别???
	private static class BinaryNode<E> {
		E element;
		BinaryNode<E> leftChild;
		BinaryNode<E> rightChild;

		BinaryNode(E element) {
			this(null, element, null);
		}

		BinaryNode(BinaryNode<E> leftChild, E element, BinaryNode<E> rightChild) {
			this.element = element;
			this.leftChild = leftChild;
			this.rightChild = rightChild;
		}
	}

}

class UnderflowException extends RuntimeException {
	private static final long serialVersionUID = 1L;

}
