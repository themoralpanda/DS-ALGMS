package com.dsalgms;

import java.util.EmptyStackException;
import java.util.Iterator;

public class StackWithLinkedList<T> implements Iterable<T>{

	private class Node {
		public T data;
		public Node next;

		public Node(T n) {
			this.data = n;
			this.next = null;
		}

	}

	private Node head;

	public StackWithLinkedList() {
		head = null;
	}

	public void push(T a) {
		if(head == null) {
			Node n = new Node(a);
			n.next = null;
			head = n;
		} else {
			Node temp = head;
			Node n = new Node(a);
			n.next = temp;
			head = n;
		}
	}

	public T pop() {
		if(head != null) {
			Node n = head;
			head = head.next;
			return n.data;
		}
		throw new EmptyStackException();
    }

	@Override
	public Iterator<T> iterator() {
		return new StackIterator();
	}

	private class StackIterator implements Iterator<T> {
		private Node current;

		public StackIterator() {
			this.current = head;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public T next() {
			Node temp = current;
			current = current.next;
			temp.next = null;
			return temp.data;
		}
	}
}
