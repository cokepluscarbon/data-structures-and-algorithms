package io.cokepluscarbon.collection;
import io.cokepluscarbon.collection.ArrayList;

import java.util.Iterator;

import org.junit.Assert;
import org.junit.Test;

public class ArrayListTest {
	@Test
	public void t1_size() {
		ArrayList<Integer> list = new ArrayList<Integer>();

		Assert.assertEquals(0, list.size());
	}

	@Test
	public void t2_size() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);

		Assert.assertEquals(3, list.size());
	}

	@Test
	public void t3_get() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);

		Assert.assertEquals(new Integer(1), list.get(0));
		Assert.assertEquals(new Integer(2), list.get(1));
		Assert.assertEquals(new Integer(3), list.get(2));
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void t4_get() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);

		list.get(3);
	}

	@Test(expected = ArrayIndexOutOfBoundsException.class)
	public void t5_get() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);

		list.get(-1);
	}

	@Test
	public void t6_remove() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);

		list.remove(0);
		list.remove(0);

		Assert.assertEquals(1, list.size());
		Assert.assertEquals(new Integer(3), list.get(0));
	}

	@Test
	public void t7_add() {
		ArrayList<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < 10000; i++) {
			list.add(i);
		}

		Assert.assertEquals(10000, list.size());
	}

	@Test
	public void t8() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < 100; i++) {
			list.add(i);
		}

		Iterator<Integer> it = list.iterator();
		int count = 0;
		while (it.hasNext()) {
			it.next();
			count++;
		}

		Assert.assertEquals(100, count);
	}
}
