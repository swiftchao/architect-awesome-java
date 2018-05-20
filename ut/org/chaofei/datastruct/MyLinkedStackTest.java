package org.chaofei.datastruct;

import org.junit.Before;
import org.junit.Test;

public class MyLinkedStackTest {

	private MyLinkedStack<String> myLinkedStack;
	
	@Before
	public void setup() {
		myLinkedStack = new MyLinkedStack<String>();
	}
	
	@Test
	public void testPush() throws Exception {
		myLinkedStack.push("A");
		myLinkedStack.push("B");
		myLinkedStack.push("C");
		myLinkedStack.push("D");
		myLinkedStack.push("E");
		myLinkedStack.push("F");
		System.out.println("myLinkedStack.peek() = " + myLinkedStack.peek());
		int length = myLinkedStack.size();
		for (int i = 0; i < length; ++i) {
			System.out.println("myLinkedStack.pop() = " + myLinkedStack.pop());
		}
	}
}
