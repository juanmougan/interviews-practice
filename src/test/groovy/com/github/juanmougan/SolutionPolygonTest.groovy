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

    void testIsRectangleForRectangle() {
        def polygon = [3, 1, 3, 1]
        def solution = new SolutionPolygon()

        assertTrue(solution.isRectangle(polygon))
    }

    void testIsRectangleNotRectangle() {
        def polygon = [3, 2, 3, 1]
        def solution = new SolutionPolygon()

        assertFalse(solution.isRectangle(polygon))
    }

    void testCountPolygonNeither() {
        def polygon = [3, 2, 3, 1]
        def solution = new SolutionPolygon()

        solution.countPolygon(polygon)

        assertEquals(1, solution.counter['neither'])
        assertEquals(0, solution.counter['squares'])
        assertEquals(0, solution.counter['rectangles'])
    }

    void testCountPolygonRectangle() {
        def polygon = [3, 2, 3, 2]
        def solution = new SolutionPolygon()

        solution.countPolygon(polygon)

        assertEquals(1, solution.counter['rectangles'])
        assertEquals(0, solution.counter['squares'])
        assertEquals(0, solution.counter['neither'])
    }

    void testCountPolygonSquare() {
        def polygon = [3, 3, 3, 3]
        def solution = new SolutionPolygon()

        solution.countPolygon(polygon)

        assertEquals(1, solution.counter['squares'])
        assertEquals(0, solution.counter['rectangles'])
        assertEquals(0, solution.counter['neither'])
    }

    void testCountPolygonWithNegative() {
        def polygon = [3, 3, 3, -3]
        def solution = new SolutionPolygon()

        solution.countPolygon(polygon)

        assertEquals(0, solution.counter['squares'])
        assertEquals(0, solution.counter['rectangles'])
        assertEquals(1, solution.counter['neither'])
    }

    void testCountPolygons() {
        def polygons = [[36, 30, 36, 30],
                        [15, 15, 15, 15],
                        [46, 96, 90, 100],
                        [86, 86, 86, 86],
                        [100, 200, 100, 200],
                        [-100, 200, -100, 200]]
        def solution = new SolutionPolygon()
        def expected = ['squares': 2, 'rectangles': 2, 'neither': 2]

        def actual = solution.countPolygons(polygons)

        assertEquals(expected, actual)
    }

}
