package io.cokepluscarbon.collection;

import java.util.Iterator;

public interface MySet<E> extends Iterable<E> {

	public void clear();

	public boolean contains(E element);

	public boolean isEmpty();

	public boolean add(E element);

	public boolean remove(E element);

	public int size();

	public Iterator<E> iterator();

}
