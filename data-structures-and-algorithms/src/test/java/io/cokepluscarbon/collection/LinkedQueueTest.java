package io.cokepluscarbon.collection;

import io.cokepluscarbon.collection.LinkedQueue;

import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.Test;

public class LinkedQueueTest {
	@Test
	public void t1_add() {
		LinkedQueue<String> queue = new LinkedQueue<String>(5);
		queue.add("apple");
		queue.add("orange");
		queue.add("pear");
		queue.add("banana");

		Assert.assertEquals(4, queue.size());
	}

	@Test(expected = IllegalArgumentException.class)
	public void t2_add() {
		LinkedQueue<String> queue = new LinkedQueue<String>(5);
		queue.add("apple");
		queue.add("orange");
		queue.add("pear");
		queue.add("banana");
		queue.add("element:5");
		queue.add("element:6");
	}

	@Test
	public void t3_add() {
		LinkedQueue<String> queue = new LinkedQueue<String>(1000);
		for (int i = 0; i < 1000; i++) {
			queue.add("element:" + i);
		}

		Assert.assertEquals(1000, queue.size());
	}

	@Test
	public void t4_remove() {
		LinkedQueue<String> queue = new LinkedQueue<String>(10);
		queue.add("apple");
		queue.add("orange");
		queue.add("pear");
		queue.add("banana");

		Assert.assertEquals(queue.remove(), "apple");
		Assert.assertEquals(queue.remove(), "orange");
		Assert.assertEquals(2, queue.size());
		Assert.assertEquals(queue.remove(), "pear");
		Assert.assertEquals(queue.remove(), "banana");
		Assert.assertEquals(0, queue.size());
	}

	@Test(expected = NoSuchElementException.class)
	public void t5_remove() {
		LinkedQueue<String> queue = new LinkedQueue<String>(10);
		queue.add("apple");

		queue.remove();
		queue.remove();
	}

	@Test
	public void t6_poll() {
		LinkedQueue<String> queue = new LinkedQueue<String>(10);
		queue.add("apple");

		Assert.assertEquals("apple", queue.poll());
		Assert.assertEquals(0, queue.size());
		Assert.assertEquals(null, queue.poll());
	}

	@Test
	public void t7_peek() {
		LinkedQueue<String> queue = new LinkedQueue<String>(10);
		queue.add("apple");

		Assert.assertEquals("apple", queue.poll());
		Assert.assertEquals(0, queue.size());
	}

}
