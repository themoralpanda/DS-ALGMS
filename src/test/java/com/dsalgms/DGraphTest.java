package com.dsalgms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class DGraphTest {

    @Test
    public void testDGraphElementaryOperations() {
        DGraph<Integer> dg = new DGraph<>();

        dg.add(1);
        dg.add(2);
        dg.add(3);
        dg.addEdge(1, 2);
        Assertions.assertEquals(true, dg.isConnected(1, 2));
        dg.addEdge(1, 3);
        Assertions.assertEquals(false, dg.isConnected(3, 1));
        dg.add(5);
        dg.addEdge(1, 5);
        dg.add(7);
        dg.add(4);
        dg.add(6);
        Assertions.assertEquals(0, dg.degree(7));
        Assertions.assertEquals(3, dg.degree(1));

        System.out.println("****** BFS Traversal ****");
        dg.bfsTraversal(1);

        dg.adj(1).forEach(System.out::println);
        dg.removeEdge(1,5);
        dg.adj(1).forEach(System.out::println);

        dg.remove(1);
        dg.add(9);


    }

    @Test
    public void testBFSTraversal() {
        DGraph<Integer> dg = new DGraph<>();

        dg.add(1);
        dg.add(2);
        dg.add(3);
        dg.add(4);
        dg.add(5);
        dg.add(6);
        dg.add(7);

        dg.add(8);
        dg.add(9);
        dg.add(10);

        dg.addEdge(1, 2);
        dg.addEdge(1, 3);
        dg.addEdge(1, 7);
        dg.addEdge(1, 5);
        dg.addEdge(2, 3);
        dg.addEdge(2, 5);
        dg.addEdge(3, 4);
        dg.addEdge(4, 5);
        dg.addEdge(4, 6);
        dg.addEdge(4, 7);
        dg.addEdge(5, 6);

        dg.addEdge(8, 9);
        dg.addEdge(9, 10);

        dg.add(11);
        dg.addEdge(10, 11);
        dg.addEdge(11, 8);

        System.out.println("Bfs traversal");
        dg.bfsTraversal(1);

        System.out.println();
        System.out.println("Dfs traversal");
        dg.dfsTraversal(1);
        dg.dfsTraversal(2);

        System.out.println();
        System.out.println("Topological sort");
        dg.topologicalSort();
    }

}
