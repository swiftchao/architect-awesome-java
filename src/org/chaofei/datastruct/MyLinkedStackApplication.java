package org.chaofei.datastruct;

public class MyLinkedStackApplication {

	public boolean isValid(String expressString) throws Exception {
		//创建栈
		MyLinkedStack<String> myLinkedStack = new MyLinkedStack<String>();
		int length = expressString.length();
		for (int i = 0; i < length; ++i) {
			char subExpressChar = expressString.charAt(i);
			switch (subExpressChar) {
			case '(' : 
				myLinkedStack.push(subExpressChar + "");
				break;
			}
		}
		return false;
	}
}
