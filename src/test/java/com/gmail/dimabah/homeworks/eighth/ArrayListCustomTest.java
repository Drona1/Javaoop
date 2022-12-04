package com.gmail.dimabah.homeworks.eighth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import static org.junit.jupiter.api.Assertions.*;

class ArrayListCustomTest {

    private ArrayListCustom<Integer> list;


    @BeforeEach
    void createObject() {
        list = new ArrayListCustom<>();
        list.add(1);
        list.add(2);
    }

    @Test
    void createNegativeList() {
        assertThrows(IllegalArgumentException.class,
                () -> new ArrayListCustom<>(-1));
    }

    @Test
    void add() {
        assertTrue(list.add(3));
        assertEquals("[1, 2, 3]", list.toString());
        assertEquals(3, list.size());
    }

    @Test
    void addNullElements() {
        assertTrue(list.add(null));
        assertEquals("[1, 2, null]", list.toString());
        assertEquals(3, list.size());
    }

    @Test
    void addInside() {
        assertTrue(list.add(3, 1));
        assertEquals("[1, 3, 2]", list.toString());
        assertEquals(3, list.size());
    }

    @Test
    void indexOutOfBoundsExceptionInAddMethod() {
        ArrayListCustom<Integer> obj = new ArrayListCustom<>();
        assertThrows(IndexOutOfBoundsException.class, () -> obj.add(5, 0));
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(5, 4));
    }

    @Test
    void expandArrayBeforeAddInAddMethodByIndex() {
        ArrayListCustom<Integer> obj = new ArrayListCustom<>(1);

        assertTrue(obj.add(1));
        assertEquals(1, obj.size());

        assertTrue(obj.add(2, 0));
        assertEquals(2, obj.size());
        assertEquals("[2, 1]", obj.toString());
    }

    @Test
    void expandArrayBeforeAddInAddMethod() {
        ArrayListCustom<Integer> obj = new ArrayListCustom<>(1);

        assertTrue(obj.add(1));
        assertEquals(1, obj.size());

        assertTrue(obj.add(2));
        assertEquals(2, obj.size());
        assertEquals("[1, 2]", obj.toString());
    }

    @Test
    void remove() {
        list.add(3);
        list.add(null);
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
    void indexOutOfBoundsExceptionInRemoveMethod() {
        ArrayListCustom<Integer> obj = new ArrayListCustom<>();
        assertThrows(IndexOutOfBoundsException.class, () -> obj.remove(0));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(4));
    }

    @Test
    void get() {
        assertEquals(2, list.get(1));
    }

    @Test
    void indexOutOfBoundsExceptionInGetMethod() {
        ArrayListCustom<Integer> obj = new ArrayListCustom<>();
        assertThrows(IndexOutOfBoundsException.class, () -> obj.get(0));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(4));
    }

    @Test
    void print() {
        var output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        list.print();
        assertEquals("[1, 2]" + System.lineSeparator(), output.toString());

        System.setOut(System.out);
    }

    @Test
    void contains() {
        assertTrue(list.contains(2));
        assertFalse(list.contains(10));
    }

    @Test
    void size() {
        assertEquals(2, list.size());
    }

    @Test
    void testToString() {
        assertEquals("[1, 2]", list.toString());
    }

    @Test
    void testEqualsTrue() {
        ArrayListCustom<Integer> list2 = new ArrayListCustom<>();
        list2.add(1);
        list2.add(2);
        assertTrue(list.equals(list2));
    }

    @Test
    void testEqualsFalse() {
        ArrayListCustom<Integer> list2 = new ArrayListCustom<>();
        assertFalse(list.equals(list2));
    }


    @Test
    void testHashCode() {
        ArrayListCustom<Integer> list2 = new ArrayListCustom<>();
        list2.add(1);
        list2.add(2);
        assertEquals(list2.hashCode(), list.hashCode());
    }

    @Test
    void testHashCodeFalse() {
        ArrayListCustom<Integer> list2 = new ArrayListCustom<>();
        assertNotEquals(list.hashCode(), list2.hashCode());
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
}