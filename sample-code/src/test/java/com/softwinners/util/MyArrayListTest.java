package com.softwinners.util;

import java.util.Iterator;

import junit.framework.Assert;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MyArrayListTest {
	private MyList<Object> list;

	@Before
	public void before() {
		list = new MyArrayList<Object>();
	}

	@After
	public void after() {
		list = null;
	}

	@Test
	public void t01_add() {
		list.add("My");
		list.add("name");
		list.add("is");
		list.add("Zengguotai");

		Assert.assertEquals(4, list.size());

		Assert.assertEquals("My", list.get(0));
		Assert.assertEquals("name", list.get(1));
		Assert.assertEquals("is", list.get(2));
		Assert.assertEquals("Zengguotai", list.get(3));
	}

	@Test
	public void t02_add() {
		for (int i = 0; i < 1000; i++) {
			list.add(i + "token");
		}

		Assert.assertEquals(1000, list.size());
		for (int i = 0; i < 1000; i++) {
			Assert.assertEquals(i + "token", list.get(i));
		}
	}

	@Test
	public void t03_addByIndex() {
		for (int i = 0; i < 1000; i++) {
			list.add("?token=" + i);
		}

		list.add(0, "insertNode 0");
		list.add(500, "insertNode 500");

		Assert.assertEquals("insertNode 0", list.get(0));
		Assert.assertEquals("insertNode 500", list.get(500));
		Assert.assertEquals(1002, list.size());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void t04_addIndexOutOfBoundsException() {
		for (int i = 0; i < 1000; i++) {
			list.add("?token=" + i);
		}

		list.add(1002, "exception");
	}

	@Test
	public void t05_remove() {
		for (int i = 0; i < 1000; i++) {
			list.add("?token=" + i);
		}

		list.remove(500);

		for (int i = 0; i < 500; i++) {
			Assert.assertEquals("?token=" + i, list.get(i));
		}
		for (int i = 500; i < 999; i++) {
			Assert.assertEquals("?token=" + (i + 1), list.get(i));
		}

		Assert.assertEquals(999, list.size());
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void t06_removeIndexOutOfBoundsException() {
		for (int i = 0; i < 1000; i++) {
			list.add("?token=" + i);
		}

		list.remove(1000);
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void t07_removeIndexOutOfBoundsException() {
		for (int i = 0; i < 1000; i++) {
			list.add("?token=" + i);
		}

		list.remove(-1);
	}

	@Test
	public void t08_iterator() {
		for (int i = 0; i < 1000; i++) {
			list.add("?token=" + i);
		}

		Iterator<Object> it = list.iterator();

		for (int i = 0; i < 1000; i++) {
			Assert.assertEquals(true, it.hasNext());
			Assert.assertEquals("?token=" + i, it.next());
		}
	}

	@Test(expected = IndexOutOfBoundsException.class)
	public void t09_iteratorIndexOutOfBoundsException() {
		for (int i = 0; i < 1000; i++) {
			list.add("?token=" + i);
		}

		Iterator<Object> it = list.iterator();

		for (int i = 0; i < 1000; i++) {
			it.next();
		}

		it.next();
	}

	@Test
	public void t09_clear() {
		for (int i = 0; i < 1000; i++) {
			list.add("?token=" + i);
		}

		list.clear();

		Assert.assertEquals(0, list.size());
	}

}
