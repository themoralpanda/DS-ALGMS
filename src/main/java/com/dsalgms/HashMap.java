package com.dsalgms;

public class HashMap<K,V> {
    private class Node {
        private K key;
        private V value;
        private Node next;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    private Object[] ds;
    private long totalNumberOfElements;

    public HashMap() {
        this(100);
    }

    public HashMap(int n) {
        totalNumberOfElements = 0;
        ds = new Object[n];
        for(int i=0;i<n;i++) {
            ds[i] = null;
        }
    }

    public void put(K key, V value) {
        int pos = pos(key);
        if(!exists(key)) {
            Node n = new Node(key, value);
            n.next = null;
            if(ds[pos] == null) {
                ds[pos] = n;
            } else {
                Node t = (Node)ds[pos];
                while(t.next != null)
                    t = t.next;
                t.next = n;
            }
            totalNumberOfElements++;
        } else {
            Node t = (Node) ds[pos];
            while(t.next != null) {
                if(t.key.equals(key))
                    t.value = value;
            }
        }
    }

    public V get(K key) {
        int pos = pos(key);
        if(ds[pos] == null)
            return null;
        Node t = (Node) ds[pos];
        while(t.next != null) {
            if(t.key.equals(key))
                return t.value;
            t = t.next;
        }
        return t.key.equals(key) ? t.value : null;
    }

    public long size() {
        return totalNumberOfElements;
    }

    public V delete(K key) {
        int pos = pos(key);
        Node head = (Node) ds[pos];
        if(head == null)
            return null;
        if (head.key.equals(key)) {
            Node temp = head;
            V val = temp.value;
            head = (temp.next != null) ? temp.next : null;
            ds[pos] = head;
            temp = null;
            totalNumberOfElements--;
            return val;
        }
        Node curr  = head.next,prev = head;
        while(curr.next != null) {
            if(curr.key.equals(key)) {
                V val = curr.value;
                prev.next = curr.next;
                curr = null;
                totalNumberOfElements--;
                return val;
            }
            prev = curr;
            curr = curr.next;
        }
        return null;
    }

    private boolean exists(K key) {
        return get(key) != null;
    }

    private int pos(K key) {
        return Math.abs(key.hashCode() % ds.length);
    }

}
