package com.dsalgms;

import java.util.Comparator;

public class BinarySearchTree<T> {
    private class Node {
        T data;
        Node parent, left, right;

        public Node(T data) {
            this.data = data;
            parent = left = right = null;
        }
    }

    private Node root;
    private final Comparator<T> comparator;

    public BinarySearchTree(Comparator<T> c) {
        this.comparator = c;
    }

    //1. Insert
    public void insert(T data) {
        if(root == null) {
            Node n = new Node(data);
            root = n;
            n.parent = n.left = n.right = null;
            return;
        }
        insert(root, data);
    }

    private void insert(Node root, T data) {
        int c = comparator.compare(root.data, data);
        if(c>=0) {
            if(root.left == null) {
                Node n = new Node(data);
                n.right = n.left = null;
                n.parent = root;
                root.left = n;
                return;
            }
            insert(root.left, data);
        }
        else if(c<0) {
            if(root.right == null) {
                Node n = new Node(data);
                n.right = n.left = null;
                n.parent = root;
                root.right = n;
                return;
            }
            insert(root.right, data);
        }
    }

    //2. Minimum
    public T minimum() {
        return minimum(root);
    }

    private T minimum(Node root) {
        Node t = root;
        if(t == null) return null;
        if(t.left == null) return t.data;
        while(t.left != null)
            t=t.left;
        return t.data;
    }

    //3. Maximum
    public T maximum() {
        return maximum(root);
    }

    private T maximum(Node root) {
        Node t = root;
        if(t == null) return null;
        if(t.right == null) return t.data;
        while(t.right != null)
            t=t.right;
        return t.data;
    }

    public T search(T data) {
        return search(root, data);
    }

    private T search(Node root, T data) {
        Node t = root;
        if(t == null) return null;
        int c = comparator.compare(data, t.data);
        if(c < 0)
            return (t.left != null) ? search(t.left, data) : null;
        else if(c > 0)
            return (t.right != null) ? search(t.right, data) : null;
        else return t.data;
    }

    private Node find(Node root, T data) {
        Node t = root;
        if(t == null) return null;
        int c = comparator.compare(data, t.data);
        if(c < 0)
            return (t.left != null) ? find(t.left, data) : null;
        else if(c > 0)
            return (t.right != null) ? find(t.right, data) : null;
        else return t;
    }


    //4. Predecessor
    public T predecessor(T data) {
        Node t = find(root, data);
        if(t == null) return null;
        if(t.left != null)
            return maximum(t.left);
        else {
            //travel back via parent pointer until a node less than data
            Node p = t;
            while(p.parent != null) {
                p = p.parent;
                int c = comparator.compare(p.data, data);
                if(c < 0)
                    return p.data;
            }
            return null;
        }
    }

    //5. Successor
    public T successor(T data) {
        Node t = find(root, data);
        if(t == null) return null;
        if(t.right != null)
            return minimum(t.right);
        else {
            //travel back via parent pointer until a node less than data
            Node p = t;
            while(p.parent != null) {
                p = p.parent;
                int c = comparator.compare(p.data, data);
                if(c > 0)
                    return p.data;
            }
            return null;
        }
    }

    //6. Delete
    //7. InOrder Traversal
    //8. PreOrder Traversal
    //9. PostOrder Traversal
}
