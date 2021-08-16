package com.dsalgms;

import java.util.Comparator;


/*
    BST - A binary tree data structure in which the at point in time the data is always sorted.

    insert, delete, search -> o(h) - where h = height of the tree.
    traversal - o(n)

    inOrder => { left, root, right }  => prints elements in ascending order.
    preOrder => { root, left, right }
    postOrder => { left, right, root }


    traverse => {right, root, left} Printing elements in descending order


 */
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
        Node t = minimum(root);
        if(t == null) return null;
        else return t.data;
    }

    private Node minimum(Node root) {
        Node t = root;
        if(t == null) return null;
        if(t.left == null) return t;
        while(t.left != null)
            t=t.left;
        return t;
    }

    //3. Maximum
    public T maximum() {
        Node t = maximum(root);
        if(t == null) return null;
        else return t.data;
    }

    private Node maximum(Node root) {
        Node t = root;
        if(t == null) return null;
        if(t.right == null) return t;
        while(t.right != null)
            t=t.right;
        return t;
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
        if(t.left != null){
            Node temp = maximum(t.left);
            if(temp == null) return null;
            else return temp.data;
        }
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
        if(t.right != null) {
            Node temp = minimum(t.right);
            if(temp == null) return null;
            else return temp.data;
        }
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
    public T delete(T data) {
        Node t = find(root, data);
        if(t == null) return null;
        //If its a leaf node.
        if(t.left == null && t.right == null) {
            if(root == t) {
                root = null;
                return data;
            }
            Node parent = t.parent;
            if(parent.left == t) parent.left = null;
            else parent.right = null;
            //Delete t.
            t.left = t.right = t.parent = null;
            t.data = null;
            t = null;
            return data;
        }

        //If left subtree is null
        if(t.left == null) {
            Node rightChild = t.right;
            Node parent = t.parent;
            rightChild.parent = parent;
            if(parent != null) {
                if(parent.left == t) parent.left = rightChild;
                else parent.right = rightChild;
            } else {
                root = rightChild;
            }
            t.parent = t.right = null;
            t = null;
            return data;
        }
        //If rightSubtree is null
        if(t.right == null) {
            Node leftChild = t.left;
            Node parent = t.parent;
            leftChild.parent = parent;
            if(parent != null) {
                if(parent.left == t) parent.left = leftChild;
                else parent.right = leftChild;
            } else {
                root = leftChild;
            }
            t.parent = t.left = null;
            t = null;
            return data;
        }

        //If both left and right subtree is not null
        Node min = minimum(t.right);
        Node minimumParent = min.parent;
        if(minimumParent.left == min)
            minimumParent.left = (min.right != null) ? min.right : null;
        else
            minimumParent.right = (min.right != null) ?min.right : null;

        min.parent = t.parent;
        min.right = t.right;
        if(t.right != null)
            t.right.parent = min;
        min.left = t.left;
        if(t.left != null)
            t.left.parent = min;

        if(root == t) root = min;
        else {
            Node parent = t.parent;
            if(parent.left == t) parent.left = min;
            else parent.right = min;
        }
        t.left = t.right = t.parent = null;
        t.data = null;
        t = null;
        return data;
    }

    //7. InOrder Traversal
    //Pattern => left, root, right
    public void printInOrder() {
        if(root == null) return;
        System.out.println();
        inOrderTraversal(root);
        System.out.println();
    }

    private void inOrderTraversal(Node root) {
        if(root.left != null)
            inOrderTraversal(root.left);
        System.out.print(" "+root.data);
        if(root.right != null)
            inOrderTraversal(root.right);
    }

    //8. PreOrder Traversal
    //Pattern => root, left, right
    public void printPreOrder() {
        if(root == null) return;
        System.out.println();
        preOrderTraversal(root);
        System.out.println();
    }

    private void preOrderTraversal(Node root) {
        System.out.print(" "+root.data);
        if(root.left != null)
            preOrderTraversal(root.left);
        if(root.right != null)
            preOrderTraversal(root.right);
    }

    //9. PostOrder Traversal
    //Pattern => left, right, root
    public void printPostOrder() {
        if(root == null) return;
        System.out.println();
        postOrderTraversal(root);
        System.out.println();
    }

    private void postOrderTraversal(Node root) {
        if(root.left != null)
            postOrderTraversal(root.left);
        if(root.right != null)
            postOrderTraversal(root.right);
        System.out.print(" "+root.data);
    }

    public void printDescendingOrder() {
        if(root == null) return;
        System.out.println();
        descendingOrder(root);
        System.out.println();
    }

    private void descendingOrder(Node root) {
        if(root.right != null)
            descendingOrder(root.right);
        System.out.print(" "+root.data);
        if(root.left != null)
            descendingOrder(root.left);
    }
}
