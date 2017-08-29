package com.github.juanmougan

/**
 * Created by juanma on 29/8/17.
 */
class SolutionPolygonTest extends GroovyTestCase {
    void testAnyNegativeOnlyOne() {
        def polygon = [1, 2, -3, 4]
        def solution = new SolutionPolygon()

        assertTrue(solution.anyNegative(polygon))
    }

    void testAnyNegativeNone() {
        def polygon = [1, 2, 3, 4]
        def solution = new SolutionPolygon()

        assertFalse(solution.anyNegative(polygon))
    }

    void testIsSquareForSquare() {
        def polygon = [3, 3, 3, 3]
        def solution = new SolutionPolygon()

        assertTrue(solution.isSquare(polygon))
    }

    void testIsSquareNotSquare() {
        def polygon = [3, 3, 3, 1]
        def solution = new SolutionPolygon()

        assertFalse(solution.isSquare(polygon))
    }
}
