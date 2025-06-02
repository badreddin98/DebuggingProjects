package com.teaching.datatypes;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DataTypesDebugExercise {
    // Bug 1: Incorrect primitive type usage
    public static class NumberOperations {
        public double divide(int a, int b) {
            return a / b; // Integer division
        }

        public long calculateFactorial(int n) {
            long result = 1;
            for (int i = 2; i <= n; i++) {
                result *= i; // Potential overflow
            }
            return result;
        }
    }

    // Bug 2: Incorrect floating-point comparison
    public static class FloatingPointComparison {
        public boolean areEqual(double a, double b) {
            return a == b; // Direct comparison of floating-point numbers
        }

        public boolean isZero(double value) {
            return value == 0.0; // Direct comparison with zero
        }
    }

    // Bug 3: Incorrect string handling
    public static class StringOperations {
        public String concatenate(String[] strings) {
            String result = "";
            for (String s : strings) {
                result += s; // Inefficient string concatenation
            }
            return result;
        }

        public boolean isPalindrome(String str) {
            return str == new StringBuilder(str).reverse().toString(); // Reference comparison
        }
    }

    // Bug 4: Incorrect array handling
    public static class ArrayOperations {
        public int[] resizeArray(int[] arr, int newSize) {
            int[] newArr = new int[newSize];
            System.arraycopy(arr, 0, newArr, 0, arr.length); // No bounds checking
            return newArr;
        }

        public int findMax(int[] arr) {
            int max = 0; // Incorrect initial value
            for (int num : arr) {
                if (num > max) {
                    max = num;
                }
            }
            return max;
        }
    }

    // Bug 5: Incorrect wrapper class usage
    public static class WrapperOperations {
        public Integer add(Integer a, Integer b) {
            return a + b; // Potential NullPointerException
        }

        public boolean isPositive(Integer num) {
            return num > 0; // Potential NullPointerException
        }
    }

    // Bug 6: Incorrect BigDecimal usage
    public static class BigDecimalOperations {
        public BigDecimal calculateInterest(BigDecimal principal, BigDecimal rate) {
            return principal * rate; // Incorrect operator
        }

        public boolean isGreaterThan(BigDecimal a, BigDecimal b) {
            return a > b; // Incorrect comparison
        }
    }

    // Bug 7: Incorrect date handling
    public static class DateOperations {
        public LocalDate addDays(LocalDate date, int days) {
            return date.plusDays(days); // No validation
        }

        public boolean isWeekend(LocalDate date) {
            return date.getDayOfWeek() == 6 || date.getDayOfWeek() == 7; // Incorrect day values
        }
    }

    // Bug 8: Incorrect collection handling
    public static class CollectionOperations {
        private List<String> items = new ArrayList<>();

        public void addItem(String item) {
            items.add(item); // No null check
        }

        public String getItem(int index) {
            return items.get(index); // No bounds checking
        }
    }

    // Bug 9: Incorrect enum usage
    public static class EnumOperations {
        public enum Status {
            ACTIVE, INACTIVE, PENDING
        }

        public boolean isActive(Status status) {
            return status == Status.ACTIVE; // Direct comparison
        }

        public Status getStatus(String value) {
            return Status.valueOf(value); // No exception handling
        }
    }

    // Bug 10: Incorrect variable scope
    public static class ScopeOperations {
        private static int counter = 0;

        public void incrementCounter() {
            int counter = 0; // Shadowing
            counter++;
        }

        public int getCounter() {
            return counter; // Returns static counter
        }
    }
} 