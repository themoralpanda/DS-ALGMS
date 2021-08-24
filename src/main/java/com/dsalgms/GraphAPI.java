package com.dsalgms;

public interface GraphAPI<T> {
    /**
     * Add a new node to the Graph.
     * @param node
     */
    void add(T node);

    /**
     * Remove the given node and all its connections from the Graph.
     * @param node
     * @return
     */
    T remove(T node);

    /**
     * Connect node n1 with n2 by introducing a new edge to the Graph.
     * @param n1
     * @param n2
     */
    void addEdge(T n1, T n2);

    /**
     * Remove edge between n1 and n2.
     */
    void removeEdge(T n1, T n2);


    /**
     * Return the list of adjacent nodes connected to the given node.
     * @param node
     * @return
     */
    Iterable<T> adj(T node);

    /**
     * No of nodes that are directly connected to the given node via an edge.
     * @param node
     * @return
     */
    int degree(T node);

    /**
     * Check if a connection exists between given two nodes.
     * @param n1
     * @param n2
     * @return True if exists, else return false
     */
    boolean isConnected(T n1, T n2);

}
