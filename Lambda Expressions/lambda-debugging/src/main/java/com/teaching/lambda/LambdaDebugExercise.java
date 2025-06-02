package com.teaching.lambda;

import java.util.*;
import java.util.function.*;
import java.util.stream.Collectors;

public class LambdaDebugExercise {
    // Bug 1: Incorrect lambda syntax
    public List<Integer> filterNumbers(List<Integer> numbers) {
        return numbers.stream()
            .filter(n -> n > 0)
            .collect(Collectors.toList());
    }

    // Bug 2: Incorrect method reference
    public List<String> mapToStrings(List<Integer> numbers) {
        return numbers.stream()
            .map(String::valueOf)
            .collect(Collectors.toList());
    }

    // Bug 3: Incorrect predicate
    public boolean allPositive(List<Integer> numbers) {
        return numbers.stream()
            .allMatch(n -> n > 0);
    }

    // Bug 4: Incorrect consumer
    public void printNumbers(List<Integer> numbers) {
        numbers.forEach(System.out::println);
    }

    // Bug 5: Incorrect function
    public List<Integer> doubleNumbers(List<Integer> numbers) {
        return numbers.stream()
            .map(n -> n * 2)
            .collect(Collectors.toList());
    }

    // Bug 6: Incorrect supplier
    public List<Integer> generateNumbers(int count) {
        return Stream.generate(() -> new Random().nextInt(100))
            .limit(count)
            .collect(Collectors.toList());
    }

    // Bug 7: Incorrect binary operator
    public int sumNumbers(List<Integer> numbers) {
        return numbers.stream()
            .reduce(0, (a, b) -> a + b);
    }

    // Bug 8: Incorrect comparator
    public List<String> sortStrings(List<String> strings) {
        return strings.stream()
            .sorted((a, b) -> a.compareTo(b))
            .collect(Collectors.toList());
    }

    // Bug 9: Incorrect unary operator
    public List<Integer> incrementNumbers(List<Integer> numbers) {
        return numbers.stream()
            .map(n -> n + 1)
            .collect(Collectors.toList());
    }

    // Bug 10: Incorrect stream operations
    public List<Integer> processNumbers(List<Integer> numbers) {
        return numbers.stream()
            .filter(n -> n > 0)
            .map(n -> n * 2)
            .distinct()
            .sorted()
            .collect(Collectors.toList());
    }
} 