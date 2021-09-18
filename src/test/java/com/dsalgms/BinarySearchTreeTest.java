package com.dsalgms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinarySearchTreeTest {

    @Test
    public void testInsert() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>(Integer::compareTo);
        bst.insert(2);
        bst.insert(10);
        bst.insert(7);
        bst.insert(8);

        bst.insert(5);
        bst.insert(6);
        bst.insert(4);
        bst.insert(3);
        bst.insert(-1);
        System.out.println();

        Assertions.assertEquals(2, bst.search(2));
        Assertions.assertEquals(-1, bst.search(-1));
        Assertions.assertEquals(null, bst.search(-2));
        Assertions.assertEquals(6, bst.search(6));
        Assertions.assertEquals(null, bst.search(21));
        Assertions.assertEquals(null, bst.search(25));



        Assertions.assertEquals(-1, bst.predecessor(2));
        Assertions.assertEquals(8, bst.predecessor(10));
        Assertions.assertEquals(4, bst.predecessor(5));
        Assertions.assertEquals(2, bst.predecessor(3));
        Assertions.assertEquals(5, bst.predecessor(6));
        Assertions.assertEquals(null, bst.predecessor(25));
        Assertions.assertEquals(null, bst.predecessor(-1));

        Assertions.assertEquals(3, bst.successor(2));
        Assertions.assertEquals(null, bst.successor(10));
        Assertions.assertEquals(6, bst.successor(5));
        Assertions.assertEquals(7, bst.successor(6));
        Assertions.assertEquals(8, bst.successor(7));
        Assertions.assertEquals(10, bst.successor(8));
        Assertions.assertEquals(null, bst.successor(80));

        bst.printInOrder();
        bst.printPreOrder();
        bst.printPostOrder();
        bst.printDescendingOrder();
        bst.bfs();


        Assertions.assertEquals(2, bst.search(2));
        bst.delete(2);
        Assertions.assertEquals(null, bst.search(2));
        Assertions.assertEquals(-1, bst.search(-1));
        bst.delete(-1);
        Assertions.assertEquals(null, bst.search(-1));
        Assertions.assertEquals(10, bst.search(10));
        bst.delete(10);
        Assertions.assertEquals(null, bst.search(10));
        Assertions.assertEquals(5, bst.search(5));
        bst.delete(5);
        Assertions.assertEquals(null, bst.search(5));
        Assertions.assertEquals(6, bst.search(6));
        bst.delete(6);
        Assertions.assertEquals(null, bst.search(6));
        Assertions.assertEquals(4, bst.search(4));
        bst.delete(4);
        Assertions.assertEquals(null, bst.search(4));
        Assertions.assertEquals(7, bst.search(7));
        bst.delete(7);
        Assertions.assertEquals(null, bst.search(7));
        Assertions.assertEquals(3, bst.search(3));
        bst.delete(3);
        Assertions.assertEquals(null, bst.search(3));
        Assertions.assertEquals(8, bst.search(8));
        bst.delete(8);
        Assertions.assertEquals(null, bst.search(8));
    }

}
