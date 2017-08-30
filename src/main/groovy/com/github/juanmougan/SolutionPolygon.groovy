package com.github.juanmougan

/**
 * Created by juanma on 29/8/17.
 */
class SolutionPolygon {

    def counter = ['squares': 0, 'rectangles': 0, 'neither': 0]

    def countPolygons(polygons) {
        polygons.each { p ->
            countPolygon(p)
        }
        return counter
    }

    def countPolygon(polygon) {
        if(anyNegative(polygon)) {
            counter['neither'] = counter['neither'] + 1
        } else {
            if(isSquare(polygon)) {
                counter['squares'] = counter['squares'] + 1
            } else if(isRectangle(polygon)) {
                counter['rectangles'] = counter['rectangles'] + 1
            } else {
                counter['neither'] = counter['neither'] + 1
            }
        }
    }

    def isSquare(polygon) {
        return (polygon[0] == polygon[1]) && (polygon[1] == polygon[2]) && (polygon[2] == polygon[3])
    }

    def isRectangle(polygon) {
        Set lenghts = new HashSet()
        polygon.each {
            lenghts.add(it)
        }
        return lenghts.size() == 2
    }

    def anyNegative(polygon) {
        def anyNegative = polygon[0] < 0 || polygon[1] < 0 || polygon[2] < 0 || polygon[3] < 0
        return anyNegative
    }

}
