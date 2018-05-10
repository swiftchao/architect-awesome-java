package org.chaofei.datastruct;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
//		testTraversal();
		testMapSort();
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
	
	public static void testMapSort() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("a", "c");
		map.put("b", "b");
		map.put("c", "a");
		List<Map.Entry<String, String>> list = new ArrayList<Map.Entry<String, String>>(map.entrySet());
		// 通过比较器实现比较排序
		Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
			@Override
			public int compare(Entry<String, String> o1, Entry<String, String> o2) {
				return o1.getKey().compareTo(o2.getKey());
			}
		});
		
		for (Map.Entry<String, String> mapping : list) {
			System.out.println(mapping.getKey() + " : " + mapping.getValue());
		}
		
		System.out.println("==============================");
		// TreeMap默认按key进行升序排序，如果想改变默认的顺序，可以使用比较器:
		map = new TreeMap<String, String>(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});
		map.put("a", "c");
		map.put("b", "b");
		map.put("c", "a");
		
		for (String key : map.keySet()) {
			System.out.println(key + " : " + map.get(key));
		}
		
		System.out.println("==============================");
		// value排序(通用)
		Map<String, String> map2 = new TreeMap<String, String>();
		map2.put("f", "f");
		map2.put("a", "c");
		map2.put("b", "b");
		map2.put("c", "a");
		map2.put("d", "d");
		// 通过ArrayList构造函数把map.entrySet()转换成list
		List<Map.Entry<String, String>> list2 = new ArrayList<Map.Entry<String, String>>(map2.entrySet());
		Collections.sort(list2, new Comparator<Map.Entry<String, String>>() {
			@Override
			public int compare(Entry<String, String> o1, Entry<String, String> o2) {
				// 升序
				return o1.getValue().compareTo(o2.getValue());
//				return o2.getValue().compareTo(o1.getValue());
			}
		});
		Iterator<Entry<String, String>> iterator = list2.iterator();
		Map.Entry<String, String> entry;
		while (iterator.hasNext()) {
			entry = iterator.next();
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		Map<String, String> map3 = new TreeMap<String, String>();
		map3.put("f", "f");
		map3.put("a", "c");
		map3.put("b", "b");
		map3.put("c", "a");
		map3.put("d", "d");
		map3.put("e", "e");
 
		System.out.println("==============================");
        // 通过ArrayList构造函数把map.entrySet()转换成list
        List<Map.Entry<String, String>> list3 = new ArrayList<Map.Entry<String, String>>(map3.entrySet());
        Comparator valueComparator =  new Comparator<Map.Entry<String, String>>() {
            public int compare(Map.Entry<String, String> mapping1, Map.Entry<String, String> mapping2) {
//                return mapping1.getValue().compareTo(mapping2.getValue());
            	//降序
            	return mapping2.getValue().compareTo(mapping1.getValue());
            }
        };
        // 通过比较器实现比较排序
        Collections.sort(list3, valueComparator);
 
        for (Map.Entry<String, String> entry3 : list3) {
            System.out.println(entry3.getKey() + " ：" + entry3.getValue());
        }
		
	}
}
