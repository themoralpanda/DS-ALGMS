package com.dsalgms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class UGraphTest {

    @Test
    public void testUGraphElementaryOperations() {
        UGraph<Integer> ug = new UGraph<>();

        ug.add(1);
        ug.add(2);
        ug.add(3);
        ug.addEdge(1, 2);
        Assertions.assertEquals(true, ug.isConnected(1, 2));
        ug.addEdge(1, 3);
        Assertions.assertEquals(true, ug.isConnected(3, 1));
        ug.add(5);
        ug.addEdge(1, 5);
        ug.add(7);
        ug.add(4);
        ug.add(6);
        Assertions.assertEquals(0, ug.degree(7));

        System.out.println("****** BFS Traversal ****");
        ug.bfsTraversal(1);

        ug.adj(1).forEach(System.out::println);
        ug.removeEdge(1,5);
        ug.adj(1).forEach(System.out::println);

        ug.remove(1);
        ug.add(9);


    }

    @Test
    public void testBFSTraversal() {
        UGraph<Integer> ug = new UGraph<>();

        ug.add(1);
        ug.add(2);
        ug.add(3);
        ug.add(4);
        ug.add(5);
        ug.add(6);
        ug.add(7);

        ug.addEdge(1, 2);
        ug.addEdge(1, 3);
        ug.addEdge(1, 7);
        ug.addEdge(1, 5);
        ug.addEdge(2, 3);
        ug.addEdge(2, 5);
        ug.addEdge(3, 4);
        ug.addEdge(4, 5);
        ug.addEdge(4, 6);
        ug.addEdge(4, 7);
        ug.addEdge(5, 6);

        System.out.println("Bfs traversal");
        ug.bfsTraversal(1);

        System.out.println("Dfs traversal");
        ug.dfsTraversal(1);
    }

}
