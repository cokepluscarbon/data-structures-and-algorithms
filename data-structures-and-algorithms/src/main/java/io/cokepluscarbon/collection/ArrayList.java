package io.cokepluscarbon.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayList<T> implements Iterable<T> {
	private static final int DEFAULT_CAPACITY = 10;
	private int theSize;
	private T[] theItems;

	public ArrayList() {
		clear();
	}

	public void clear() {
		theSize = 0;
		ensureCapacity(DEFAULT_CAPACITY);
	}

	public int size() {
		return theSize;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	public void trimToSize() {
		ensureCapacity(size());
	}

	public boolean add(T t) {
		add(size(), t);
		return true;
	}

	@SuppressWarnings("unchecked")
	public void ensureCapacity(int newCapacity) {
		if (newCapacity < size()) {
			return;
		}

		T[] newItems = (T[]) new Object[newCapacity];
		for (int i = 0; i < size(); i++) {
			newItems[i] = theItems[i];
		}
		theItems = newItems;
	}

	public void add(int index, T t) {
		if (index < 0 || index > size()) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		if (theItems.length == size()) {
			ensureCapacity(size() * 2 + 1);
		}
		for (int i = index; i < size(); i++) {
			theItems[i + 1] = theItems[i];
		}
		theItems[size()] = t;
		theSize++;
	}

	public T set(int index, T t) {
		if (index < 0 || index > size()) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		T old = theItems[index];
		theItems[index] = t;
		return old;
	}

	public void remove(int index) {
		if (index < 0 || index > size()) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		for (int i = index; i < size() - 1; i++) {
			theItems[i] = theItems[i + 1];
		}
		theSize--;
	}

	public T get(int index) {
		if (index < 0 || index >= size()) {
			throw new ArrayIndexOutOfBoundsException(index);
		}
		return theItems[index];
	}

	@Override
	public Iterator<T> iterator() {
		return new ArrayListIterator();
	}

	private class ArrayListIterator implements Iterator<T> {
		private int currentIndex = 0;

		@Override
		public boolean hasNext() {
			return size() > currentIndex;
		}

		@Override
		public T next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			return theItems[currentIndex++];
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub

		}

	}

}
