package io.cokepluscarbon.collection;

import java.util.HashMap;

import org.junit.Test;

public class MyTest {
	@Test
	public void t1() {
		Integer i = 1314;
		Integer j = 1314;
		System.out.println(i.hashCode());
		System.out.println(j.hashCode());

		Float k = 1.234F;
		Float l = 1.234F;
		System.out.println(k.hashCode());
		System.out.println(l.hashCode());

		Long m = 543215432154321L;
		Long n = 543215432154321L;
		System.out.println(m.hashCode());
		System.out.println(n.hashCode());

		System.out.println(Float.toHexString(k));
		System.out.println(Integer.toHexString(new Integer(k.hashCode())));
		
		"".hashCode();
		
		
		HashMap<String,String> map = null;
		map.put(null,null);
	}
}
