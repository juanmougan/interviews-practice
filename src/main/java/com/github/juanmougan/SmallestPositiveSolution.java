package com.github.juanmougan;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Write a function:

 class Solution { public int solution(int[] A); }

 that, given an array A of N integers, returns the smallest positive integer (greater than 0) that does not occur in A.

 For example, given A = [1, 3, 6, 4, 1, 2], the function should return 5.

 Given A = [1, 2, 3], the function should return 4.

 Given A = [−1, −3], the function should return 1.

 Assume that:

 N is an integer within the range [1..100,000];
 each element of array A is an integer within the range [−1,000,000..1,000,000].
 Complexity:

 expected worst-case time complexity is O(N);
 expected worst-case space complexity is O(N), beyond input storage (not counting the storage required for input arguments).
 */
public class SmallestPositiveSolution {

    public int solution(int[] A) {
        // 1. Remove duplicates
        Set<Integer> withoutDuplicates = Arrays.stream(A).boxed().collect(Collectors.toSet());
        // 2. Use a sorted List
        List<Integer> input = new ArrayList<>(withoutDuplicates);
        Collections.sort(input);
        int i = 0;                  // To iterate over the array
        int candidate = 1;          // The answer won't be less than 1
        boolean found = false;      // Whether I already found the valid candidate
        while (i < input.size()) {
            if (!found && input.get(i) > 0 && input.get(i) == candidate) {
                candidate++;
            } else {
                found = true;
            }
            i++;
        }

        return candidate;
    }

}
