package com.comp.prog;

import java.util.LinkedList;
import java.util.List;

public class BlockingQueue {

	private List list = new LinkedList<>();

	private int limit = 10;

	BlockingQueue(int limit) {
		this.limit = limit;
	}

	public synchronized void enqueue(Object item) throws InterruptedException {
		while (list.size() == limit)
			wait();
		if (list.size() == 0)
			notifyAll();
		list.add(item);
	}

	public synchronized void dequeue() throws InterruptedException {
		if (list.size() == 0)
			wait();
		if (list.size() == limit)
			notifyAll();
		list.remove(0);
	}
}
