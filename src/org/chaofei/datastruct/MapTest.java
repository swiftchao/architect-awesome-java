package org.chaofei.datastruct;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;
import java.util.TreeMap;
import java.util.UUID;

public class MapTest {
	static int hashMapW = 0;
	static int hashMapR = 0;
    static int linkMapW = 0;
    static int linkMapR = 0;
    static int treeMapW = 0;
    static int treeMapR = 0;
    static int hashTableW = 0;
    static int hashTableR = 0;
	
	public static void main(String[] args) {
//		testAllMapRW();
//		testInitMap();
		testTraversal();
	}

	private static void testAllMapRW() {
		for (int i = 0; i < 10; ++i) {
			MapTest map = new MapTest();
			map.testMapRW(10 * 10000);
			System.out.println();
		}
		System.out.println("hashMapW = " + hashMapW / 10);
		System.out.println("hashMapR = " + hashMapR / 10);
        System.out.println("linkMapW = " + linkMapW / 10);
        System.out.println("linkMapR = " + linkMapR / 10);
        System.out.println("treeMapW = " + treeMapW / 10);
        System.out.println("treeMapR = " + treeMapR / 10);
        System.out.println("hashTableW = " + hashTableW / 10);
        System.out.println("hashTableR = " + hashTableR / 10);
	}
	
	public void testMapRW(int size) {
		int index;
		Random random = new Random();
		String[] key = new String[size];
		
		// HashMap插入
		Map<String, String> map = new HashMap<String, String>();
		long start = System.currentTimeMillis();
		for (int i = 0; i < size; ++i) {
			key[i] = UUID.randomUUID().toString();
		}
		long end = System.currentTimeMillis();
		hashMapW += (end - start);
		System.out.println("HashMap插入耗时 = " + (end - start) + " ms");
		
		// HashMap 读取
		start = System.currentTimeMillis();
		for (int i = 0; i < size; ++i) {
			index = random.nextInt(size);
			map.get(key[index]);
		}
		end = System.currentTimeMillis();
		hashMapR += (end - start);
		System.out.println("HashMap读取耗时 = " + (end - start) + " ms");
		
		 // LinkedHashMap 插入
        map = new LinkedHashMap<String, String>();
        start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            key[i] = UUID.randomUUID().toString();
            map.put(key[i], UUID.randomUUID().toString());
        }
        end = System.currentTimeMillis();
        linkMapW += (end - start);
        System.out.println("LinkedHashMap插入耗时 = " + (end - start) + " ms");
 
        // LinkedHashMap 读取
        start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            index = random.nextInt(size);
            map.get(key[index]);
        }
        end = System.currentTimeMillis();
        linkMapR += (end - start);
        System.out.println("LinkedHashMap读取耗时 = " + (end - start) + " ms");
 
        // TreeMap 插入
        key = new String[size];
        map = new TreeMap<String, String>();
        start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            key[i] = UUID.randomUUID().toString();
            map.put(key[i], UUID.randomUUID().toString());
        }
        end = System.currentTimeMillis();
        treeMapW += (end - start);
        System.out.println("TreeMap插入耗时 = " + (end - start) + " ms");
 
        // TreeMap 读取
        start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            index = random.nextInt(size);
            map.get(key[index]);
        }
        end = System.currentTimeMillis();
        treeMapR += (end - start);
        System.out.println("TreeMap读取耗时 = " + (end - start) + " ms");
 
        // Hashtable 插入
        key = new String[size];
        map = new Hashtable<String, String>();
        start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            key[i] = UUID.randomUUID().toString();
            map.put(key[i], UUID.randomUUID().toString());
        }
        end = System.currentTimeMillis();
        hashTableW += (end - start);
        System.out.println("Hashtable插入耗时 = " + (end - start) + " ms");
 
        // Hashtable 读取
        start = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            index = random.nextInt(size);
            map.get(key[index]);
        }
        end = System.currentTimeMillis();
        hashTableR += (end - start);
        System.out.println("Hashtable读取耗时 = " + (end - start) + " ms");
	}
	
	public static void testInitMap() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("key1", "value1");
		map.put("key2", "value2");
		// 使用keySet()遍历
		for (String key : map.keySet()) {
		    System.out.println(key + " ：" + map.get(key));
		}
		// 使用entrySet()遍历
		for (Map.Entry<String, String> entry : map.entrySet()) {
			System.out.println("key = " + entry.getKey() + " value = " + entry.getValue());
		}
		
		Iterator<Map.Entry<String, String>> iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Map.Entry<String, String> entry = iterator.next();
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}
	
	public static void testTraversal() {
		// 初始化,10w次赋值
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < 100000; ++i) {
			map.put(i, i);
		}
		
		/** 增强for循环,keySet迭代 */
		long start = System.currentTimeMillis();
		for (Integer key : map.keySet()) {
			map.get(key);
		}
		long end = System.currentTimeMillis();
		System.out.println("增强for循环,keySet迭代 -> " + (end - start) + " ms");
		
		/**增强for循环,entrySet迭代*/
		start = System.currentTimeMillis();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			entry.getKey();
			entry.getValue();
		}
		end = System.currentTimeMillis();
		System.out.println("增强for循环,entrySet迭代 -> " + (end - start) + " ms");
		
		/**迭代器,keySet迭代*/
		start = System.currentTimeMillis();
		Iterator<Integer> iterator = map.keySet().iterator();
		Integer key;
		while (iterator.hasNext()) {
			key = iterator.next();
			map.get(key);
		}
		end = System.currentTimeMillis();
		System.out.println("迭代器,keySet迭代 -> " + (end - start) + " ms");
		
		/**迭代器,entrySet迭代*/
		start = System.currentTimeMillis();
		Iterator<Map.Entry<Integer, Integer>> iterator1 = map.entrySet().iterator();
		Map.Entry<Integer, Integer> entry;
		while (iterator1.hasNext()) {
			entry = iterator1.next();
			entry.getKey();
			entry.getValue();
		}
		end = System.currentTimeMillis();
		System.out.println("迭代器,entrySet迭代 -> " + (end - start) + " ms");
	}
}
