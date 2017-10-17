package com.github.juanmougan;

/**
 * Given a list of numbers as input, e.g. :

 25626 25757 24367 24267 16 100 2 7277

 Output a delta encoding for the sequence. In a delta encoding, the first element is reproduced as-is. Each subsequent element is represented as the numeric difference from the element before it. E.g. for the sequence above, the delta encoding would be:

 25626 131 -1390 -100 -24251 84 -98 7275

 However, if a difference value does not fit in a single signed byte, i.e. -127 <= x <= 127, then, instead of the difference, we would like to use an escape token, printing it.

 This will denote that the value following the escape token is a full four-byte difference value, rather than a one-byte difference value.

 For this exercise, we'll declare -128 as the escape token.

 Following the same example above, the final output would be:

 25626 -128 131 -128 -1390 -100 -128 -24251 84 -98 -128 7275
 * Created by juanma on 16/10/17.
 */
public class SolutionDelta {

    public Integer[] getDelta() {
        return delta;
    }

    private Integer[] input;
    private Integer[] delta;

    public SolutionDelta(Integer[] input) {
        if (input == null || input.length < 1) {
            throw new IllegalArgumentException("List must have at least one element");
        }
        this.input = input;
        this.delta = new Integer[input.length];
        this.delta[0] = this.input[0];
    }

    void deltaEncoding() {
        for (int higher = 1, lower = 0; higher < input.length && lower < input.length; higher++, lower++) {
            delta[higher] = input[higher] - input[lower];
        }
    }
}
