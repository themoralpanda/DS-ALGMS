package com.dsalgms;

import java.util.List;

public interface WeightedGraphAPI<T, W> extends GraphAPI<T> {

    /**
     * Add an edge between node n1 and n2 with weight w.
     * @param n1
     * @param n2
     * @param w
     */
    void addEdge(T n1, T n2, W w);

    /**
     * Return the total number of Nodes in the graph.
     * @return
     */
    int size();

    List<?> edges();

}
