package com.github.juanmougan;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by juanma on 9/7/17.
 */
public class SolutionDonutsTest {

    SolutionDonuts solutionDonuts;

    @Before
    public void setUp() throws Exception {
        this.solutionDonuts = new SolutionDonuts();
    }

    @After
    public void tearDown() throws Exception {
        this.solutionDonuts = null;
    }

    @Test
    public void testSortByPersonNameAndDonutName() throws Exception {

    }

    @Test
    public void testFlattenChoicesList() throws Exception {

    }

    @Test
    public void testAllDonutsLikedByPerson() throws Exception {

    }

    @Test
    public void testCategorizeDonuts() throws Exception {
        // Given
        List<String[]> donutConstraintPairs = new ArrayList<>();
        donutConstraintPairs.add(new String[]{"cruller", "vegan"});
        donutConstraintPairs.add(new String[]{"eclair", "chocolate"});
        donutConstraintPairs.add(new String[]{"pain au chocolat", "chocolate"});
        donutConstraintPairs.add(new String[]{"beignet", "coffee"});

        // When
        Map<String, List<String>> actualDonuts = solutionDonuts.categorizeDonuts(donutConstraintPairs);

        // Then
        Map<String, List<String>> expectedDonuts = new HashMap<>();
        List<String> vegans = new ArrayList<>();
        vegans.add("cruller");
        expectedDonuts.put("vegan", vegans);
        List<String> chocolates = new ArrayList<>();
        chocolates.add("eclair");
        chocolates.add("pain au chocolat");
        expectedDonuts.put("chocolate", chocolates);
        List<String> coffee = new ArrayList<>();
        coffee.add("beignet");
        expectedDonuts.put("coffee", coffee);

        assertEquals(expectedDonuts, actualDonuts);
    }
}