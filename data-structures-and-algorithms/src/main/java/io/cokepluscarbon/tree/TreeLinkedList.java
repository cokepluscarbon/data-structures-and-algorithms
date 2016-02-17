package io.cokepluscarbon.tree;

import io.cokepluscarbon.collection.ArrayQueue;

import java.util.LinkedList;
import java.util.Queue;

public class TreeLinkedList<E> implements Tree<E, TreeLinkedList<E>> {
	private E element;
	private TreeLinkedList<E> parent;
	private TreeLinkedList<E> firstChild;
	private TreeLinkedList<E> nextSibling;

	public TreeLinkedList() {

	}

	public TreeLinkedList(E element, TreeLinkedList<E> parent,
			TreeLinkedList<E> firstChild, TreeLinkedList<E> nextSibling) {
		this.element = element;
		this.parent = parent;
		this.firstChild = firstChild;
		this.nextSibling = nextSibling;
	}

	@Override
	public E getElement() {
		return element;
	}

	@Override
	public E setElement(E element) {
		E backup = this.element;
		this.element = element;

		return backup;
	}

	@Override
	public TreeLinkedList<E> getParent() {
		return parent;
	}

	@Override
	public TreeLinkedList<E> getFirstChild() {
		return firstChild;
	}

	@Override
	public TreeLinkedList<E> getNextSibling() {
		return nextSibling;
	}

	@Override
	public int getSize() {
		int size = 1;
		if (firstChild != null) {
			size += firstChild.getSize();
		}
		if (nextSibling != null) {
			size += nextSibling.getSize();
		}

		return size;
	}

	@Override
	public int getHeight() {
		int height = -1;
		TreeLinkedList<E> subTree = firstChild;
		while (subTree != null) {
			height = Math.max(height, subTree.getHeight());
			subTree = subTree.getNextSibling();
		}

		return height + 1;
	}

	@Override
	public int getDepth() {
		int depth = 0;
		TreeLinkedList<E> p = getParent();

		if (p != null) {
			depth++;
			p = p.getParent();
		}

		return depth;
	}

	public void preOrderTraversal(TreeLinkedList<E> tree) {
		if (tree != null) {
			System.out.print(tree.getElement() + "\t");

			for (TreeLinkedList<E> subTree = tree.getFirstChild(); subTree != null; subTree = subTree
					.getNextSibling()) {
				preOrderTraversal(subTree);
			}
		}
	}

	public void postOrderTraversal(TreeLinkedList<E> tree) {
		if (tree != null) {
			for (TreeLinkedList<E> subTree = tree.getFirstChild(); subTree != null; subTree = subTree
					.getNextSibling()) {
				preOrderTraversal(subTree);
			}

			System.out.print(tree.getElement() + "\t");
		}
	}

	public void levelOrderTraversal(TreeLinkedList<E> tree) {
		Queue<TreeLinkedList<E>> queue = new LinkedList<TreeLinkedList<E>>();
		if (tree != null) {
			queue.add(tree);
			while (!queue.isEmpty()) {
				TreeLinkedList<E> subTree = queue.poll();
				System.out.print(subTree.getElement() + "\t");

				for (subTree = subTree.getFirstChild(); subTree != null; subTree = subTree
						.getNextSibling()) {
					queue.add(subTree);
				}
			}

		}
	}
}
