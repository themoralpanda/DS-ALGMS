package com.dsalgms;

import java.util.Comparator;

public class RBTree<T> {
    public final boolean RED = true;
    public final boolean BLACK = false;

    private Node root;
    private Comparator<T> comparator;

    private class Node {
        public T data;
        public Node left, right, parent;
        public boolean color;

        public Node(T data) {
            this.data = data;
        }
    }

    public RBTree(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    public void insert(T data) {
        root = insert(root, data);
    }

    public T search(T data) {
        if(root == null) return null;
        else return search(root, data);
    }

    private T search(Node root, T data) {
        int c = comparator.compare(data, root.data);
        if(c<0) {
            if(root.left != null) return search(root.left, data);
            else return null;
        } else if (c >0){
            if(root.right != null) return search(root.right, data);
            else return null;
        } else {
            return data;
        }
    }


    /**
     RB Tree invariants need to validated after every insert.
     The following are the invariants needs to hold.

     1. No Right leaning red link.
     2. No consecutive Red links.
     3. Tree should always be black balanced. i.e No of black nodes,
     in paths from root to every leaf node should always be same.

     @param x - Pointer to the newly inserted node.
     */
    private Node insert(Node h, T data) {
        if(h == null) {
            Node n = new Node(data);
            n.left = n.right = null;
            n.color = RED;
            if(root == null) {n.color = BLACK;}
            return n;
        }
        int c = comparator.compare(data, h.data);
        if(c<0) {
            Node t = insert(h.left, data);
            h.left = t;
            t.parent = h;
        } else if(c >0) {
            Node t = insert(h.right, data);
            h.right = t;
            t.parent = h;
        }
        if(isRED(h.right) && !isRED(h.left)) h = rotateLeft(h);
        if(isRED(h.left) && isRED(h.left.left)) h = rotateRight(h);
        if(isRED(h.left) && isRED(h.right)) flipColors(h);
        return h;
    }

    private Node flipColors(Node h) {
        h.left.color = h.right.color = BLACK;
        h.color = RED;
        if(h == root) h.color = BLACK;
        return h;
    }

    private Node rotateLeft(Node h) {
        Node parent = h.parent;
        Node x = h.right;
        h.right = x.left;

        x.left = h;
        x.color = h.color;
        h.color = RED;

        if(parent != null) parent.left = x;
        x.parent = parent;
        h.parent = x;
        return x;
    }

    private Node rotateRight(Node h) {
        Node parent = h.parent;
        Node x = h.left;
        h.left = x.right;
        x.right = h;

        if(parent != null) parent.left = x;
        x.parent = parent;
        h.parent = x;

        h.color = x.color;
        return x;
    }

    private boolean isRED(Node x) {
        if(x == null) return false;
        else return x.color == RED;
    }


}
