package io.cokepluscarbon.collection;

import java.util.Iterator;

public class MyHashSet<E> implements MySet<E> {
	private static int DEFAULT_INITIAL_CAPACITY = 4;
	private int capacity;
	private static int MAXIMUM_CAPACITY = 1 << 30;
	private static float DEFAULT_MAX_LOAD_FACTOR = 0.75f;
	private float loadFactorThreshold;
	private int size;
	private LinkedList<E>[] table;

	public MyHashSet() {
		this(DEFAULT_INITIAL_CAPACITY);
	}

	public MyHashSet(int capacity) {
		this(DEFAULT_INITIAL_CAPACITY, DEFAULT_MAX_LOAD_FACTOR);
	}

	@SuppressWarnings("unchecked")
	public MyHashSet(int capacity, float loadFactorThreshold) {
		if (capacity > MAXIMUM_CAPACITY) {
			this.capacity = MAXIMUM_CAPACITY;
		} else {
			this.capacity = trimToPowerOf2(capacity);
		}

		this.size = 0;
		this.loadFactorThreshold = loadFactorThreshold;
		table = new LinkedList[capacity];
	}

	@Override
	public void clear() {
		size = 0;
		removeElements();
	}

	@Override
	public boolean contains(E element) {
		int bucketIndex = hash(element.hashCode());
		LinkedList<E> bucket = table[bucketIndex];
		if (bucket != null) {
			for (E ele : bucket) {
				if (ele.equals(element)) {
					return true;
				}
			}
		}

		return false;
	}

	@Override
	public boolean isEmpty() {
		return size() == 0;
	}

	@Override
	public boolean add(E element) {
		if (contains(element)) {
			return false;
		}

		if (size > capacity * loadFactorThreshold) {
			if (capacity == MAXIMUM_CAPACITY) {
				throw new RuntimeException("Exceeding maximum capacity");
			}
			rehash();
		}

		int bucketIndex = hash(element.hashCode());
		if (table[bucketIndex] == null) {
			table[bucketIndex] = new LinkedList<E>();
		}
		table[bucketIndex].add(element);
		size++;

		return true;
	}

	@Override
	public boolean remove(E element) {
		int bucketIndex = hash(element.hashCode());
		LinkedList<E> bucket = table[bucketIndex];
		if (bucket != null) {
			for (E ele : bucket) {
				if (ele.equals(element)) {
					bucket.remove(element);
					size--;
					return true;
				}
			}
		}

		return false;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Iterator<E> iterator() {
		return new MyHashSetIterator(this);
	}

	private int trimToPowerOf2(int initialCapacity) {
		int capacity = 1;
		while (capacity < initialCapacity) {
			capacity <<= 1; // Same as capacity *= 2. <= is more efficient
		}

		return capacity;
	}

	private void removeElements() {
		for (int i = 0; i < capacity; i++) {
			if (table[i] != null) {
				table[i].clear();
			}
		}
	}

	private int hash(int hashCode) {
		return supplementalHash(hashCode) & (capacity - 1);
	}

	@SuppressWarnings("unchecked")
	private void rehash() {
		java.util.ArrayList<E> list = setToList(); // Copy to a list
		capacity <<= 1; // Same as capacity *= 2. <= is more efficient
		table = new LinkedList[capacity]; // Create a new hash table
		size = 0;
		for (E element : list) {
			add(element); // Add from the old table to the new table
		}
	}

	private int supplementalHash(int hashCode) {
		hashCode ^= (hashCode >>> 20) ^ (hashCode >>> 12);
		return hashCode ^ (hashCode >>> 7) ^ (hashCode >>> 4);
	}

	private java.util.ArrayList<E> setToList() {
		java.util.ArrayList<E> list = new java.util.ArrayList<E>();
		for (int i = 0; i < capacity; i++) {
			if (table[i] != null) {
				for (E e : table[i]) {
					list.add(e);
				}
			}
		}
		return list;
	}

	class MyHashSetIterator implements Iterator<E> {
		private MyHashSet<E> hashSet;
		private int currIndex = 0;

		public MyHashSetIterator(MyHashSet<E> hashSet) {
			this.hashSet = hashSet;
		}

		@Override
		public boolean hasNext() {
			return currIndex < hashSet.size() - 1 ? true : false;
		}

		@Override
		public E next() {
			// TODO Auto-generated method stub
			return null;
		}
	}

}
