package io.cokepluscarbon.collection;

import org.junit.Test;

public class BinarySearchTreeTest {
	@Test
	public void t1_insert() {
		BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<Integer>();
		binarySearchTree.insert(3);
		binarySearchTree.insert(1);
		binarySearchTree.insert(2);
		binarySearchTree.insert(5);
		binarySearchTree.insert(4);
		binarySearchTree.insert(6);

		binarySearchTree.preOrder();
		System.out.println();
		binarySearchTree.inOrder();
	}
}
