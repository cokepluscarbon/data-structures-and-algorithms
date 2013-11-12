package com.softwinners.util;

import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {
	private static final int DEFAULT_CAPACITY = 10;
	private int theSize;
	private T[] theItems;

	public MyArrayList() {
		clear();
	}

	public T get(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}

		return theItems[index];
	}

	@SuppressWarnings("unchecked")
	public void clear() {
		theItems = (T[]) new Object[DEFAULT_CAPACITY];
		theSize = 0;
	}

	public boolean add(T value) {
		add(size(), value);

		return true;
	}

	public boolean add(int index, T value) {
		if (index < 0 || index > size()) {
			throw new IndexOutOfBoundsException();
		}

		if (index >= theItems.length) {
			ensureCapacity(theItems.length * 2 + 1);
		}

		for (int i = size(); i > index; i--) {
			theItems[i + 1] = theItems[i];
		}

		theItems[index] = value;
		theSize++;

		return true;
	}

	public T remove(int index) {
		if (index < 0 || index >= size()) {
			throw new IndexOutOfBoundsException();
		}

		T theRemoveItem = theItems[index];
		for (int i = index; i < size() - 1; i++) {
			theItems[i] = theItems[i + 1];
		}

		theSize--;
		return theRemoveItem;
	}

	public int size() {
		return theSize;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public void ensureCapacity(int capacity) {
		T[] oldItems = theItems;
		@SuppressWarnings("unchecked")
		T[] newItems = (T[]) new Object[capacity];

		for (int i = 0; i < oldItems.length; i++) {
			newItems[i] = oldItems[i];
		}
		theItems = newItems;
	}

	public Iterator<T> iterator() {
		return new MyArrayListIterator();
	}

	private class MyArrayListIterator implements Iterator<T> {
		private int currentIndex;

		public boolean hasNext() {
			return currentIndex < MyArrayList.this.size();
		}

		public T next() {
			if (currentIndex >= size()) {
				throw new IndexOutOfBoundsException();
			}

			return MyArrayList.this.get(currentIndex++);
		}

		public void remove() {
			MyArrayList.this.remove(currentIndex);
		}

	}

}
