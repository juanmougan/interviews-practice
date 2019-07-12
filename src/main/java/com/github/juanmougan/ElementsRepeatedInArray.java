package com.github.juanmougan;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class ElementsRepeatedInArray {
  public int elementsRepeatedIn(int[] array) {
    final Set<Integer> uniqueElements = Arrays.stream(array).boxed().collect(Collectors.toSet());
    final int uniqueElementsSize = uniqueElements.size();
    return uniqueElementsSize == 1 ? uniqueElementsSize : array.length - uniqueElementsSize;
  }
}
