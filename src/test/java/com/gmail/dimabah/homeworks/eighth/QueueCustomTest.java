package com.gmail.dimabah.homeworks.eighth;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class QueueCustomTest {
    QueueCustom<Integer> queueFull;
    QueueCustom<Integer> queueEmpty;
    QueueCustom<Integer> queueZero;

    @BeforeEach
    void createQueue() {
        queueFull = new QueueCustom<>(3);
        queueFull.add(1);
        queueFull.add(2);
        queueFull.add(null);

        queueEmpty = new QueueCustom<>();

        queueZero = new QueueCustom<>(0);
    }

    @Test
    void IllegalArgumentExceptionIfNegativeSize() {
        assertThrows(IllegalArgumentException.class, () -> new QueueCustom<Integer>(-1));
    }

    @Test
    void add() {
        assertTrue(queueEmpty.add(1));
        assertTrue(queueEmpty.add(2));
        assertEquals(2, queueEmpty.size());
        assertEquals("[1, 2]", queueEmpty.toString());
    }

    @Test
    void IllegalStateExceptionInAddMethod() {
        assertThrows(IllegalStateException.class, () -> queueFull.add(10));
        assertThrows(IllegalStateException.class, () -> queueZero.add(10));
    }

    @Test
    void offer() {
        assertTrue(queueEmpty.offer(1));
        assertTrue(queueEmpty.offer(2));
        assertEquals(2, queueEmpty.size());
        assertEquals("[1, 2]", queueEmpty.toString());
    }

    @Test
    void offerWithFullQueue() {
        assertFalse(queueFull.offer(1));
    }

    @Test
    void offerWithZeroQueue() {
        assertFalse(queueZero.offer(1));
    }

    @Test
    void remove() {
        assertEquals("[1, 2, null]", queueFull.toString());

        assertEquals(1, queueFull.remove());
        assertEquals("[2, null]", queueFull.toString());
        assertEquals(2, queueFull.size());

        assertEquals(2, queueFull.remove());
        assertEquals("[null]", queueFull.toString());
        assertEquals(1, queueFull.size());

        assertNull(queueFull.remove());
        assertEquals("[]", queueFull.toString());
        assertEquals(0, queueFull.size());
    }

    @Test
    void removeAllAndAdd() {
        queueFull.remove();
        queueFull.remove();
        queueFull.remove();
        queueFull.add(10);
        assertEquals("[10]", queueFull.toString());
        assertEquals(1, queueFull.size());
    }

    @Test
    void IllegalStateExceptionInRemoveMethod() {
        assertThrows(NoSuchElementException.class, () -> queueEmpty.remove());
        assertThrows(NoSuchElementException.class, () -> queueZero.remove());
    }

    @Test
    void poll() {
        assertEquals("[1, 2, null]", queueFull.toString());

        assertEquals(1, queueFull.poll());
        assertEquals("[2, null]", queueFull.toString());
        assertEquals(2, queueFull.size());

        assertEquals(2, queueFull.poll());
        assertEquals("[null]", queueFull.toString());
        assertEquals(1, queueFull.size());

        assertNull(queueFull.poll());
        assertEquals("[]", queueFull.toString());
        assertEquals(0, queueFull.size());

        assertNull(queueFull.poll());
        assertEquals(0, queueFull.size());
    }

    @Test
    void pollWithEmptyQueue() {
        assertNull(queueEmpty.poll());
    }

    @Test
    void pollWithZeroQueue() {
        assertNull(queueZero.poll());
    }

    @Test
    void element() {
        assertEquals("[1, 2, null]", queueFull.toString());
        assertEquals(1, queueFull.element());
        assertEquals("[1, 2, null]", queueFull.toString());
        assertEquals(3, queueFull.size());

        assertEquals(1, queueFull.element());
        assertEquals("[1, 2, null]", queueFull.toString());
        assertEquals(3, queueFull.size());
    }

    @Test
    void NoSuchElementExceptionInElementMethod() {
        assertThrows(NoSuchElementException.class, () -> queueEmpty.element());
        assertThrows(NoSuchElementException.class, () -> queueZero.element());
    }

    @Test
    void peek() {
        assertEquals("[1, 2, null]", queueFull.toString());
        assertEquals(1, queueFull.peek());
        assertEquals("[1, 2, null]", queueFull.toString());
        assertEquals(3, queueFull.size());

        assertEquals(1, queueFull.peek());
        assertEquals("[1, 2, null]", queueFull.toString());
        assertEquals(3, queueFull.size());
    }

    @Test
    void peekWithEmptyQueue() {
        assertNull(queueEmpty.peek());
    }

    @Test
    void peekWithZeroQueue() {
        assertNull(queueZero.peek());
    }

    @Test
    void size() {
        assertEquals(3, queueFull.size());
    }

    @Test
    void contains() {
        assertTrue(queueFull.contains(2));
        assertTrue(queueFull.contains(null));
        assertFalse(queueFull.contains(5));
    }
    @Test
    void print(){
        var output = new ByteArrayOutputStream();
        System.setOut(new PrintStream(output));

        queueFull.print();
        assertEquals("[1, 2, null]" + System.lineSeparator(), output.toString());

        System.setOut(System.out);
    }
    @Test
    void testToString() {
        assertEquals("[1, 2, null]", queueFull.toString());
    }

    @Test
    void testEquals() {
        QueueCustom<Integer> obj = new QueueCustom<>(3);
        obj.add(1);
        obj.add(2);
        obj.add(null);
        assertTrue(queueFull.equals(obj));
    }

    @Test
    void testEqualsWithDifferentQueue() {
        QueueCustom<Integer> obj = new QueueCustom<>(3);
        obj.add(1);
        obj.add(2);
        obj.add(3);
        assertFalse(queueFull.equals(obj));
    }

    @Test
    void testEqualsWithDifferentCapacity() {
        QueueCustom<Integer> obj = new QueueCustom<>();
        obj.add(1);
        obj.add(2);
        obj.add(null);
        assertFalse(queueFull.equals(obj));
    }

    @Test
    void testEqualsWithEmptyQueue() {
        QueueCustom<Integer> obj = new QueueCustom<>();
        assertTrue(queueEmpty.equals(obj));
    }

    @Test
    void testEqualsWithZeroQueue() {
        QueueCustom<Integer> obj = new QueueCustom<>(0);
        assertTrue(queueZero.equals(obj));
    }

    @Test
    void testHashCode() {
        QueueCustom<Integer> obj = new QueueCustom<>(3);
        obj.add(1);
        obj.add(2);
        obj.add(null);
        assertEquals(queueFull.hashCode(), obj.hashCode());
    }

    @Test
    void testHashCodeWithDifferentQueue() {
        QueueCustom<Integer> obj = new QueueCustom<>(3);
        obj.add(1);
        obj.add(2);
        obj.add(3);
        assertNotEquals(queueFull.hashCode(), obj.hashCode());
    }
    @Test
    void testHashCodeWithDifferentCapacity() {
        QueueCustom<Integer> obj = new QueueCustom<>();
        obj.add(1);
        obj.add(2);
        obj.add(null);
        assertNotEquals(queueFull.hashCode(), obj.hashCode());
    }

    @Test
    void testHashCodeWithEmptyQueue() {
        QueueCustom<Integer> obj = new QueueCustom<>();
        assertEquals(queueEmpty.hashCode(), obj.hashCode());
    }

    @Test
    void testHashCodeWithZeroQueue() {
        QueueCustom<Integer> obj = new QueueCustom<>(0);
        assertEquals(queueZero.hashCode(), obj.hashCode());
    }
}