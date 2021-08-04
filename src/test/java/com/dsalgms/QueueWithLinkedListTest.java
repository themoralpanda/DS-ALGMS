package com.dsalgms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import sun.invoke.empty.Empty;

import java.util.EmptyStackException;

class QueueWithLinkedListTest {

    @Test
    void enqueue() {
        QueueWithLinkedList<Integer> q = new QueueWithLinkedList<>();
        q.enqueue(1);
        q.enqueue(2);
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        Assertions.assertEquals(1, q.dequeue());
        for(Integer el: q) {
            System.out.print(el);
            System.out.print(",");
        }
        System.out.println();
        Assertions.assertEquals(2, q.dequeue());
        for(Integer el: q) {
            System.out.print(el);
            System.out.print(",");
        }
        System.out.println();
       q.enqueue(15);
        Assertions.assertEquals(3, q.dequeue());
        for(Integer el: q) {
            System.out.print(el);
            System.out.print(",");
        }
        System.out.println();
        Assertions.assertEquals(4, q.dequeue());
        for(Integer el: q) {
            System.out.print(el);
            System.out.print(",");
        }
        System.out.println();
        Assertions.assertEquals(5, q.dequeue());
        for(Integer el: q) {
            System.out.print(el);
            System.out.print(",");
        }
        System.out.println();

        Assertions.assertEquals(15, q.dequeue());
        for(Integer el: q) {
            System.out.print(el);
            System.out.print(",");
        }
        System.out.println();
    }

    @Test()
    void testUnderflow() {
        QueueWithLinkedList<String> q1 = new QueueWithLinkedList<>();
        Assertions.assertThrows(EmptyStackException.class, () -> q1.dequeue(), "EmptyStackException thrown at underflow error");
    }
}
