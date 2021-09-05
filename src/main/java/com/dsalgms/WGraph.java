package com.dsalgms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WGraph<T, W> implements WeightedGraphAPI<T, W> {

    public class Edge implements Comparable<Edge>{
        T a, b;
        W w;

        public Edge(T a, T b, W w) {
            this.a = a;
            this.b = b;
            this.w = w;
        }

        @Override
        public int compareTo(Edge o) {
            int w1 = (Integer) this.w;
            int w2 = (Integer) o.w;
            if(w1 < w2) return -1;
            else if(w1 > w2) return 1;
            else return 0;
        }

        @Override
        public String toString() {
            return a + " -> "+b;
        }
    }

    private List<Edge> edges;

    private HashMap<T, HashMap<T, W>> wg;

    public WGraph() {
        wg = new HashMap<>();
        edges = new ArrayList<>();
    }

    @Override
    public void add(T node) {
        if(node != null && !exists(node)) {
            wg.put(node, new HashMap<>());
        }
    }

    private boolean exists(T node) {
        return wg.containsKey(node);
    }

    @Override
    public T remove(T node) {
        return null;
    }

    @Override
    public void addEdge(T n1, T n2) {
        addEdge(n1, n2, null);
    }

    @Override
    public void addEdge(T n1, T n2, W w) {
        if(n1 == null || n2 == null || w == null || !exists(n1) || !exists(n2)) {
            throw new IllegalArgumentException();
        }
        if(!isConnected(n1, n2)) {
            wg.get(n1).put(n2, w);
            wg.get(n2).put(n1, w);
            edges.add(new Edge(n1, n2, w));
        }
    }

    @Override
    public void removeEdge(T n1, T n2) {
        if(n1 == null || n2 == null || !exists(n1) || !exists(n2)) {
            throw new IllegalArgumentException();
        }
        if(isConnected(n1, n2)) {
            wg.get(n1).remove(n2);
            wg.get(n2).remove(n1);
        }
    }

    @Override
    public Iterable<T> adj(T node) {
        if(node == null || !exists(node)) {
            throw new IllegalArgumentException();
        }
        return wg.get(node).keySet();
    }

    @Override
    public int degree(T node) {
        if(node == null || !exists(node)) {
            throw new IllegalArgumentException();
        }
        return wg.get(node).size();
    }

    @Override
    public boolean isConnected(T n1, T n2) {
        return wg.get(n1).containsKey(n2);
    }

    @Override
    public int size() {
        return wg.size();
    }

    @Override
    public List<?> edges() {
        return edges;
    }
}
