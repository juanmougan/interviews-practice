package com.github.juanmougan;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

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
        // Given
        //[name1, [choice1, choice2, ..., choicen]]
        Map<String, List<String>> personLikedDonuts = new HashMap<>();
        List<String> joseList = new ArrayList<>(Arrays.asList("cruller"));
        personLikedDonuts.put("jose", joseList);
        ArrayList<String> johnList = new ArrayList<>(Arrays.asList("eclair"));
        personLikedDonuts.put("john", johnList);
        ArrayList<String> maryList = new ArrayList<>(Arrays.asList("cruller", "eclair"));
        personLikedDonuts.put("mary", maryList);

        // When
        List<String[]> actualLikedDonuts = solutionDonuts.unGroupChoicesList(personLikedDonuts);

        // Then
        assertEquals(4, actualLikedDonuts.size());
        assertTrue(actualLikedDonuts.stream().anyMatch(e -> e[0].equals("jose") && e[1].equals("cruller")));
        assertTrue(actualLikedDonuts.stream().anyMatch(e -> e[0].equals("john") && e[1].equals("eclair")));
        assertTrue(actualLikedDonuts.stream().anyMatch(e -> e[0].equals("mary") && e[1].equals("cruller")));
        assertTrue(actualLikedDonuts.stream().anyMatch(e -> e[0].equals("mary") && e[1].equals("eclair")));
    }

    @Test
    public void testAllDonutsLikedByPerson_LikesAll() throws Exception {
        // Given
        Map<String, List<String>> availableDonuts = new HashMap<>();
        List<String> veganDonuts = new ArrayList<>(Arrays.asList("cruller"));
        availableDonuts.put("vegan", veganDonuts);
        List<String> chocolateDonuts = new ArrayList<>(Arrays.asList("eclair"));
        availableDonuts.put("chocolate", chocolateDonuts);

        List<String[]> candidatePairs = new ArrayList<>();
        String[] jose = new String[]{"jose", "vegan"};
        String[] john = new String[]{"john", "chocolate"};
        String[] mary = new String[]{"mary", "*"};
        candidatePairs.add(jose);
        candidatePairs.add(john);
        candidatePairs.add(mary);

        // When
        Map<String, List<String>> donutsByPerson = solutionDonuts.allDonutsLikedByPerson(candidatePairs, availableDonuts);

        // Then
        Map<String, List<String>> expectedDonuts = new HashMap<>();
        List<String> joseList = new ArrayList<>(Arrays.asList("cruller"));
        expectedDonuts.put("jose", joseList);
        List<String> johnList = new ArrayList<>(Arrays.asList("eclair"));
        expectedDonuts.put("john", johnList);
        List<String> maryList = new ArrayList<>(Arrays.asList("cruller", "eclair"));
        expectedDonuts.put("mary", maryList);

        assertEquals(expectedDonuts, donutsByPerson);
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
