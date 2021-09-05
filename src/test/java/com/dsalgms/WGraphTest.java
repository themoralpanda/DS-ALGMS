package com.dsalgms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WGraphTest {

    @Test
    public void testWGraphElementaryOperations() {
        WGraph<Integer, Integer> wg = new WGraph<>();

        wg.add(1);
        wg.add(2);
        wg.add(3);
        wg.add(4);
        wg.add(5);

        wg.add(6);
        wg.add(7);

        wg.addEdge(1, 2, 1);
        wg.addEdge(1, 3 , 2);
        wg.addEdge(1, 5, 10);
        wg.addEdge(1, 7, 9);
        wg.addEdge(2, 3, 3);
        wg.addEdge(2, 5, 8);
        wg.addEdge(3, 4, 6);
        wg.addEdge(4, 7, 11);
        wg.addEdge(4, 5, 5);
        wg.addEdge(4, 6, 4);
        wg.addEdge(6, 5, 7);

        Assertions.assertEquals(true, wg.isConnected(1, 2));
        Assertions.assertEquals(true, wg.isConnected(3, 1));
        Assertions.assertEquals(4, wg.degree(1));

        wg.adj(1).forEach(System.out::println);

        KruskalsMST kMST = new KruskalsMST(wg);
        kMST.mst();
    }

}
