package com.github.juanmougan;

/**
 * Created by juanma on 21/3/17.
 */
public class SolutionMatchingParenthesis {

    public int thisIsnTheSolution(String input) {
        int pos = -1;       // Initially, outside the array
        int openingCount, closingCount;
        openingCount = closingCount = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                openingCount++;
            }
            if (input.charAt(i) == ')') {
                closingCount++;
            }
            if (openingCount == closingCount) {
                pos = i;
            }
        }
        return pos + 1;
    }

}
