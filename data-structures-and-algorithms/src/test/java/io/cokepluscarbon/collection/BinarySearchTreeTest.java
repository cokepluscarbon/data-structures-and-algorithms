package io.cokepluscarbon.collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BinarySearchTreeTest {
	BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<Integer>();

	@Before
	public void before() {
		binarySearchTree.insert(5);
		binarySearchTree.insert(4);
		binarySearchTree.insert(2);
		binarySearchTree.insert(3);
		binarySearchTree.insert(7);
		binarySearchTree.insert(9);
		binarySearchTree.insert(8);
		binarySearchTree.insert(1);
	}

	@After
	public void after() {
		binarySearchTree.makeEmpty();
	}

	@Test
	public void insert_t1() {
		binarySearchTree.preOrder();
		System.out.println();
		binarySearchTree.inOrder();
		System.out.println();
		binarySearchTree.postOrder();
	}

	@Test
	public void remove_t1() {
		binarySearchTree.remove(5);

		binarySearchTree.preOrder();
		System.out.println();
		binarySearchTree.inOrder();
		System.out.println();
		binarySearchTree.postOrder();
	}

	@Test
	public void findMin_t1() {
		Assert.assertEquals(1, (int) binarySearchTree.findMin());
	}

	@Test
	public void findMax_t1() {
		Assert.assertEquals(9, (int) binarySearchTree.findMax());
	}

	@Test
	public void contains_t1() {
		Assert.assertEquals(true, binarySearchTree.contains(5));
		Assert.assertEquals(false, binarySearchTree.contains(10));

		binarySearchTree.remove(5);
		Assert.assertEquals(false, binarySearchTree.contains(5));
		Assert.assertEquals(true, binarySearchTree.contains(9));
	}
}
