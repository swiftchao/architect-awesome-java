package org.chaofei.datastruct;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MySeqStackTest {
	private MySeqStack<String> seqStack;
	
	@Before
	public void setUp() {
		seqStack = new MySeqStack<>();
	}
	
	@Test
	public void testPushSizePeekAndPop() {
		seqStack.push("A");
		seqStack.push("B");
		seqStack.push("C");
        System.out.println("size->" + seqStack.size());
        int l = seqStack.size(); // size 在减少,必须先记录
        System.out.println("s.peek->" + seqStack.peek());
        for (int i=0;i<l;i++) {
        	System.out.println("s.pop->" + seqStack.pop());
        }
        System.out.println("s.peek->" + seqStack.peek());
        
	}
	
	@Test
	public void testPeekEmptyStackException() {
		seqStack.push("A");
		seqStack.push("B");
		seqStack.push("C");
        System.out.println("size->" + seqStack.size());
        int l = seqStack.size(); // size 在减少,必须先记录
        System.out.println("s.peek->" + seqStack.peek());
        for (int i=0;i<l;i++) {
        	System.out.println("s.pop->" + seqStack.pop());
        }
        System.out.println("s.peek->" + seqStack.peek());
	}
	
	@Test
	public void testPushEnsueCapacity() {
    	seqStack.push("A");
		seqStack.push("B");
		seqStack.push("C");
		seqStack.push("D");
		seqStack.push("E");
		seqStack.push("F");
		seqStack.push("G");
		seqStack.push("H");
		seqStack.push("I");
		seqStack.push("J");
		seqStack.push("K");
		seqStack.push("L");
		System.out.println("size->" + seqStack.size());
		System.out.println(seqStack.toString());
		assertEquals(12, seqStack.size());
		assertEquals("[A,B,C,D,E,F,G,H,I,J,K,L,]", seqStack.toString());
	}
}