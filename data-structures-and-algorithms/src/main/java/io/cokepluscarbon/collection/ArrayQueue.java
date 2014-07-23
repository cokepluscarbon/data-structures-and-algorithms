package io.cokepluscarbon.collection;

import java.util.NoSuchElementException;

public class ArrayQueue<E> {
	private Object[] items;
	private int addCount;
	private int size;

	public ArrayQueue(int capacity) {
		items = new Object[capacity];
		size = 0;
		addCount = 0;
	}

	public int size() {
		return size;
	}

	public boolean isEmpty() {
		return size() == 0;
	}

	/**
	 * @throws IllegalStateException
	 *             如果队列已满，则抛出该异常
	 */
	public boolean add(E element) {
		if (size() == items.length) {
			throw new IllegalStateException();
		}

		items[addCount++ % items.length] = element;
		size++;
		return true;
	}

	/**
	 * 跟add(E element)一致
	 */
	public boolean offer(E element) {
		if (size() == items.length) {
			throw new IllegalStateException();
		}

		items[addCount++ % items.length] = element;
		size++;
		return true;
	}

	/**
	 * 检索并删除此队列的头元素
	 * 
	 * @throws NoSuchElementException
	 *             如果队列为空，则抛出该异常
	 */
	@SuppressWarnings("unchecked")
	public E remove() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		size--;
		return (E) items[(addCount - (size() + 1)) % items.length];
	}

	/**
	 * 检索并删除此队列的头元素
	 * 
	 * @return 返回队列的头元素，当队列为空时则返回null
	 */
	@SuppressWarnings("unchecked")
	public E poll() {
		if (isEmpty()) {
			return null;
		}
		size--;
		return (E) items[(addCount - (size() + 1)) % items.length];
	}

	/**
	 * 检索但不删除队列的头元素
	 * 
	 * @throws NoSuchElementException
	 *             如果队列为空，则返回null
	 */
	@SuppressWarnings("unchecked")
	public E peek() {
		if (isEmpty()) {
			return null;
		}

		return (E) items[(addCount - size()) % items.length];
	}

	/**
	 * 检索但不删除队列的头元素
	 * 
	 * @throws NoSuchElementException
	 *             如果队列为空，则抛出该异常
	 */
	@SuppressWarnings("unchecked")
	public E element() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		return (E) items[(addCount - size()) % items.length];
	}

}
