package com.gmail.dimabah.homeworks.eighth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;


class LinkedListCustomTest {
    LinkedListCustom<Integer> list;

    @BeforeEach
    void createList() {
        list = new LinkedListCustom<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(null);
    }

    @Test
    void add() {

        assertTrue(list.add(5));
        assertEquals(5, list.size());

        assertEquals("[1, 2, 3, null, 5]", list.toString());
    }

    @Test
    void addInside() {

        assertTrue(list.add(5, 1));
        assertEquals(5, list.size());

        assertEquals("[1, 5, 2, 3, null]", list.toString());
    }

    @Test
    void addInsideFindRight() {
        list.add(5);
        list.add(6);
        assertTrue(list.add(10, 4));
        assertEquals("[1, 2, 3, null, 10, 5, 6]", list.toString());

    }

    @Test
    void indexOutOfBoundsExceptionInAddMethod() {
        LinkedListCustom<Integer> obj = new LinkedListCustom<>();
        assertThrows(IndexOutOfBoundsException.class, () -> obj.add(5, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(5, 5));
    }

    @Test
    void remove() {
        assertEquals(4, list.size());

        //removed from center
        assertTrue(list.remove(2));
        assertEquals(3, list.size());
        assertEquals("[1, 2, null]", list.toString());

        //removed last
        list.remove(2);
        assertEquals("[1, 2]", list.toString());

        //removed first
        list.remove(0);
        assertEquals("[2]", list.toString());

        //removed all
        list.remove(0);
        assertEquals("[]", list.toString());
    }

    @Test
    void removeRight() {
        list.add(5);
        list.add(6);
        list.remove(4);
        assertEquals("[1, 2, 3, null, 6]", list.toString());
    }

    @Test
    void indexOutOfBoundsExceptionInRemoveMethod() {
        LinkedListCustom<Integer> obj = new LinkedListCustom<>();
        assertThrows(IndexOutOfBoundsException.class, () -> obj.remove(0));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(5));
    }

    @Test
    void get() {
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertNull(list.get(3));
    }

    @Test
    void indexOutOfBoundsExceptionInGetMethod() {
        LinkedListCustom<Integer> obj = new LinkedListCustom<>();
        assertThrows(IndexOutOfBoundsException.class, () -> obj.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(5));
    }

    @Test
    void print() {
        var output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        list.print();
        assertEquals("[1, 2, 3, null]" + System.lineSeparator(), output.toString());

        System.setOut(System.out);
    }

    @Test
    void contains() {
        assertTrue(list.contains(1));
        assertTrue(list.contains(2));
        assertTrue(list.contains(null));

        assertFalse(list.contains(5));
    }

    @Test
    void size() {
        assertEquals(4, list.size());
    }

    @Test
    void getFirst() {
        assertEquals(1, list.getFirst());
        list.add(null, 0);
        assertNull(list.getFirst());
    }

    @Test
    void getFirstNull() {
        LinkedListCustom<Integer> obj = new LinkedListCustom<>();
        assertNull(obj.getFirst());
    }

    @Test
    void getLast() {
        assertNull(list.getLast());
        list.add(5);
        assertEquals(5, list.getLast());
    }

    @Test
    void getLastNull() {
        LinkedListCustom<Integer> obj = new LinkedListCustom<>();
        assertNull(obj.getLast());
    }

    @Test
    void testToString() {
        assertEquals("[1, 2, 3, null]", list.toString());
    }


    @Test
    void iterationInList() {
        int counter = 0;
        for (var i : list) {
            assertEquals(i, list.get(counter));
            counter++;
        }
    }

    @Test
    void iterationInEmptyList() {
        ArrayListCustom<Integer> obj = new ArrayListCustom<>();
        assertEquals("[]", obj.toString());

        int counter = 0;
        for (var i : obj) {
            assertEquals(i, obj.get(counter));
            counter++;
        }
    }

    @Test
    void testEquals() {
        LinkedListCustom<Integer> obj = new LinkedListCustom<>();
        obj.add(1);
        obj.add(2);
        obj.add(3);
        obj.add(null);
        assertTrue(list.equals(obj));
    }

    @Test
    void testEqualsWithDifferentQueue() {
        LinkedListCustom<Integer> obj = new LinkedListCustom<>();
        obj.add(1);
        obj.add(2);
        obj.add(3);
        obj.add(4);
        assertFalse(list.equals(obj));
    }


    @Test
    void testHashCode() {
        LinkedListCustom<Integer> obj = new LinkedListCustom<>();
        obj.add(1);
        obj.add(2);
        obj.add(3);
        obj.add(null);
        assertEquals(list.hashCode(), obj.hashCode());
    }

    @Test
    void testHashCodeWithDifferentQueue() {
        LinkedListCustom<Integer> obj = new LinkedListCustom<>();
        obj.add(1);
        obj.add(2);
        obj.add(3);
        obj.add(4);
        assertNotEquals(list.hashCode(), obj.hashCode());
    }
}