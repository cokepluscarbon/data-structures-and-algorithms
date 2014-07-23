package io.cokepluscarbon.collection;

import io.cokepluscarbon.collection.ArrayQueue;

import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Test;

public class ArrayQueueTest {
	@Test
	public void t1_add() {
		ArrayQueue<String> queue = new ArrayQueue<String>(5);
		queue.add("apple");
		queue.add("orange");
		queue.add("pear");
		queue.add("banana");

		Assert.assertEquals(4, queue.size());
	}

	@Test(expected = IllegalStateException.class)
	public void t2_add() {
		ArrayQueue<String> queue = new ArrayQueue<String>(5);
		queue.add("apple");
		queue.add("orange");
		queue.add("pear");
		queue.add("banana");
		queue.add("element:5");
		queue.add("element:6");
	}

	@Test
	public void t3_add() {
		ArrayQueue<String> queue = new ArrayQueue<String>(1000);
		for (int i = 0; i < 1000; i++) {
			queue.add("element:" + i);
		}

		Assert.assertEquals(1000, queue.size());
	}

	@Test
	public void t4_remove() {
		ArrayQueue<String> queue = new ArrayQueue<String>(10);
		queue.add("apple");
		queue.add("orange");
		queue.add("pear");
		queue.add("banana");

		Assert.assertEquals("apple", queue.remove());
		Assert.assertEquals("orange", queue.remove());
		Assert.assertEquals(2, queue.size());
		Assert.assertEquals("pear", queue.remove());
		Assert.assertEquals("banana", queue.remove());
		Assert.assertEquals(0, queue.size());
	}

	@Test(expected = NoSuchElementException.class)
	public void t5_remove() {
		ArrayQueue<String> queue = new ArrayQueue<String>(10);
		queue.add("apple");

		queue.remove();
		queue.remove();
	}

	@Test
	public void t6_poll() {
		ArrayQueue<String> queue = new ArrayQueue<String>(10);
		queue.add("apple");

		Assert.assertEquals("apple", queue.poll());
		Assert.assertEquals(0, queue.size());
		Assert.assertEquals(null, queue.poll());
	}

	@Test
	public void t7_peek() {
		ArrayQueue<String> queue = new ArrayQueue<String>(10);
		queue.add("apple");

		Assert.assertEquals("apple", queue.poll());
		Assert.assertEquals(0, queue.size());
	}

}
