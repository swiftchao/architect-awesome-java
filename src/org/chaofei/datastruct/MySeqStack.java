package org.chaofei.datastruct;

import java.io.Serializable;
import java.util.EmptyStackException;

public class MySeqStack<T> implements MyStack<T>, Serializable {

	private static final long serialVersionUID = 6452310250693811L;
	/**
	 * 栈顶指针,-1代表空栈
	 */
	private int top = -1;
	
	/**
	 * 容量默认大小为10
	 */
	private int capacity = 10;
	
	/**
	 * 存放元素的数组
	 */
	private T[] array;
	
	private int size;
	
	@SuppressWarnings("unchecked")
	public MySeqStack(int capacity) {
		array = (T[]) new Object[capacity];
	}
	
	@SuppressWarnings("unchecked")
	public MySeqStack() {
		array = (T[]) new Object[this.capacity];
	}
	
	public int size() {
		return size;
	}
	
	@Override
	public boolean isEmpty() {
		 return this.top == -1;
	}

	/**
	 * 添加元素,从栈顶(数组尾部)插入
	 * 容量不足时,需要扩容
	 */
	@Override
	public void push(T data) {
		// 判断容量是否充足
		if (array.length == size) {
			ensueCapacity(size * 2 + 1); // 扩容
		}
		// 从栈顶添加元素
		array[++top] = data;
		++size;
	}

	@SuppressWarnings("unchecked")
	private void ensueCapacity(int capacity) {
		if (capacity < size) {
			return;
		}
		T[] old = array;
		array = (T[]) new Object[capacity];
		// 复制元素
		for (int i = 0; i < size; ++i) {
			array[i] = old[i];
		}
	}

	@Override
	public T peek() {
		if (isEmpty()) {
			new EmptyStackException();
		}
		return array[top];
	}

	/**
	 * 从栈顶(顺序表尾部)删除
	 */
	@Override
	public T pop() {
		if (isEmpty()) {
			new EmptyStackException();
		}
		--size;
		return array[top--];
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0; i < size; ++i) {
			sb.append(array[i] + ",");
		}
		sb.append("]");
		return sb.toString();
	}
}