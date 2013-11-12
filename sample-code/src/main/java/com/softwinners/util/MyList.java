package com.softwinners.util;

public interface MyList<T> extends Iterable<T> {

	public T get(int index);

	public void clear();

	public int size();

	public boolean add(T value);

	public boolean add(int index, T value);

	public T remove(int index);

	public boolean isEmpty();
}
