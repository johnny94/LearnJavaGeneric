package com.learnjavageneric.wildcards;

import java.util.Arrays;
import java.util.List;

/**
 * @author wangszuyung on 2018/03/27
 */
public class UpperBounds {
    public static double sumList(List<? extends Number> numbers) {
        return numbers.stream()
            .mapToDouble(Number::doubleValue)
            .sum();
    }

    public static void main(String[] args) {
        List<Number> numbers = Arrays.asList(3, 1, 4, 5, 6, 2, 9);
        System.out.println(sumList(numbers));

        List<Integer> li = Arrays.asList(3, 1, 4, 5, 6, 2, 9);
        System.out.println(sumList(li));

        List<Double> ld = Arrays.asList(3.0, 1.0, 4.0, 5.0, 6.0, 2.0, 9.0);
        System.out.println(sumList(ld));
    }
}
