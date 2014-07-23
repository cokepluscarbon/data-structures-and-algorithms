package io.cokepluscarbon.collection;

import org.junit.Assert;
import org.junit.Test;

public class LinkedStackTest {

	@Test
	public void t1_push() {
		LinkedStack<String> stack = new LinkedStack<String>();

		Assert.assertEquals(0, stack.size());
	}

	@Test
	public void t2_push() {
		LinkedStack<String> stack = new LinkedStack<String>();
		stack.push("apple");

		Assert.assertEquals(1, stack.size());
	}

	@Test
	public void t3_push() {
		LinkedStack<String> stack = new LinkedStack<String>();
		for (int i = 0; i < 100; i++) {
			stack.push("item:" + i);
		}

		Assert.assertEquals(100, stack.size());
	}

	@Test(expected = StackOverflowError.class)
	public void t4_pop() {
		LinkedStack<String> stack = new LinkedStack<String>();
		stack.pop();
	}

	@Test
	public void t5_pop() {
		LinkedStack<String> stack = new LinkedStack<String>();
		stack.push("apple");
		stack.push("orange");
		stack.push("tiger");

		Assert.assertEquals(3, stack.size());
		Assert.assertEquals("tiger", stack.pop());
		Assert.assertEquals("orange", stack.pop());
		Assert.assertEquals("apple", stack.pop());
		Assert.assertEquals(0, stack.size());
	}

	@Test(expected = StackOverflowError.class)
	public void t6_pop() {
		LinkedStack<String> stack = new LinkedStack<String>();
		stack.peek();
	}

	@Test
	public void t7_pop() {
		LinkedStack<String> stack = new LinkedStack<String>();
		stack.push("apple");
		stack.push("orange");
		stack.push("tiger");

		Assert.assertEquals(3, stack.size());
		Assert.assertEquals("tiger", stack.peek());
		Assert.assertEquals("tiger", stack.pop());
		Assert.assertEquals("orange", stack.peek());
		Assert.assertEquals(2, stack.size());
	}

}
