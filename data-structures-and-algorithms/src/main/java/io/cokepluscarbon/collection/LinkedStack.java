package io.cokepluscarbon.collection;

public class LinkedStack<E> {
	private Node<E> last;
	private int top;

	public LinkedStack() {
		last = null;
		top = -1;
	}

	public int size() {
		return top + 1;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public void push(E element) {
		if (size() == 0) {
			last = new Node<E>(null, element);
		} else {
			last = new Node<E>(last, element);
		}

		top++;
	}

	public E pop() {
		if (size() == 0) {
			throw new StackOverflowError();
		}

		Node<E> curr = last;
		last = last.pre;
		curr.pre = null;
		top--;

		return curr.element;
	}

	public E peek() {
		if (size() == 0) {
			throw new StackOverflowError();
		}

		return last.element;
	}

	private static class Node<E> {
		Node<E> pre;
		E element;

		Node(Node<E> pre, E element) {
			this.pre = pre;
			this.element = element;
		}
	}
}
