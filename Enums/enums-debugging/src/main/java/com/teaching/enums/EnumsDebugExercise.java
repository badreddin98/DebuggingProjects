package com.teaching.enums;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;

public class EnumsDebugExercise {
    // Bug 1: Incorrect enum declaration with values
    public enum Direction {
        NORTH, SOUTH, EAST, WEST;
        public Direction opposite() {
            switch (this) {
                case NORTH: return SOUTH;
                case SOUTH: return NORTH;
                case EAST: return WEST;
                case WEST: return EAST;
                default: return null;
            }
        }
    }

    // Bug 2: Incorrect enum with constructor
    public enum Planet {
        MERCURY(3.303e+23, 2.4397e6),
        VENUS(4.869e+24, 6.0518e6),
        EARTH(5.976e+24, 6.37814e6),
        MARS(6.421e+23, 3.3972e6),
        JUPITER(1.9e+27, 7.1492e7),
        SATURN(5.688e+26, 6.0268e7),
        URANUS(8.686e+25, 2.5559e7),
        NEPTUNE(1.024e+26, 2.4746e7);

        private final double mass;
        private final double radius;
        private static final double G = 6.67300E-11;

        Planet(double mass, double radius) {
            this.mass = mass;
            this.radius = radius;
        }

        public double surfaceGravity() {
            return G * mass / (radius * radius);
        }
    }

    // Bug 3: Incorrect enum with abstract methods
    public enum Operation {
        PLUS { public double apply(double x, double y) { return x + y; } },
        MINUS { public double apply(double x, double y) { return x - y; } },
        TIMES { public double apply(double x, double y) { return x * y; } },
        DIVIDE { public double apply(double x, double y) { return x / y; } };

        public abstract double apply(double x, double y);
    }

    // Bug 4: Incorrect enum with static fields
    public enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;
        private static final List<Day> WEEKDAYS = Arrays.asList(MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY);
        private static final List<Day> WEEKEND = Arrays.asList(SATURDAY, SUNDAY);

        public boolean isWeekend() {
            return WEEKEND.contains(this);
        }
    }

    // Bug 5: Incorrect enum with interfaces
    public enum Color implements java.io.Serializable {
        RED(255, 0, 0),
        GREEN(0, 255, 0),
        BLUE(0, 0, 255);

        private final int r, g, b;

        Color(int r, int g, int b) {
            this.r = r;
            this.g = g;
            this.b = b;
        }

        public int getRGB() {
            return (r << 16) | (g << 8) | b;
        }
    }

    // Bug 6: Incorrect enum with generics
    public enum Status<T> {
        PENDING,
        PROCESSING,
        COMPLETED,
        FAILED;

        private T result;

        public void setResult(T result) {
            this.result = result;
        }

        public T getResult() {
            return result;
        }
    }

    // Bug 7: Incorrect enum with nested enums
    public enum Outer {
        A, B, C;

        public enum Inner {
            X, Y, Z;

            public void doSomething() {
                System.out.println("Inner enum method");
            }
        }
    }

    // Bug 8: Incorrect enum with annotations
    @Deprecated
    public enum Legacy {
        OLD, NEW;

        @Override
        public String toString() {
            return name().toLowerCase();
        }
    }

    // Bug 9: Incorrect enum with switch expressions
    public enum Season {
        SPRING, SUMMER, AUTUMN, WINTER;

        public String getDescription() {
            return switch (this) {
                case SPRING -> "Warm and blooming";
                case SUMMER -> "Hot and sunny";
                case AUTUMN -> "Cool and colorful";
                case WINTER -> "Cold and snowy";
            };
        }
    }

    // Bug 10: Incorrect enum with valueOf
    public enum Size {
        SMALL("S"),
        MEDIUM("M"),
        LARGE("L"),
        EXTRA_LARGE("XL");

        private final String code;

        Size(String code) {
            this.code = code;
        }

        public static Size fromCode(String code) {
            for (Size size : values()) {
                if (size.code.equals(code)) {
                    return size;
                }
            }
            throw new IllegalArgumentException("Invalid size code: " + code);
        }
    }
} 