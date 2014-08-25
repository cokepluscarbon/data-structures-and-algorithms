package io.cokepluscarbon.collection;

import junit.framework.Assert;

import org.junit.Test;

public class MyHashMapTest {
	@Test
	public void put_1() {
		MyHashMap<String, String> hashMap = new MyHashMap<String, String>();
		for (int i = 0; i < 1000; i++) {
			hashMap.put("key_" + i, "value_" + i);
		}

		for (int i = 0; i < 1000; i++) {
			Assert.assertEquals("value_" + i, hashMap.get("key_" + i));
		}
	}

	@Test
	public void remove_1() {
		MyHashMap<String, String> hashMap = new MyHashMap<String, String>();
		for (int i = 0; i < 1000; i++) {
			hashMap.put("key_" + i, "value_" + i);
		}

		for (int i = 0; i < 1000; i += 2) {
			hashMap.remove("key_" + i);
		}

		Assert.assertEquals(500, hashMap.size());
	}
}
