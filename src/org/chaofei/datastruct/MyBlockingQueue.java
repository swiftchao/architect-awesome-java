package org.chaofei.datastruct;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyBlockingQueue {
	/**
	 * 定义装苹果的篮子
	 */
	public static class Basket {
		// 篮子，能够容纳3个苹果
		BlockingQueue<String> basket = new ArrayBlockingQueue<String>(10);

		// 生产苹果，放入篮子
		public void produce() throws InterruptedException {
			basket.put("An apple");
		}

		// 消费苹果，从篮子中 取走
		public String consume() throws InterruptedException {
			String apple = basket.take();
			return apple;
		}

		public int getAppleNumber() {
			return basket.size();
		}
	}

	public static void testBasket() {
		final Basket basket = new Basket();
		class Producer implements Runnable {
			@Override
			public void run() {
				try {
					while (true) {
						// 生产苹果
						System.out.println("生产者准备生产苹果: " + System.currentTimeMillis());
						basket.produce();
						System.out.println("生产者生产苹果完毕: " + System.currentTimeMillis());
						System.out.println("生产完后有苹果: " + basket.getAppleNumber() + "个");
						// 休眠300ms
						Thread.sleep(300);
					}
				} catch (InterruptedException e) {
				}
			}
		}
		
		class Consumer implements Runnable {
			@Override
			public void run() {
				while (true) {
					try {
						System.out.println("消费者准备消费苹果: " + System.currentTimeMillis());
						basket.consume();
						System.out.println("消费者消费苹果完毕: " + System.currentTimeMillis());
						System.out.println("消费完后有苹果: " + basket.getAppleNumber());
						Thread.sleep(309);
					} catch (InterruptedException e) {
					}
				}
			}
		}
		
		ExecutorService service = Executors.newCachedThreadPool();
		Producer producer = new Producer();
		Consumer consumer = new Consumer();
		service.submit(producer);
		service.submit(consumer);
		
		// 程序运行10s后，所有任务停止
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
		}
		service.shutdownNow();
	}
}
