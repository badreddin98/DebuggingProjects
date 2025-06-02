package com.teaching.stream;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamDebugExercise {
    private List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    private List<String> words = Arrays.asList("apple", "banana", "cherry", "date", "elderberry");
    private List<Person> people = Arrays.asList(
        new Person("John", 25),
        new Person("Alice", 17),
        new Person("Bob", 30),
        new Person("Carol", 16),
        new Person("Dave", 35)
    );

    // Bug 1: This method should return the sum of even numbers multiplied by 2
    public int sumEvenNumbers() {
        return numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .reduce(0, Integer::sum); // Bug: Using reduce instead of sum()
    }

    // Bug 2: This method should return a list of words longer than 5 characters in uppercase
    public List<String> getLongWords() {
        return words.stream()
                .filter(w -> w.length() > 5)
                .map(String::toUpperCase)
                .collect(Collectors.toList()); // Bug: Missing terminal operation
    }

    // Bug 3: This method should return the average of numbers greater than 5
    public double averageOfLargeNumbers() {
        return numbers.stream()
                .filter(n -> n > 5)
                .mapToDouble(n -> n)
                .average()
                .orElse(0.0); // Bug: Incorrect handling of Optional
    }

    // Bug 4: This method should return a string of all words joined with commas
    public String joinWords() {
        return words.stream()
                .collect(Collectors.joining(",")); // Bug: Missing terminal operation
    }

    // Bug 5: This method should return true if all numbers are positive
    public boolean areAllPositive() {
        return numbers.stream()
                .allMatch(n -> n > 0); // Bug: Incorrect predicate
    }

    // Bug 6: This method should return a map of words to their lengths
    public Map<String, Integer> wordLengthMap() {
        return words.stream()
                .collect(Collectors.toMap(
                    word -> word,
                    String::length
                )); // Bug: Missing merge function for duplicate keys
    }

    // Bug 7: This method should return a list of adult names (age >= 18)
    public List<String> getAdultNames() {
        return people.stream()
                .filter(p -> p.getAge() >= 18)
                .map(Person::getName)
                .collect(Collectors.toList()); // Bug: Incorrect age check
    }

    // Bug 8: This method should return the first number divisible by 3
    public Optional<Integer> findFirstDivisibleByThree() {
        return numbers.stream()
                .filter(n -> n % 3 == 0)
                .findFirst(); // Bug: Missing terminal operation
    }

    // Bug 9: This method should return a list of numbers squared and sorted
    public List<Integer> getSortedSquares() {
        return numbers.stream()
                .map(n -> n * n)
                .sorted()
                .collect(Collectors.toList()); // Bug: Incorrect sorting
    }

    // Bug 10: This method should return the count of words containing 'a'
    public long countWordsWithA() {
        return words.stream()
                .filter(w -> w.contains("a"))
                .count(); // Bug: Case-sensitive check
    }

    // Helper class for the exercises
    static class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() { return name; }
        public int getAge() { return age; }
    }
} 