package com.github.juanmougan;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Test for the solution.
 * Created by juanma on 19/3/17.
 */
public class SolutionTwoDigitsTest {

    @Test
    public void testSumOfAllWithTwoDigitsAllPositives() throws Exception {
        List<Integer> numbers = new ArrayList<Integer>(Arrays.asList(1, 2, 30, 5, 823, 13, 21));
        long expected = 30 + 13 + 21;
        SolutionTwoDigits sol = new SolutionTwoDigits();
        long actual = sol.sumOfAllWithTwoDigits(numbers);
        assertEquals(expected, actual);
    }

    @Test
    public void testSumOfAllWithTwoDigitsPositivesAndNegatives() throws Exception {
        List<Integer> numbers = new ArrayList<Integer>(Arrays.asList(1, 29, -30, 15, -823, 13, -21));
        long expected = 29 - 30 + 15 + 13 - 21;
        SolutionTwoDigits sol = new SolutionTwoDigits();
        long actual = sol.sumOfAllWithTwoDigits(numbers);
        assertEquals(expected, actual);
    }
}