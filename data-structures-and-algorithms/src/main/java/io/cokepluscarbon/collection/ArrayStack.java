package io.cokepluscarbon.collection;

public class ArrayStack<E> {
	private E[] items;
	private final static int DEFAULT_CAPACITY = 16;
	private int top;

	@SuppressWarnings("unchecked")
	public ArrayStack() {
		items = (E[]) new Object[DEFAULT_CAPACITY];
		top = -1;
	}

	public int size() {
		return top + 1;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public void push(E e) {
		if (size() == items.length) {
			ensureCapacity(items.length * 2);
		}
		items[++top] = e;
	}

	public E pop() {
		if (size() == 0) {
			throw new StackOverflowError();
		}

		return items[top--];
	}

	public E peek() {
		if (size() == 0) {
			throw new StackOverflowError();
		}

		return items[top];
	}

	@SuppressWarnings("unchecked")
	private void ensureCapacity(int capacity) {
		E[] newItems = (E[]) new Object[capacity];
		for (int i = 0; i < items.length; i++) {
			newItems[i] = items[i];
		}
		items = newItems;
	}

}
