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

    void testIsBalancedForDoubleCase_itIs() {
        // Given
        def balanced = new SolutionBalanced()
        // When
        def result = balanced.isBalanced("()()")
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

    // FIXME this test is correct?
    void testIsBalancedForInterleavedCase_itIsNot() {
        // Given
        def balanced = new SolutionBalanced()
        // When
        def result = balanced.isBalanced("(()())")
        // Then
        assertFalse(result)
    }
}
