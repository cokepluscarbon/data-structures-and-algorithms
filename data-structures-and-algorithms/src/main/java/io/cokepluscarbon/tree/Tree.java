package io.cokepluscarbon.tree;

public interface Tree<E, T> {
	public E getElement();

	public E setElement(E e);

	public T getParent();

	public T getFirstChild();

	public T getNextSibling();

	public int getSize();

	public int getHeight();

	public int getDepth();
}
