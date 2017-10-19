package com.github.juanmougan;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for the solution.
 * Created by juanma on 16/10/17.
 */
public class SolutionDeltaTest {

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyArrayThrowsException() throws Exception {
        // Given
        Integer[] input = {};
        // When
        SolutionDelta delta = new SolutionDelta(input);
    }

    @Test
    public void testDeltaEncoding() throws Exception {
        // Given
        Integer[] input = {25626, 25757, 24367, 24267, 16, 100, 2, 7277};
        Integer[] expected = {25626, 131, -1390, -100, -24251, 84, -98, 7275};
        // When
        SolutionDelta delta = new SolutionDelta(input);
        // Then
        delta.deltaEncoding();
        Integer[] actual = delta.getDelta();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void testEscapeDeltaEncoding() throws Exception {
        // Given
        Integer[] input = {25626, 131, -1390, -100, -24251, 84, -98, 7275};
        Integer[] expected = {25626, -128, 131, -128, -1390, -100, -128, -24251, 84, -98, -128,  7275};
        // When
        SolutionDelta delta = new SolutionDelta(input);
        // Then
        Integer[] actual = delta.escapeDeltaEncoding(input);
        assertArrayEquals(expected, actual);
    }
}