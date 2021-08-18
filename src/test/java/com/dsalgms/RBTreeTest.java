package com.dsalgms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RBTreeTest {

    @Test
    public void testRBTreeElementaryOperations() {
        RBTree<Integer> rbt = new RBTree<>(Integer::compareTo);
        rbt.insert(2);
        rbt.insert(10);
        rbt.insert(7);
        rbt.insert(8);
        rbt.insert(5);
        rbt.insert(6);
        rbt.insert(4);
        rbt.insert(3);
        rbt.insert(-1);
        System.out.println();

        Assertions.assertEquals(2, rbt.search(2));
        Assertions.assertEquals(-1, rbt.search(-1));
        Assertions.assertEquals(null, rbt.search(-2));
        Assertions.assertEquals(6, rbt.search(6));
        Assertions.assertEquals(null, rbt.search(21));
        Assertions.assertEquals(null, rbt.search(25));
    }

}
