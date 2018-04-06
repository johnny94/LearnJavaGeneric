package com.learnjavageneric.wildcards;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author wangszuyung on 2018/03/27
 */
public class LowerBounds {
    public static void main(String[] args) {
        List<String> ls = Arrays.asList("a", "few", "strings");

        ls.forEach((String s) -> System.out.printf("%s in all caps is %s%n", s, s.toUpperCase()));
        ls.forEach((Object o) -> System.out.printf("%s has hashCode %d%n", o, o.hashCode()));

        List<Integer> il = Stream.of(3, 1, 4, 1, 5, 9)
            // If we do not provide the type, the compiler will assume that we are dealing with Integer.
            .peek(i -> System.out.println(i + " as a binary string is " + Integer.toBinaryString(i)))
            .peek((Number n) -> System.out.println("The double value of " + n + " is " + n.doubleValue()))
            .peek((Object o) -> System.out.println("The default hashCode of " + o + " is " + o.hashCode()))
            .collect(Collectors.toList());

        System.out.println(il);
    }
}

