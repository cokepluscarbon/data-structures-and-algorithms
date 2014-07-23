package io.cokepluscarbon.collection;

import java.util.NoSuchElementException;

public class LinkedQueue<E> {
	private Node<E> front;
	private Node<E> rear;
	private int capacity;
	private int size;

	public LinkedQueue(int capacity) {
		size = 0;
		front = rear = null;
		this.capacity = capacity;
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
		if (size() == capacity) {
			throw new IllegalArgumentException();
		}

		if (size() == 0) {
			front = rear = new Node<E>(element);
		} else {
			rear.next = new Node<E>(element);
			rear = rear.next;
		}
		size++;

		return true;
	}

	/**
	 * 跟add(E element)一致
	 */
	public boolean offer(E element) {
		return add(element);
	}

	/**
	 * 检索并删除此队列的头元素
	 * 
	 * @throws NoSuchElementException
	 *             如果队列为空，则抛出该异常
	 */
	public E remove() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		Node<E> curr = front;
		if (size() == 1) {
			front = rear = null;
		} else {
			front = front.next;
		}
		size--;

		return curr.element;
	}

	/**
	 * 检索并删除此队列的头元素
	 * 
	 * @return 返回队列的头元素，当队列为空时则返回null
	 */
	public E poll() {
		if (isEmpty()) {
			return null;
		}

		Node<E> curr = front;
		if (size() == 1) {
			front = rear = null;
		} else {
			front = front.next;
		}
		size--;

		return curr.element;
	}

	/**
	 * 检索但不删除队列的头元素
	 * 
	 * @throws NoSuchElementException
	 *             如果队列为空，则抛出该异常
	 */
	public E element() {
		if (isEmpty()) {
			throw new NoSuchElementException();
		}

		return front.element;
	}

	/**
	 * 检索但不删除此队列的头元素
	 * 
	 * @return 返回队列的头元素，当队列为空时则返回null
	 */
	public E peek() {
		if (isEmpty()) {
			return null;
		}

		return front.element;
	}

	private static class Node<E> {
		Node<E> next;
		E element;

		Node(E element) {
			this.element = element;
		}
	}
}
