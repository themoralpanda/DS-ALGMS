package com.dsalgms;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Stack;

public class DGraph<T> implements GraphAPI<T> {

    private Map<T, HashSet<T>> dg;

    public DGraph() {
        dg = new HashMap<>();
    }

    @Override
    public void add(T node) {
        if(!ifExists(node))
            dg.put(node, new HashSet<>());
    }

    @Override
    public T remove(T node) {
        if(node == null || !ifExists(node) ) throw new IllegalArgumentException();
        for(T el: dg.keySet()) {
            dg.get(el).remove(node);
        }
        dg.remove(node);
        return node;
    }

    @Override
    public void addEdge(T n1, T n2) {
        if(n1 == null || n2 == null || !ifExists(n1) || !ifExists(n2)) throw new IllegalArgumentException();
        dg.get(n1).add(n2);
    }

    @Override
    public void removeEdge(T n1, T n2) {
        if(n1 == null || n2 == null || !ifExists(n1) || !ifExists(n2)) throw new IllegalArgumentException();
        dg.get(n1).remove(n2);
    }

    @Override
    public Iterable<T> adj(T node) {
        if(node == null || !ifExists(node) ) throw new IllegalArgumentException();
        return dg.get(node);
    }

    @Override
    public int degree(T node) {
        if(node == null || !ifExists(node)) throw new IllegalArgumentException();
        return inDegree(node) + outDegree(node);
    }

    private int inDegree(T node) {
        int count = 0;
        for(T el: dg.keySet()) {
            if(dg.get(el).contains(node))
                count++;
        }
        return count;
    }

    private int outDegree(T node) {
        return dg.get(node).size();
    }

    @Override
    public boolean isConnected(T n1, T n2) {
        if(n1 == null || n2 == null || !ifExists(n1) || !ifExists(n2)) throw new IllegalArgumentException();
        return dg.get(n1).contains(n2);
    }

    private boolean ifExists(T node) {
        return dg.containsKey(node);
    }

    public void bfsTraversal(T node) {
        if(node == null || !ifExists(node)) throw new IllegalArgumentException();
        Map<T, Boolean> visitedMap = new HashMap<>();
        Queue<T> queue = new LinkedList<>();

        queue.add(node);
        while(!queue.isEmpty()) {
            T curr = queue.poll();
            if(!visitedMap.containsKey(curr)) {
                visitedMap.put(curr, true);
                System.out.print(curr + ", ");
                for(T el: adj(curr)) {
                    if(!visitedMap.containsKey(el)) {
                        queue.add(el);
                    }
                }
            }
        }
    }

    public void dfsTraversal(T node) {
        if(node == null || !ifExists(node)) throw new IllegalArgumentException();
        System.out.println();
        dfsTraversal(node, new HashMap<>());
    }

    private void dfsTraversal(T node, Map<T , Boolean> visitedMap) {
        if(!visitedMap.containsKey(node)) {
            visitedMap.put(node, true);
            System.out.print(node +", ");
            for(T el : adj(node)) {
                if(!visitedMap.containsKey(el))
                    dfsTraversal(el, visitedMap);
            }
        }
    }

    public void topologicalSort() {
        HashMap<T, Boolean> visitedMap = new HashMap<>();
        Stack<T> stack = new Stack<>();
        for(T el: dg.keySet()) {
            if(!visitedMap.containsKey(el))
                reversePostOrder(el, visitedMap, stack);
        }

        System.out.println();
        while(!stack.isEmpty()){
            System.out.print(stack.pop() +", ");
        }
    }

    private void reversePostOrder(T node, HashMap<T, Boolean> visitedMap, Stack<T> postOrder) {
        if(!visitedMap.containsKey(node)) {
            visitedMap.put(node, true);
            for(T el: adj(node)) {
                if(!visitedMap.containsKey(el))
                    reversePostOrder(el, visitedMap, postOrder);
            }
            postOrder.push(node);
        }
    }

    private void hasCycles() {
        HashMap<T, Boolean> visitedMap = new HashMap<>();
        Stack<T> stack;
        for(T el : dg.keySet()) {
            if(!visitedMap.containsKey(el))
                stack = new Stack<>();
                dfsWithCyclicCircuitBreaker(el, visitedMap, stack);
        }
    }

    private boolean dfsWithCyclicCircuitBreaker(T node, HashMap<T, Boolean> visitedMap, Stack<T> stack) {
        if(!visitedMap.containsKey(node)) {
            visitedMap.put(node, true);
            stack.push(node);
            for(T el: adj(node)) {
                if(!visitedMap.containsKey(el)) {
                    for(T e : stack) {
                        if(isConnected(el, e)) return false;
                    }
                    dfsWithCyclicCircuitBreaker(el, visitedMap, stack);
                }
            }
        }
    }
}
