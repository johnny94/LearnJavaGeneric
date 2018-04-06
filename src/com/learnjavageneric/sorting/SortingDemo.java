package com.learnjavageneric.sorting;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wangszuyung on 2018/03/28
 */
public class SortingDemo {
    private List<String> sampleStrings = Arrays.asList("this", "is", "a", "list", "of", "strings");

    // Default sort from Java 7-
    public List<String> alphaSort() {
        Collections.sort(sampleStrings);
        return sampleStrings;
    }

    // Default sort for Java 8+
    public List<String> alphaSortUsingStreams() {
        return sampleStrings.stream()
            .sorted()
            .collect(Collectors.toList());
    }

    // Java 7- using Comparator with anonymous inner class
    public List<String> lengthReverseSortWithComparator() {
        Collections.sort(sampleStrings, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                return s1.length() - s2.length();
            }
        });

        return sampleStrings;
    }

    // Java 8+ using a lambda as a Comparator
    public List<String> lengthSortWithLambda() {
        Collections.sort(sampleStrings, (s1, s2) -> s1.length() - s2.length());

        return sampleStrings;
    }

    // Sort by length with sorted
    public List<String> lengthSortUsingSorted() {
        return sampleStrings.stream()
            .sorted((s1, s2) -> s1.length() - s2.length())
            .collect(Collectors.toList());
    }

    // Length sort with comparingInt
    public List<String> lengthSortUsingComparator() {
        return sampleStrings.stream()
            .sorted(Comparator.comparingInt(String::length))
            .collect(Collectors.toList());
    }

    // Sort by length then alpha using sorted
    public List<String> lengthSortThenAlphaSortUsingSorted() {
        return sampleStrings.stream()
            .sorted(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()))
            .collect(Collectors.toList());
    }

    // Sort by length then alpha using sorted
    public List<String> lengthSortThenReverseAlphaUsingSorted() {
        return sampleStrings.stream()
            .sorted(Comparator.comparingInt(String::length).thenComparing(Comparator.reverseOrder()))
            .collect(Collectors.toList());
    }
}
