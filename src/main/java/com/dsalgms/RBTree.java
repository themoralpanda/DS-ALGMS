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

    }

    public void insert(T data) {
        if(root != null) insert(root, data);
        //Create root
        Node n = new Node(data);
        n.left = n.right = n.parent = null;
        //Root node is always black.
        n.color = BLACK;
        this.root = n;
    }

    private void insert(Node root, T data) {
        int c = comparator.compare(data, root.data);
        if(c<0) {
            if(root.left != null) insert(root.left, data);
            else {
                Node n = new Node(data);
                n.left = n.right = null;
                n.parent = root;
                n.color = RED;
                root.left = n;
                validateRBConstraints(n);
            }
        } else if(c >0) {

        } else {

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
    private void validateRBConstraints(Node x) {
        Node parent = x.parent;
        Node leftChild = parent.left;


    }


    public Node flipColors(Node h) {
        return null;
    }

    public Node rotateLeft(Node h) {
        return null;
    }

    public Node rotateRight(Node h) {
        return null;
    }

    private boolean isRED(Node x) {
        return x.color == RED;
    }
}
