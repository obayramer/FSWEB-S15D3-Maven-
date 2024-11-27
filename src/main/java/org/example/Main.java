package org.example;

import org.example.entity.Employee;
import java.util.*;


public class Main {
    public static void main(String[] args) {
        // Employee LinkedList oluşturma
        List<Employee> employees = new LinkedList<>();
        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(1, "Dogancan", "Kinik"));
        employees.add(new Employee(2, "Seyyit Battal", "Arvas"));
        employees.add(new Employee(3, "Anil", "Ensari"));
        employees.add(new Employee(4, "Burak", "Cevizli"));

        // findDuplicates metodunun çağrılması
        List<Employee> duplicates = findDuplicates(employees);
        System.out.println("Duplicate Employees:");
        for (Employee duplicate : duplicates) {
            System.out.println(duplicate);
        }

        // findUniques metodunun çağrılması
        Map<Integer, Employee> uniques = findUniques(employees);
        System.out.println("\nUnique Employees:");
        for (Employee employee : uniques.values()) {
            System.out.println(employee);
        }

        // removeDuplicates metodunun çağrılması
        List<Employee> noDuplicates = removeDuplicates(employees);
        System.out.println("\nEmployees after removing duplicates:");
        for (Employee noDuplicate : noDuplicates) {
            System.out.println(noDuplicate);
        }

        // WordCounter metodunun çağrılması
        Map<String, Integer> wordCounts = WordCounter.calculatedWord();
        System.out.println("\nWord Frequency:");
        for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
            String word = entry.getKey();
            Integer count = entry.getValue();
            System.out.println(word + ": " + count);
        }
    }

    public static List<Employee> findDuplicates(List<Employee> employees) {
        // Remove null elements first
        List<Employee> list = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee != null) {
                list.add(employee);
            }
        }
        employees = list;

        // Find duplicates
        List<Employee> finalEmployees = employees;
        List<Employee> result = new ArrayList<>();
        Set<Employee> uniqueValues = new HashSet<>();
        for (Employee e : employees) {
            if (Collections.frequency(finalEmployees, e) > 1) {
                if (uniqueValues.add(e)) {
                    result.add(e);
                }
            }
        }
        return result;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        // Remove null elements first
        List<Employee> list = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee != null) {
                list.add(employee);
            }
        }
        employees = list;

        Map<Integer, Employee> uniqueMap = new HashMap<>();
        for (Employee emp : employees) {
            // Only add if this is the first occurrence of this ID
            uniqueMap.putIfAbsent(emp.getId(), emp);
        }

        return uniqueMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees) {
        // Remove null elements first
        List<Employee> list = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee != null) {
                list.add(employee);
            }
        }
        employees = list;

        // Keep only elements that appear exactly once
        List<Employee> finalEmployees = employees;
        List<Employee> result = new ArrayList<>();
        for (Employee e : employees) {
            if (Collections.frequency(finalEmployees, e) == 1) {
                result.add(e);
            }
        }
        return result;
    }
}
