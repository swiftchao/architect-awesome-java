package org.chaofei.datastruct;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MyListTest {
	@Test
	public void testLeftAndRightDisplacement() {
		int number = 10;
		// 原始数二进制
		assertEquals("1010", MyList.printInfo(number));
		
		number = number << 1;
		// 左移一位
		assertEquals("10100", MyList.printInfo(number));
		
		number = number >> 1;
		// 右移一位
		assertEquals("1010", MyList.printInfo(number));

		number = number >> 1;
		assertEquals("101", MyList.printInfo(number));

		number = number >> 1;
		assertEquals("10", MyList.printInfo(number));
      }
	
	@Test
	public void testGetNullIndexOf() {
		assertEquals(1, MyList.getNullIndexOf());
	}
}
