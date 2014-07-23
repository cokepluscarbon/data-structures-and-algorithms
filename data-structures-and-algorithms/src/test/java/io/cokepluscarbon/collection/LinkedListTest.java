package io.cokepluscarbon.collection;
import io.cokepluscarbon.collection.LinkedList;

import org.junit.Assert;
import org.junit.Test;

public class LinkedListTest {
	@Test
	public void t1_init() {
		LinkedList<String> list = new LinkedList<String>();

		Assert.assertEquals(0, list.size());
	}

	@Test
	public void t2_add() {
		LinkedList<String> list = new LinkedList<String>();
		list.add("apple");

		Assert.assertEquals(1, list.size());
	}

	@Test
	public void t3_add() {
		LinkedList<String> list = new LinkedList<String>();
		list.add("apple");
		list.add("orange");

		Assert.assertEquals(2, list.size());
	}

	@Test
	public void t4_add() {
		LinkedList<String> list = new LinkedList<String>();

		for (int i = 0; i < 10000; i++) {
			list.add("[" + i + "]");
		}

		Assert.assertEquals(10000, list.size());
	}

	@Test
	public void t5_get() {
		LinkedList<String> list = new LinkedList<String>();

		for (int i = 0; i < 10000; i++) {
			list.add("[" + i + "]");
		}

		Assert.assertEquals("[500]", list.get(500));
	}

	@Test
	public void t6_remove() {
		LinkedList<String> list = new LinkedList<String>();

		for (int i = 0; i < 10000; i++) {
			list.add("[" + i + "]");
		}

		list.remove(500);
		list.remove(500);

		Assert.assertEquals("[502]", list.get(500));
		Assert.assertEquals(9998, list.size());
	}

	@Test
	public void t7_set() {
		LinkedList<String> list = new LinkedList<String>();

		for (int i = 0; i < 10000; i++) {
			list.add("[" + i + "]");
		}

		list.set(500, "apple");
		list.set(501, "orage");

		Assert.assertEquals("apple", list.get(500));
		Assert.assertEquals("orage", list.get(501));
		Assert.assertEquals(10000, list.size());
	}
}
