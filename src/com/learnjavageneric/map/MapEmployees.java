package com.learnjavageneric.map;

import com.learnjavageneric.max.Employee;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author wangszuyung on 2018/03/28
 */
public class MapEmployees {
    public static List<Employee> createEmployees() {
        return Arrays.asList(
            new Employee(1, "Peter Gibbons"),
            new Employee(2, "Samir Nagheenanajar"),
            new Employee(3, "Michael Bolton"),
            new Employee(4, "Milton Waddams")
        );
    }

    public static void main(String[] args) {
        List<Employee> employees = createEmployees();
        List<String> names = employees.stream()
            .map(Employee::getName)
            .collect(Collectors.toList());

        List<Integer> ids = employees.stream()
            .map(Employee::getId)
            .collect(Collectors.toList());

        int totalLength = employees.stream()
            .map(Employee::getName)
            .mapToInt(String::length)
            .sum();

        Map<Integer, Employee> employeeMap = employees.stream()
            .collect(Collectors.toMap(Employee::getId, Function.identity()));

        System.out.println("Reversed Sorted by key:");
        Comparator<Map.Entry<Integer, Employee>> revComparator = Map.Entry.<Integer, Employee>comparingByKey().reversed();
        // Or
        //Comparator<Map.Entry<Integer, Employee>> revComparator = Map.Entry.comparingByKey(Comparator.reverseOrder());

        employeeMap.entrySet().stream()
            .sorted(revComparator)
            .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));

        System.out.println("-------------------------");
        System.out.println("Sorted by name:");
        employeeMap.entrySet().stream()
            .sorted(Map.Entry.comparingByValue(Comparator.comparing(Employee::getName)))
            .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue()));


    }
}
