package com.example.Testing;

import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

public class MathUtilsTest {
    @Test
    void testGCD() {
        MathUtils mathUtils = new MathUtils();
        assertEquals(6, mathUtils.GCD(48, 18));
        assertEquals(1, mathUtils.GCD(17, 19));
        assertEquals(10, mathUtils.GCD(50, 60));
    }

    @Test
    void testPower() {
        MathUtils mathUtils = new MathUtils();
        assertEquals(32, mathUtils.power(2, 5));
        assertEquals(1, mathUtils.power(5, 0));
        assertEquals(1, mathUtils.power(-2, 0));
        assertEquals(16, mathUtils.power(-2, 4));
    }

    @Test
    void testSqrt() {
        MathUtils mathUtils = new MathUtils();
        assertEquals(5, mathUtils.Sqrt(25));
        assertEquals(0, mathUtils.Sqrt(0));
        assertEquals(1, mathUtils.Sqrt(1));
        assertEquals(4, mathUtils.Sqrt(16));
    }

    @Test
    void testPrintDivisors() {
        MathUtils mathUtils = new MathUtils();

        System.out.println("Divisors of 12:");
        mathUtils.printDivisors(12);


        assertEquals("1 12 2 6 3 4", getOutput(() -> mathUtils.printDivisors(12)));

        System.out.println("Divisors of 16:");
        mathUtils.printDivisors(16);


        assertEquals("1 16 2 8 4", getOutput(() -> mathUtils.printDivisors(16)));
    }

    @Test
    void testIsPrime() {
        MathUtils mathUtils = new MathUtils();
        assertTrue(mathUtils.isPrime(2));
        assertTrue(mathUtils.isPrime(17));
        assertFalse(mathUtils.isPrime(4));
        assertFalse(mathUtils.isPrime(1));
        assertFalse(mathUtils.isPrime(0));
        assertFalse(mathUtils.isPrime(9));
    }

    // Helper method to capture console output
    private String getOutput(Runnable runnable) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));

        runnable.run();

        System.setOut(originalOut);
        return outputStream.toString().trim();
    }

}
