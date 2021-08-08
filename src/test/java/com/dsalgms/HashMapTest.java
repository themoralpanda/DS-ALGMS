package com.dsalgms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HashMapTest {

    @Test
    public void testHasMapDefault() {
        HashMap<Integer, String> hm = new HashMap<>();
        hm.put(1, "one");
        hm.put(2, "two");
        hm.put(3, "three");
        hm.put(101, "101");
        hm.put(201, "201");
        Assertions.assertEquals("one", hm.get(1));
        Assertions.assertEquals("two", hm.get(2));
        Assertions.assertEquals("three", hm.get(3));
        Assertions.assertEquals("101", hm.get(101));
        Assertions.assertEquals("201", hm.get(201));
        Assertions.assertEquals(5, hm.size());
        Assertions.assertEquals("one", hm.delete(1));
        Assertions.assertEquals(4, hm.size());
        Assertions.assertEquals("two", hm.delete(2));
        Assertions.assertEquals(3, hm.size());
        Assertions.assertEquals("three", hm.delete(3));
        Assertions.assertEquals(2, hm.size());
        Assertions.assertEquals("101", hm.delete(101));
        Assertions.assertEquals(1, hm.size());
        Assertions.assertEquals("201", hm.delete(201));
        Assertions.assertEquals(0, hm.size());


    }

}
