package org.chaofei.datastruct;

import java.util.ArrayList;

public class List {

	  public static void main(String[] args) {
          int number = 10;
          //原始数二进制
          printInfo(number);
          number = number << 1;
          //左移一位
          printInfo(number);
          number = number >> 1;
          //右移一位
          printInfo(number);
          
          number = number >> 1;
          printInfo(number);
          
          number = number >> 1;
          printInfo(number);
          testIndexOf();
      }
      
      /**
       * 输出一个int的二进制数
       * @param num
       */
      private static void printInfo(int num){
          System.out.println(num + " " + Integer.toBinaryString(num));
      }
      
      private static void testIndexOf() {
    	  ArrayList list = new ArrayList();
          list.add("zero");
          list.add(null);
          list.add("two");
          list.add(null);
          list.add("three");
          System.out.println("test index : " + list.indexOf(null));
      }
}
