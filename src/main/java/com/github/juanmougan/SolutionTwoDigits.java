package com.github.juanmougan;

import java.util.List;
import static java.lang.Math.abs;

/**
 * Simple exercise: sum all 2 digit numbers in a list.
 *
 */
public class SolutionTwoDigits {
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );
    }

    public long sumOfAllWithTwoDigits(List<Integer> input) {
        return input.stream().filter(this::isTwoDigits).mapToInt(i -> i).sum();
    }

    private boolean isTwoDigits(int n) {
        int divBy10 = abs(n) / 10;
        return divBy10 < 10 && divBy10 > 0;
    }
}
