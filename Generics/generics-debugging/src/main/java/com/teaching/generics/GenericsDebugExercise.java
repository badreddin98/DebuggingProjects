package com.teaching.generics;

import java.util.*;

public class GenericsDebugExercise {
    // Bug 1: Raw type usage
    public List getList() {
        return new ArrayList();
    }

    // Bug 2: Type erasure issue
    public <T> T[] createArray(T element) {
        return (T[]) new Object[10];
    }

    // Bug 3: Unbounded wildcard
    public void processList(List<?> list) {
        list.add(new Object());
    }

    // Bug 4: Incorrect type bounds
    public <T extends Number> void addNumbers(List<T> numbers) {
        numbers.add((T) new Integer(42));
    }

    // Bug 5: Type safety violation
    public <T> void addToList(List<T> list, T element) {
        if (element instanceof String) {
            list.add((T) new Integer(42));
        }
    }

    // Bug 6: Incorrect generic method
    public static <T> T getFirst(List<T> list) {
        return (T) list.get(0);
    }

    // Bug 7: Raw type in generic class
    public class Box<T> {
        private T value;
        public void setValue(Object obj) {
            this.value = (T) obj;
        }
    }

    // Bug 8: Incorrect wildcard usage
    public void copyList(List<? extends Number> source, List<? super Number> dest) {
        for (Number n : source) {
            dest.add(n);
        }
    }

    // Bug 9: Type parameter shadowing
    public class Container<T> {
        public <T> void add(T element) {
            // Type parameter T shadows the class type parameter
        }
    }

    // Bug 10: Incorrect generic array creation
    public <T> T[] createGenericArray(int size) {
        return new T[size];
    }
} 