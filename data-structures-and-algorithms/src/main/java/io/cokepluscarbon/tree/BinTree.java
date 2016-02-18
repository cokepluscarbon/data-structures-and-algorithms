package io.cokepluscarbon.tree;

import java.util.Iterator;

public interface BinTree<E, T> {
	public BinTreePosition getRoot();

	public boolean isEmpty();

	public int getSize();

	public int getHeight();

	public E getElement();

	public E setElement();

	public T getParent();

	public T getLChild();

	public T getRChild();

	public Iterator<T> preOrderIterator();

	public Iterator<T> postOrderIterator();

	public Iterator<T> inOrderIterator();

	public Iterator<T> levelOrderIterator();
}
