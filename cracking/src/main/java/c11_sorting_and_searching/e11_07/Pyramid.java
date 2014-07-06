package c11_sorting_and_searching.e11_07;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Pyramid {
    public static List<Person> findLongestPyramid(List<Person> people) {
        Collections.sort(people);
        Collections.reverse(people);
        return findLongestValidSubsequence(people);
    }

    private static List<Person> findLongestValidSubsequence(List<Person> people) {
        ArrayList<List<Person>> solutions = new ArrayList<>(people.size());
        findLongestValidSubsequence(people, solutions, 0);
        return chooseLongestSequence(solutions);
    }

    private static List<Person> chooseLongestSequence(List<List<Person>> solutions) {
        List<Person> result = null;
        for (List<Person> s : solutions) {
            result = longestList(result, s);
        }
        return result;
    }

    private static void findLongestValidSubsequence(List<Person> people, List<List<Person>> solutions, int i) {
        if (i >= people.size()) {
            return;
        }
        List<Person> longestPartialSolution = null;
        for (int j = 0; j < i; j++) {
            if (people.get(j).canBeUnder(people.get(i))) {
                longestPartialSolution = longestList(longestPartialSolution, solutions.get(j));
            }
        }
        ArrayList<Person> solution = new ArrayList<>();
        if (longestPartialSolution != null) {
            solution.addAll(longestPartialSolution);
        }
        solution.add(people.get(i));
        solutions.add(solution);
        findLongestValidSubsequence(people, solutions, i + 1);
    }

    private static <T> List<T> longestList(List<T> a, List<T> b) {
        if (a == null) {
            return b;
        }
        if (b == null) {
            return a;
        }
        return a.size() >= b.size() ? a : b;
    }
}
