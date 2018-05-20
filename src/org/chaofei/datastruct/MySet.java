package org.chaofei.datastruct;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class MySet {
	public static void	traversalHashSetByIteratorOfString() {
		// set 集合存和取的顺序不一致
		HashSet<String> hashSet = new HashSet<String>();
		hashSet.add("世界军事");
		hashSet.add("兵器知识");
		hashSet.add("舰船知识");
		hashSet.add("汉和防务");

		// 返回此set中的元素的数量
		System.out.println(hashSet.size());
		// 如果此set尚未包含指定元素,则返回true
		boolean add = hashSet.add("世界军事"); // false
		System.out.println(add);
		System.out.println(hashSet.size());
		System.out.println(hashSet);
		// [舰船知识, 世界军事, 兵器知识]
		Iterator<String> it = hashSet.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	public static void traversalHashSetByIteratorOfPerson() {
		// set 集合存和取的顺序不一致
		HashSet<Person> hashSet = new HashSet<Person>();
		hashSet.add(new Person("jack", 20));
		hashSet.add(new Person("rose", 20));
		hashSet.add(new Person("hmm", 20));
		hashSet.add(new Person("lilei", 20));

		// 返回此set中的元素的数量
		System.out.println(hashSet.size());
		// 如果此set尚未包含指定元素,则返回true
		boolean add = hashSet.add(new Person("jack", 20)); // false
		System.out.println(add);
		System.out.println(hashSet.size());
		System.out.println(hashSet);
		Iterator<Person> it = hashSet.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	public static void traversalTreeSetByIteratorOfString() {
		// set 集合存和取的顺序不一致
		TreeSet<String> ts = new TreeSet<String>();
		ts.add("ccc");
		ts.add("aaa");
		ts.add("ddd");
		ts.add("bbb");
		// 返回此set中的元素的数量
		System.out.println(ts.size());
		// 如果此set尚未包含指定元素,则返回true
		boolean add = ts.add("bbb"); // false
		System.out.println(add);
		System.out.println(ts.size());
		System.out.println(ts);
		Iterator<String> it = ts.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	public static void traversalTreeSetByIteratorOfPerson2() {
		// set 集合存和取的顺序不一致
		TreeSet<Person2> ts = new TreeSet<Person2>();
		ts.add(new Person2("aa", 20, "男"));
		ts.add(new Person2("bb", 18, "女"));
		ts.add(new Person2("cc", 17, "男"));
		ts.add(new Person2("dd", 17, "女"));
		ts.add(new Person2("dd", 15, "女"));

		// 返回此set中的元素的数量
		System.out.println(ts.size());
		// 如果此set尚未包含指定元素,则返回true
		boolean add = ts.add(new Person2("dd", 15, "女")); // false
		System.out.println(add);
		System.out.println(ts.size());
		System.out.println(ts);
		Iterator<Person2> it = ts.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

	public static void traversalTreeSetByIteratorOfBook() {
		// set 集合存和取的顺序不一致
		TreeSet<Book> ts = new TreeSet<Book>(new MyComparator());
		ts.add(new Book("think in java", 100));
		ts.add(new Book("java 核心技术", 75));
		ts.add(new Book("现代操作系统", 50));
		ts.add(new Book("java就业教程", 35));
		
		ts.add(new Book("ccc in java", 100));

		// 返回此set中的元素的数量
		System.out.println(ts.size());
		// 如果此set尚未包含指定元素,则返回true
		boolean add = ts.add(new Book("think in java", 100)); // false
		System.out.println(add);
		System.out.println(ts.size());
		System.out.println(ts);
		Iterator<Book> it = ts.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
	
	static class MyComparator implements Comparator<Object> {

		@Override
		public int compare(Object o1, Object o2) {
			Book b1 = (Book) o1;
			Book b2 = (Book) o2;
			System.out.println(b1 + " comparator " + b2);
			if (b1.getPrice() > b2.getPrice()) {
				return 1;
			}
			if (b1.getPrice() < b2.getPrice()) {
				return -1;
			}
			return b1.getName().compareTo(b2.getName());
		}
	}

	static class Person {
		private String name;
		private int age;

		public Person() {
			super();
		}

		public Person(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + age;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Person other = (Person) obj;
			if (age != other.age)
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Person [name=" + name + ", age=" + age + "]";
		}
	}

	static class Person2 implements Comparable<Object> {
		private String name;
		private int age;
		private String gender;

		public Person2() {
			super();
		}

		public Person2(String name, int age, String gender) {
			super();
			this.name = name;
			this.age = age;
			this.gender = gender;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + age;
			result = prime * result + ((gender == null) ? 0 : gender.hashCode());
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Person2 other = (Person2) obj;
			if (age != other.age)
				return false;
			if (gender == null) {
				if (other.gender != null)
					return false;
			} else if (!gender.equals(other.gender))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}

		public String getGender() {
			return gender;
		}

		public void setGender(String gender) {
			this.gender = gender;
		}

		@Override
		public String toString() {
			return "Person2 [name=" + name + ", age=" + age + ", gender=" + gender + "]";
		}

		@Override
		public int compareTo(Object o) {
			Person2 p = (Person2) o;
			System.out.println(this + " compareTo: " + p);
			if (this.age > p.age) {
				return 1;
			}
			if (this.age < p.age) {
				return -1;
			}
			return this.name.compareTo(p.name);
		}
	}

	static class Book {
		private String name;
		private double price;

		public Book() {
			super();
		}

		public Book(String name, double price) {
			super();
			this.name = name;
			this.price = price;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			long temp;
			temp = Double.doubleToLongBits(price);
			result = prime * result + (int) (temp ^ (temp >>> 32));
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Book other = (Book) obj;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Book [name=" + name + ", price=" + price + "]";
		}
	}
}
