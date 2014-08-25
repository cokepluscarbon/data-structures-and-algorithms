package io.cokepluscarbon.collection;

import java.util.Set;

public interface MyMap<K, V> {
	public void clear();

	public boolean isEmpty();

	public boolean containsKey(K key);

	public boolean containsValue(V value);

	public Set<Entry<K, V>> entrySet();

	public Set<K> keySet();

	public V put(K key, V value);

	public void remove(K key);

	public int size();

	public Set<V> values();

	public V get(K key);

	public static class Entry<K, V> {
		K key;
		V value;

		public Entry(K key, V value) {
			this.key = key;
			this.value = value;
		}

		public K getKey() {
			return this.key;
		}

		public V getValue() {
			return this.value;
		}

		@Override
		public String toString() {
			return "Entry [key=" + key + ", value=" + value + "]";
		}

	}
}
