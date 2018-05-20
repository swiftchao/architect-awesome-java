package org.chaofei.datastruct;

import java.io.Serializable;
import java.util.EmptyStackException;

public class MyLinkedStack<T> implements MyStack<T>, Serializable {

	private static final long serialVersionUID = 5908691039703378848L;
	
	private Node<T> top;
	
	private int size;
	
	public MyLinkedStack() {
		this.top = new Node<>();
	}

	public int size() {
		return size;
	}
	
	@Override
	public boolean isEmpty() {
		return null == top || null == top.data;
	}

	@Override
	public void push(T data) throws Exception {
		if (null == data) {
			throw new Exception("data can't be null");
		}
		if (null == top) {
			this.top = new Node<>(data);
		} else if (null == this.top.data) {
			this.top.data = data;
		} else {
			Node<T> p = new Node<T>(data, this.top);
			top = p; // 更新栈顶
		}
		++size;
	}

	@Override
	public T peek() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		return top.data;
	}

	@Override
	public T pop() {
		if (isEmpty()) {
			throw new EmptyStackException();
		}
		T data = top.data;
		top = top.next;
		--size;
		return data;
	}
}
