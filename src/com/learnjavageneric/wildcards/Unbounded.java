package com.learnjavageneric.wildcards;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * @author wangszuyung on 2018/03/27
 */
public class Unbounded {
    public static void main(String[] args) {
        List<?> l = Arrays.asList("Hello", LocalDate.now(), 3);
        System.out.println("Size: " + l.size());
        l.forEach(o -> System.out.println(o));

        // But we cannot add element to list.
        // l.add("ddd");
    }
}
