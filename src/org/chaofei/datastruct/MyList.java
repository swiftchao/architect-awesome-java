package org.chaofei.datastruct;

import java.util.ArrayList;

public class MyList {

      /**
       * 输出一个int的二进制数
       * @param num
       */
      public static String printInfo(int num){
    	  String binaryString = Integer.toBinaryString(num);
          System.out.println(num + " " + binaryString);
          return binaryString;
      }
      
      public static int getNullIndexOf() {
    	  ArrayList<String> list = new ArrayList<String>();
          list.add("zero");
          list.add(null);
          list.add("two");
          list.add(null);
          list.add("three");
          int resultIndex = list.indexOf(null);
          System.out.println("test index : " + resultIndex);
          return resultIndex;
      }
}
