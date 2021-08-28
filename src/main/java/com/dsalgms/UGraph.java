package com.dsalgms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class UGraph<T> implements GraphAPI<T> {

    private Map<T, HashSet<T>> ug;

    public UGraph() {
        ug = new HashMap<>();
    }

    @Override
    public void add(T node) {
        if(node != null && !ifNodeExists(node))
            ug.put(node, new HashSet<>());
    }

    @Override
    public T remove(T node) {
        if(!ifNodeExists(node)) throw new IllegalArgumentException();
        for (T adjacentNode: ug.get(node)) {
            ug.get(adjacentNode).remove(node);
        }
        ug.get(node).clear();
        ug.remove(node);
        return node;
    }

    @Override
    public void addEdge(T n1, T n2) {
        if(!ifNodeExists(n1) || !ifNodeExists(n2)) throw new IllegalArgumentException("Nodes does not exist");
        if(!isConnected(n1, n2)) {
            ug.get(n1).add(n2);
            ug.get(n2).add(n1);
        }
    }

    @Override
    public void removeEdge(T n1, T n2) {
        if(!ifNodeExists(n1) || !ifNodeExists(n2)) throw new IllegalArgumentException("Nodes does not exist");
        if(isConnected(n1, n2)) {
            ug.get(n1).remove(n2);
            ug.get(n2).remove(n1);
        }
    }

    @Override
    public Iterable<T> adj(T node) {
       if(!ifNodeExists(node)) throw new IllegalArgumentException("Node does not exist");
        HashSet<T> s = ug.get(node);
        return s;
    }

    @Override
    public int degree(T node) {
        if(!ifNodeExists(node)) throw new IllegalArgumentException();
        return ug.get(node).size();
    }

    @Override
    public boolean isConnected(T n1, T n2) {
        if(!ifNodeExists(n1) || !ifNodeExists(n2)) throw new IllegalArgumentException("Nodes does not exist");
        for (T el:ug.get(n1)) {
            if(el.equals(n2)) return true;
        }
        return false;
    }

    public void bfsTraversal(T s) {
        Map<T, Boolean> visitedMap = new HashMap<>();
        Queue<T> queue = new LinkedList<>();
        if(s == null || !ifNodeExists(s)) throw new IllegalArgumentException();

        queue.add(s);
        visitedMap.put(s, true);
        while(!queue.isEmpty()) {
            T curr = queue.remove();
            System.out.print(curr + ", ");
            for (T el: adj(curr)) {
                if(!visitedMap.containsKey(el)) {
                    visitedMap.put(el, true);
                    queue.add(el);
                }
            }
        }
        System.out.println();
    }

    public void dfsTraversal(T s) {
        dfsTraversal(s, new HashMap<>());
    }

    private void dfsTraversal(T s, Map<T, Boolean> visitedMap) {
        if(s == null || !ifNodeExists(s)) throw new IllegalArgumentException();

        if(!visitedMap.containsKey(s)) {
            visitedMap.put(s,  true);
            System.out.print(s + ", ");
            for(T el: adj(s)) {
                dfsTraversal(el, visitedMap);
            }
        }
    }

    public void dfsWithStack(T s) {
        if(s == null || !ifNodeExists(s)) throw new IllegalArgumentException();

        HashMap<T, Boolean> visitedNodes = new HashMap<>();
        Stack<T> stack = new Stack<>();

        stack.push(s);
        while(!stack.isEmpty()) {
            T curr = stack.pop();
            visitedNodes.put(curr, true);
            System.out.print(curr + ", ");
            for (T el : adj(curr)) {
               if(!visitedNodes.containsKey(el)) {
                   if(!stack.contains(el))
                    stack.push(el);
               }
            }
        }
        System.out.println();
    }

    private boolean ifNodeExists(T node) {
        return ug.containsKey(node);
    }
}
