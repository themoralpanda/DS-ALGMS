package com.dsalgms;

import java.util.EmptyStackException;
import java.util.Iterator;

public class QueueWithLinkedList<T> implements Iterable<T> {

    public class Node {
        public T data;
        public Node next;

        public Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node head;
    public Node tail;

    public QueueWithLinkedList() {
        head = tail = null;
    }

    public void enqueue(T el) {
        Node n = new Node(el);
        if(head == null && tail == null) {
            n.next = null;
            head = n;
            tail = n;
        } else {
            tail.next = n;
            tail = tail.next;
        }
    }

    public T dequeue() throws EmptyStackException {
        if(head == null) {
            throw new EmptyStackException();
        }
        Node temp = head;
        head = head.next;
        temp.next = null;
        return temp.data;
    }

    @Override
    public Iterator<T> iterator() {
        return new QueueListIterator();
    }

    private class QueueListIterator implements Iterator<T> {
        Node current;

        public QueueListIterator() {
            current = head;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            Node n = current;
            current = current.next;
            return n.data;
        }
    }
}
