package com.github.juanmougan

class SolutionBalancedTest extends GroovyTestCase {
    void testIsBalancedForSimpleCase_itIs() {
        // Given
        def balanced = new SolutionBalanced()
        // When
        def result = balanced.isBalanced("()")
        // Then
        assertTrue(result)
    }

    void testIsBalancedForSimpleCase_itIsNot() {
        // Given
        def balanced = new SolutionBalanced()
        // When
        def result = balanced.isBalanced("(")
        // Then
        assertFalse(result)
    }

    void testIsBalancedForCaseWithExtraClosing_itIsNot() {
        // Given
        def balanced = new SolutionBalanced()
        // When
        def result = balanced.isBalanced("())")
        // Then
        assertFalse(result)
    }

    void testIsBalancedForDoubleCase_itIs() {
        // Given
        def balanced = new SolutionBalanced()
        // When
        def result = balanced.isBalanced("()()")
        // Then
        assertTrue(result)
    }

    void testIsBalancedForNestedCaseWithExtraBalancedCase_itIs() {
        // Given
        def balanced = new SolutionBalanced()
        // When
        def result = balanced.isBalanced("(())()")
        // Then
        assertTrue(result)
    }

    void testIsBalancedForDoubleCase_itIsNot() {
        // Given
        def balanced = new SolutionBalanced()
        // When
        def result = balanced.isBalanced("()()(")
        // Then
        assertFalse(result)
    }

    void testIsBalancedForNestedCase_itIs() {
        // Given
        def balanced = new SolutionBalanced()
        // When
        def result = balanced.isBalanced("(())")
        // Then
        assertTrue(result)
    }

    void testIsBalancedForNestedCase_itIsNot() {
        // Given
        def balanced = new SolutionBalanced()
        // When
        def result = balanced.isBalanced(")(()")
        // Then
        assertFalse(result)
    }

    void testIsBalancedForRepetitionsInsideBalancedSet_itIs() {
        // Given
        def balanced = new SolutionBalanced()
        // When
        def result = balanced.isBalanced("(()()()())")
        // Then
        assertTrue(result)
    }

    void testIsBalancedForInterleavedCase_itIs() {
        // Given
        def balanced = new SolutionBalanced()
        // When
        def result = balanced.isBalanced("(()())")
        // Then
        assertTrue(result)
    }
}
