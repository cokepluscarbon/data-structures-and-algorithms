package io.cokepluscarbon.collection;

public class BinaryTree {

	private static class TreeNode<E> {
		E element;
		TreeNode<E> left;
		TreeNode<E> right;

		TreeNode(E element) {
			this(null, element, null);
		}

		TreeNode(TreeNode<E> left, E element, TreeNode<E> right) {
			this.left = left;
			this.element = element;
			this.right = right;
		}
	}
}
