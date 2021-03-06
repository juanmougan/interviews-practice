package com.github.juanmougan;

import java.util.*;

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

        // Convert the List of lists to a Map
        Map<String, List<String>> availableDonuts = categorizeDonuts(donutConstraintPairs);

        // Create each person choice
        Map<String, List<String>> personLikedDonuts = allDonutsLikedByPerson(candidateConstraintPairs, availableDonuts);

        // Flatten the Map so repeated types for a given person are separated
        List<String[]> unsortedResult = unGroupChoicesList(personLikedDonuts);

        // Sort the result
        List<String[]> sortedResult = sortByPersonNameAndDonutName(unsortedResult);

        return sortedResult;
    }

    /**
     * Sorts the result list, first by person name, then by donut name
     * @param unsortedResult unsorted list
     * @return List sorted by person, then by donut
     */
    List<String[]> sortByPersonNameAndDonutName(List<String[]> unsortedResult) {
        Collections.sort(unsortedResult, (a, b) -> {
            String x1 = a[0];
            String x2 = b[0];
            int sComp = x1.compareTo(x2);

            if (sComp != 0) {
                return sComp;
            } else {
                String y1 = a[1];
                String y2 = b[1];
                return y1.compareTo(y2);
            }
        });
        return unsortedResult;
    }

    /**
     * Un-groups the Map so it changes from this
     * [name1, [choice1, choice2, ..., choicen]]
     * [name2, [choice1]]
     *
     * to this
     * [name1, choice1]
     * [name1, choice2]
     * ...
     * [name1, choicen]
     * [name2, choice1]
     *
     * So, repeated types for a given person are separated
     * @param personLikedDonuts Map with each person's name and the list of donuts he likes.
     * @return List with pairs [person name, donut] grouped by person
     */
    List<String[]> unGroupChoicesList(Map<String, List<String>> personLikedDonuts) {
        List<String[]> unGroupedList = new ArrayList<>();
        for (String person : personLikedDonuts.keySet()) {
            List<String> personChoices = personLikedDonuts.get(person);
            for (String choice : personChoices) {
                String[] personPair = new String[]{person, choice};
                unGroupedList.add(personPair);
            }
        }
        return unGroupedList;
    }

    /**
     * Converts all people's pairs to a Map containing each person as the key, and all the donuts he likes as the value.
     * @param candidateConstraintPairs List containing all people donut's choices
     * @param availableDonuts List with each donut and its category
     * @return a Map with each person and the list of donuts he likes.
     */
    Map<String, List<String>> allDonutsLikedByPerson(List<String[]> candidateConstraintPairs,
                                                             Map<String, List<String>> availableDonuts) {
        Map<String, List<String>> personLikedDonuts = new HashMap<>();
        for (String[] personChoice : candidateConstraintPairs) {
            // This would be e.g. [john, eclair]
            String typeLiked = personChoice[1];
            List<String> donutsLiked = new ArrayList<>();
            if (typeLiked == "*") {
                List<List<String>> listOfList = new ArrayList(availableDonuts.values());
                donutsLiked.addAll(listOfList.stream().collect(ArrayList::new, List::addAll, List::addAll));
            } else {
                donutsLiked = availableDonuts.get(typeLiked);
            }
            personLikedDonuts.put(personChoice[0], donutsLiked);
        }
        return personLikedDonuts;
    }

    /**
     * Reads all the available donuts, and returns them categorized by their type
     * @param donutConstraintPairs the List of pairs [donut name, donut type]
     * @return a Map which key is a donut type, and value is the List of existing donuts
     */
    Map<String, List<String>> categorizeDonuts(List<String[]> donutConstraintPairs) {
        Map<String, List<String>> categorisedDonuts = new HashMap<>();
        for (String[] donutPair : donutConstraintPairs) {
            List<String> donutsForCategory = categorisedDonuts.get(donutPair[1]);
            if (donutsForCategory == null) {
                donutsForCategory = new ArrayList<>();
            }
            donutsForCategory.add(donutPair[0]);
            categorisedDonuts.put(donutPair[1], donutsForCategory);
        }
        return categorisedDonuts;
    }

}
