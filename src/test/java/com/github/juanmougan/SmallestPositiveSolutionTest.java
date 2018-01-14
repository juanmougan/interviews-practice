package com.github.juanmougan;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SmallestPositiveSolutionTest {

    SmallestPositiveSolution solution;

    @Before
    public void setUp() throws Exception {
        this.solution = new SmallestPositiveSolution();
    }

    @After
    public void tearDown() throws Exception {
        this.solution = null;
    }

    @Test
    public void firstTest() throws Exception {
        // Given
        int[] A = {1, 3, 6, 4, 1, 2};
        // When
        int solution = this.solution.solution(A);
        // Then
        assertEquals(5, solution);
    }

}