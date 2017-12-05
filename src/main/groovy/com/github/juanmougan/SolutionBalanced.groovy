package com.github.juanmougan

/**
 * Checks if a String is balanced
 * E.g. for every opening parenthesis, there's a matching closing parenthesis,
 * without any other opening parenthesis in between.
 */
class SolutionBalanced {

    boolean isBalanced(String input) {
        // Sanity check
        if (input[0] != "(") {
            return false
        }
        Deque<String> checkBalance = new LinkedList<>()
        for(int i = 0; i < input.length(); i++) {
            if(input[i] == "(") {
                checkBalance.push(input[i])
            } else {            // can only be ")"
                if (!checkBalance.isEmpty()) {
                    checkBalance.pop()
                } else {
                    // I can't pop an empty stack
                    return false
                }
            }
        }
        return checkBalance.isEmpty()
    }

}
