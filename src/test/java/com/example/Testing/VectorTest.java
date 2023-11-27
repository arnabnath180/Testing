package com.example.Testing;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

public class VectorTest {

    @Test
    public void testAddInvalidIndex() {
        Vector<Integer> vector = new Vector<>();
        assertThrows(IndexOutOfBoundsException.class, () -> vector.add(-1, 5));
    }

    @Test
    public void testRemoveInvalidIndex() {
        Vector<Integer> vector = new Vector<>();
        assertThrows(IndexOutOfBoundsException.class, () -> vector.remove(-1));
    }

    @Test
    public void testGetInvalidIndex() {
        Vector<Integer> vector = new Vector<>();
        assertThrows(IndexOutOfBoundsException.class, () -> vector.get(0));
    }

    @Test
    public void testRemoveFromEmptyVector() {
        Vector<String> vector = new Vector<>();
        assertDoesNotThrow(() -> vector.remove("item"));
    }

    @Test
    public void testGetFromEmptyVector() {
        Vector<Double> vector = new Vector<>();
        assertThrows(IndexOutOfBoundsException.class, () -> vector.get(0));
    }

    @Test
    public void testAddFirstElement() {
        Vector<Integer> vector = new Vector<>();
        vector.add(0, 42);
        assertEquals(1, vector.size());
        assertEquals(Integer.valueOf(42), vector.get(0));
    }

    @Test
    public void testRemoveLastElement() {
        Vector<String> vector = new Vector<>();
        vector.add("first");
        vector.add("last");
        vector.remove(1);
        assertEquals(1, vector.size());
        assertEquals("first", vector.get(0));
    }

    @Test
    public void testAdd() {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);

        assertEquals(2, vector.size());
        assertEquals(Integer.valueOf(1), vector.get(0));
        assertEquals(Integer.valueOf(2), vector.get(1));
    }

    @Test
    public void testAddAtIndex() {
        Vector<String> vector = new Vector<>();
        vector.add("apple");
        vector.add("banana");
        vector.add("cherry");

        vector.add(1, "orange");

        assertEquals(4, vector.size());
        assertEquals("apple", vector.get(0));
        assertEquals("orange", vector.get(1));
        assertEquals("banana", vector.get(2));
        assertEquals("cherry", vector.get(3));
    }

    @Test
    public void testRemove() {
        Vector<Character> vector = new Vector<>();
        vector.add('a');
        vector.add('b');
        vector.add('c');

        vector.remove(Character.valueOf('b'));

        assertEquals(2, vector.size());
        assertEquals('a', vector.get(0));
        assertEquals('c', vector.get(1));
    }

    @Test
    public void testRemoveAtIndex() {
        Vector<Double> vector = new Vector<>();
        vector.add(1.1);
        vector.add(2.2);
        vector.add(3.3);

        vector.remove(1);

        assertEquals(2, vector.size());
        assertEquals(1.1, vector.get(0), 0.001);
        assertEquals(3.3, vector.get(1), 0.001);
    }

    @Test
    public void testSet() {
        Vector<String> vector = new Vector<>();
        vector.add("one");
        vector.add("two");

        vector.set(1, "three");

        assertEquals(2, vector.size());
        assertEquals("one", vector.get(0));
        assertEquals("three", vector.get(1));
    }

    @Test
    public void testSize() {
        Vector<Integer> vector = new Vector<>();
        assertEquals(0, vector.size());

        vector.add(1);
        vector.add(2);

        assertEquals(2, vector.size());
    }



    @Test
    public void testRemoveOutOfBoundsIndex() {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);

        // Removing beyond the end, should throw IndexOutOfBoundsException
        assertThrows(IndexOutOfBoundsException.class, () -> vector.remove(1));
        assertThrows(IndexOutOfBoundsException.class, () -> vector.remove(-1));
    }

    @Test
    public void testsetOutOfBoundsIndex() {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);

        // Removing beyond the end, should throw IndexOutOfBoundsException
        assertThrows(IndexOutOfBoundsException.class, () -> vector.set(1,5));
        assertThrows(IndexOutOfBoundsException.class, () -> vector.set(-1,5));
    }


    @Test
    void quickSort() {
        Vector<Integer> vector = new Vector<>();
        vector.add(5);
        vector.add(2);
        vector.add(8);
        vector.add(1);
        vector.add(3);

        System.out.println("Before sorting:");
        vector.display();

        vector.quickSort();

        System.out.println("After sorting:");
        vector.display();

        // Check if the vector is sorted
        assertTrue(isSorted(vector));
    }

    @Test
    void mergeSort() {
        Vector<Integer> vector = new Vector<>();
        vector.add(5);
        vector.add(2);
        vector.add(8);
        vector.add(1);
        vector.add(3);

        System.out.println("Before sorting:");
        vector.display();

        vector.mergeSort();

        System.out.println("After sorting:");
        vector.display();

        // Check if the vector is sorted
        assertTrue(isSorted(vector));
    }

    @Test
    void optimizedBubbleSort() {
        Vector<Integer> vector = new Vector<>();
        vector.add(5);
        vector.add(2);
        vector.add(8);
        vector.add(1);
        vector.add(3);

        System.out.println("Before sorting:");
        vector.display();

        vector.BubbleSort();

        System.out.println("After sorting:");
        vector.display();

        // Check if the vector is sorted
        assertTrue(isSorted(vector));
    }

    @Test
    void insertionSort() {
        Vector<Integer> vector = new Vector<>();
        vector.add(5);
        vector.add(2);
        vector.add(8);
        vector.add(1);
        vector.add(3);

        System.out.println("Before sorting:");
        vector.display();

        vector.insertionSort();

        System.out.println("After sorting:");
        vector.display();

        // Check if the vector is sorted
        assertTrue(isSorted(vector));
    }

    @Test
    void selectionSort() {
        Vector<Integer> vector = new Vector<>();
        vector.add(5);
        vector.add(2);
        vector.add(8);
        vector.add(1);
        vector.add(3);

        System.out.println("Before sorting:");
        vector.display();

        vector.selectionSort();

        System.out.println("After sorting:");
        vector.display();

        // Check if the vector is sorted
        assertTrue(isSorted(vector));
    }


    // Helper method to check if a vector is sorted
    private <T extends Comparable<T>> boolean isSorted(Vector<T> vector) {
        for (int i = 0; i < vector.size() - 1; i++) {
            if (vector.get(i).compareTo(vector.get(i + 1)) > 0) {
                return false;
            }
        }
        return true;
    }

    @Test
    void reverse() {
        Vector<Integer> vector = new Vector<>();
        Vector<Integer> tmp = new Vector<>();
        vector.add(5);
        vector.add(2);
        vector.add(8);
        vector.add(1);
        vector.add(3);

        tmp.add(5);
        tmp.add(2);
        tmp.add(8);
        tmp.add(1);
        tmp.add(3);

        System.out.println("Before reversing:");
        vector.display();

        vector.reverse();

        System.out.println("After reversing:");
        vector.display();

        // Check if the vector is reversed
        assertTrue(isReversed(vector,tmp));
    }

    // Helper method to check if a vector is reversed
    private <T extends Comparable<T>> boolean isReversed(Vector<T> vector,Vector<T> tmp) {
        int start = 0;
        int end = vector.size() - 1;

        while (end>=0) {
            if (!vector.get(start).equals(tmp.get(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    @Test
    void linearSearch() {
        Vector<Integer> vector = new Vector<>();
        vector.add(5);
        vector.add(2);
        vector.add(8);
        vector.add(1);
        vector.add(3);

        System.out.println("Vector:");
        vector.display();

        int index = vector.linearSearch(8);

        System.out.println("Index of 8: " + index);

        // Check if the linear search returns the correct index
        assertEquals(2, index);
        assertEquals(-1, vector.linearSearch(80));
    }

    @Test
    void lowerAndUpperBounds() {
        Vector<Integer> vector = new Vector<>();
        vector.add(1);
        vector.add(2);
        vector.add(2);
        vector.add(2);
        vector.add(3);
        vector.add(4);

        System.out.println("Vector:");
        vector.display();

        // Test case for lower bound
        int lowerBound1 = vector.lowerBound(2);
        int lowerBound2 = vector.lowerBound(5);

        System.out.println("Lower Bound of 2: " + lowerBound1);
        System.out.println("Lower Bound of 5: " + lowerBound2);

        // Check if the lower bounds are correct
        assertEquals(1, lowerBound1);
        assertEquals(6, lowerBound2);

        // Test case for upper bound
        int upperBound1 = vector.upperBound(2);
        int upperBound2 = vector.upperBound(5);

        System.out.println("Upper Bound of 2: " + upperBound1);
        System.out.println("Upper Bound of 5: " + upperBound2);

        // Check if the upper bounds are correct
        assertEquals(4, upperBound1);
        assertEquals(6, upperBound2);
    }


}
