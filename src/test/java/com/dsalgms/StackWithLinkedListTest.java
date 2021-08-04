package com.dsalgms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StackWithLinkedListTest {

    @Test
    void pushTestWithInts() {
        StackWithLinkedList<Integer> st = new StackWithLinkedList<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        Assertions.assertEquals(4, st.pop());
        for(Integer el : st) {
            System.out.print(el);
        }
        System.out.println();
        Assertions.assertEquals(3, st.pop());
        for(Integer el : st) {
            System.out.print(el);
        }
        System.out.println();
        Assertions.assertEquals(2, st.pop());
        for(Integer el : st) {
            System.out.print(el);
        }
        System.out.println();
        Assertions.assertEquals(1, st.pop());
        for(Integer el : st) {
            System.out.print(el);
        }
        st.push(300);
        st.push(400);
        st.push(500);
        st.push(600);

        for(Integer el : st) {
            System.out.print(el);
        }
    }

    @Test
    void pushTestWithStrings() {
        StackWithLinkedList<String> st = new StackWithLinkedList<>();
        st.push("a");
        st.push("b");
        st.push("c");

        Assertions.assertEquals("c", st.pop());
        for(String el : st) {
            System.out.print(el);
        }
        System.out.println();
        Assertions.assertEquals("b", st.pop());
        for(String el : st) {
            System.out.print(el);
        }
        System.out.println();
        Assertions.assertEquals("a", st.pop());
        for(String el : st) {
            System.out.print(el);
        }
        st.pop();
    }

    @Test
    void pop() {

    }

   @Test
    void iterator() {

    }
}
