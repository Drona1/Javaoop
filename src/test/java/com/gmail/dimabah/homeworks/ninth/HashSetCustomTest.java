package com.gmail.dimabah.homeworks.ninth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class HashSetCustomTest {
    HashSetCustom<Integer> set;

    @BeforeEach
    void createSet() {
        set = new HashSetCustom<>();
        set.add(1);
        set.add(2);
        set.add(null);
    }

    @Test
    void IllegalArgumentExceptionIfNegativeSize() {
        assertThrows(IllegalArgumentException.class, () -> new HashSetCustom<Integer>(-1));
    }

    @Test
    void add() {
        assertTrue(set.add(3));
        assertEquals("[{2}{3}{null}{1}]", set.toString());
    }

    @Test
    void addCollision() {
        assertTrue(set.add(12));
        assertEquals("[{2}{null}{1, 12}]", set.toString());
    }
    @Test
    void resize(){
        assertEquals(11,set.getSize());
        for (int i = 1; i <230 ; i+=23) {
            set.add(i);
        }
        assertEquals(23,set.getSize());
    }

    @Test
    void addDuplicate() {
        assertFalse(set.add(1));
        assertEquals("[{2}{null}{1}]", set.toString());
    }

    @Test
    void remove() {
        assertTrue(set.remove(2));
        assertEquals("[{null}{1}]", set.toString());
        assertFalse(set.remove(5));
        assertTrue(set.remove(null));
        assertEquals("[{1}]", set.toString());

    }

    @Test
    void removeCollision() {
        set.add(12);
        set.add(23);
        set.add(34);
        assertEquals("[{2}{null}{1, 12, 23, 34}]", set.toString());
        //removed first
        assertTrue(set.remove(1));
        assertEquals("[{2}{null}{12, 23, 34}]", set.toString());
        //removed from center
        assertTrue(set.remove(23));
        assertEquals("[{2}{null}{12, 34}]", set.toString());
        //removed last
        assertTrue(set.remove(34));
        assertEquals("[{2}{null}{12}]", set.toString());
    }

    @Test
    void get() {
        assertEquals(2, set.get(2));
        assertNull(set.get(5));
        assertNull(set.get(null));
    }

    @Test
    void getSize() {
        assertEquals(11, set.getSize());
    }

    @Test
    void getUsingSpace() {
        assertEquals(3, set.getUsingSpace());
    }

    @Test
    void contains() {
        assertTrue(set.contains(2));
        assertTrue(set.contains(null));
        assertFalse(set.contains(5));
    }

    @Test
    void print() {
        var output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        set.print();
        assertEquals("[{2}{null}{1}]" + System.lineSeparator(), output.toString());

        System.setOut(System.out);
    }

    @Test
    void testToString() {
        assertEquals("[{2}{null}{1}]", set.toString());
    }

    @Test
    void testEquals() {
        HashSetCustom<Integer> obj = new HashSetCustom<>();
        obj.add(1);
        obj.add(2);
        obj.add(null);
        assertTrue(set.equals(obj));
    }

    @Test
    void testEqualsWithDifferentSet() {
        HashSetCustom<Integer> obj = new HashSetCustom<>();
        obj.add(12);
        obj.add(2);
        obj.add(null);
        assertFalse(set.equals(obj));
    }

    @Test
    void testEqualsWithDifferentCapacity() {
        HashSetCustom<Integer> obj = new HashSetCustom<>(20);
        obj.add(1);
        obj.add(2);
        obj.add(null);
        assertFalse(set.equals(obj));
    }

    @Test
    void testEqualsWithEmptySet() {
        HashSetCustom<Integer> obj = new HashSetCustom<>();
        assertFalse(set.equals(obj));
    }

    @Test
    void testHashCode() {
        HashSetCustom<Integer> obj = new HashSetCustom<>();
        obj.add(1);
        obj.add(2);
        obj.add(null);
        assertEquals(set.hashCode(), obj.hashCode());
    }

    @Test
    void testHashCodeWithDifferentSet() {
        HashSetCustom<Integer> obj = new HashSetCustom<>();
        obj.add(1);
        obj.add(2);
        obj.add(3);
        assertNotEquals(set.hashCode(), obj.hashCode());
    }

    @Test
    void testHashCodeWithDifferentCapacity() {
        HashSetCustom<Integer> obj = new HashSetCustom<>(20);
        obj.add(1);
        obj.add(2);
        obj.add(null);
        assertNotEquals(set.hashCode(), obj.hashCode());
    }

    @Test
    void testHashCodeWithEmptySet() {
        HashSetCustom<Integer> obj = new HashSetCustom<>();
        assertNotEquals(set.hashCode(), obj.hashCode());
    }

    @Test
    void iterationInSet() {
        set.add(12);
        Integer[] arr = {2, null, 1, 12};
        int counter = 0;
        for (var i : set) {
            assertEquals(arr[counter++], i);
        }
    }

    @Test
    void iterationInEmptySet() {
        HashSetCustom<Integer> obj = new HashSetCustom<>();
        assertEquals("[]", obj.toString());

        for (var i : obj) {
            assertEquals(5, i);
        }
    }
}