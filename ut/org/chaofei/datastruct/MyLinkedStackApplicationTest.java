package org.chaofei.datastruct;

import org.junit.Before;
import org.junit.Test;

public class MyLinkedStackApplicationTest {
	
	private MyLinkedStackApplication myLinkedStackApplication;
	@Before
	public void setup() {
		myLinkedStackApplication = new MyLinkedStackApplication();
	}
	
	@Test
	public void testIsValid() throws Exception {
		if (myLinkedStackApplication.isValid("((5-3)*8-2))")) {
			System.out.println("check pass.");
		} else {
			System.out.println("check exception!");
		}
	}
}
