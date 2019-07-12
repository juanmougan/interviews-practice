package com.github.juanmougan;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ElementsRepeatedInArrayTest {

  private ElementsRepeatedInArray elementsRepeatedInArray = new ElementsRepeatedInArray();

  @Test
  public void elementsRepeatedIn_onlyOneRepeated() {
    int[] sampleArray = {3, 7, 2, 7, 9};
    assertEquals(1, elementsRepeatedInArray.elementsRepeatedIn(sampleArray));
  }

  @Test
  public void elementsRepeatedIn_twoRepeated() {
    int[] sampleArray = {3, 7, 2, 7, 9, 3, 5};
    assertEquals(2, elementsRepeatedInArray.elementsRepeatedIn(sampleArray));
  }

  @Test
  public void elementsRepeatedIn_noneRepeated() {
    int[] sampleArray = {3, 7, 2, 9};
    assertEquals(0, elementsRepeatedInArray.elementsRepeatedIn(sampleArray));
  }

  @Test
  public void elementsRepeatedIn_allRepeated() {
    int[] sampleArray = {8, 8, 8};
    assertEquals(1, elementsRepeatedInArray.elementsRepeatedIn(sampleArray));
  }
}