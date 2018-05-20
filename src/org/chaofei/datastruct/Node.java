package org.chaofei.datastruct;

public class Node<T> {

	public T data;
	
	public Node<T> next;
	
	public Node() {
	}
	
	public Node(T data) {
		this.data = data;
	}

	public Node(T data, Node<T> top) {
		this.data = data;
		this.next = top;
	}
}
