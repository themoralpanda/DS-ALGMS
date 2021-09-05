package com.dsalgms;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KruskalsMST {
    private WGraph wg;
    private int[] uf;
    private PriorityQueue<WGraph.Edge> pq;
    private List<WGraph.Edge> mst;

    public KruskalsMST(WGraph wg) {
        this.wg = wg;
        uf = new int[wg.size()];
        for(int i=0;i<uf.length;i++) {
            uf[i] = i;
        }
        pq = new PriorityQueue<>(wg.edges());
        mst = new ArrayList<>();
    }

    public void mst() {
        while(!pq.isEmpty()) {
            WGraph.Edge curr = pq.remove();
            int a = (Integer) curr.a - 1;
            int b = (Integer) curr.b - 1;
            if(uf[a] != uf[b]) {
                mst.add(curr);
                union(a , b);
            }
        }
        System.out.println("MST: ");
        mst.forEach(System.out::println);
        System.out.println("***");

    }

    private void union(int a, int b) {
        a--;
        b--;
        for(int i=0;i<uf.length;i++) {
            if(uf[i] == a)
                uf[i] = b;
        }
    }

}
