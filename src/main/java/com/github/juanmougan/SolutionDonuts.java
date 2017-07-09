package com.github.juanmougan;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The input is a list of pairs of donut name, donut type
 * and a list of people and preferred donut type.
 * The output should be alphabetically sorted 1st by name and 2nd by donut.
 *
 *  Example 1
 * Input:
 * Donut types:
 * [[cruller, vegan],
 *   [beignet, coffee]]
 * Team member preferences:
 * [[rob, coffee],
 *  [beth, vegan]]
 *
 * Output:
 * [[beth, cruller],
 *  [rob, beignet]]
 *
 * Example 2
 * Input:
 * Donut types:
 * [[cruller, vegan],
 *  [eclair, chocolate]]
 * Team member preferences:
 * [[jose, vegan],
 *  [john, chocolate],
 *  [mary, *]]
 *
 * Output:
 * [[john, eclair],
 *  [jose, cruller],
 *  [mary, cruller],
 *  [mary, eclair]]
 *
 */

public class SolutionDonuts {

    public List<String[]> matchDonuts(List<String[]> donutConstraintPairs, List<String[]> candidateConstraintPairs) {

        Map<String, List<String>> availableDonuts = categorizeDonuts(donutConstraintPairs);

        // Create each person choice
        Map<String, List<String>> personLikedDonuts = allDonutsLikedByPerson(candidateConstraintPairs, availableDonuts);

        // Flatten the Map so it now is
        // [name1, choice1]
        // [name1, choice2]
        // [name1, choice1]
        // So, repeated types for a given person are separated
        List<String[]> unsortedResult = flattenChoicesList(personLikedDonuts);

        // Sort the result
        List<String[]> sortedResult = sortByPersonNameAndDonutName(unsortedResult);

        return sortedResult;
    }

    private List<String[]> sortByPersonNameAndDonutName(List<String[]> unsortedResult) {
        return null;
    }

    private List<String[]> flattenChoicesList(Map<String, List<String>> personLikedDonuts) {
        return null;
    }

    private Map<String, List<String>> allDonutsLikedByPerson(List<String[]> candidateConstraintPairs,
                                                             Map<String, List<String>> availableDonuts) {
        Map<String, List<String>> personLikedDonuts = new HashMap<>();
        for (String[] personChoice : candidateConstraintPairs) {
            // This would be e.g. [john, eclair]
            List<String> donutsLiked = availableDonuts.get(personChoice[1]);
            personLikedDonuts.put(personChoice[0], donutsLiked);
        }
        return personLikedDonuts;
    }

    /**
     * Reads all the available donuts, and returns them categorized by their type
     * @param donutConstraintPairs the List of pairs [donut name, donut type]
     * @return a Map which key is a donut type, and value is the List of existing donuts
     */
    private Map<String, List<String>> categorizeDonuts(List<String[]> donutConstraintPairs) {
        // TODO
        return null;
    }

}
