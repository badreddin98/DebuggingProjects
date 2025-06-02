package com.teaching.annotations;

import java.lang.annotation.*;
import java.lang.reflect.Method;

public class AnnotationsDebugExercise {
    // Bug 1: Missing retention policy
    @interface TestAnnotation {
        String value();
    }

    // Bug 2: Incorrect target
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    @interface MethodAnnotation {
        String value();
    }

    // Bug 3: Missing default value
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface Required {
        String value();
    }

    // Bug 4: Incorrect annotation usage
    @TestAnnotation("test")
    public void annotatedMethod() {
        // Method implementation
    }

    // Bug 5: Missing annotation processor
    @Retention(RetentionPolicy.SOURCE)
    @Target(ElementType.TYPE)
    @interface Generated {
        String value();
    }

    // Bug 6: Incorrect annotation inheritance
    @Inherited
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @interface BaseAnnotation {
        String value();
    }

    // Bug 7: Missing annotation validation
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.FIELD)
    @interface Validated {
        int min() default 0;
        int max() default 100;
    }

    // Bug 8: Incorrect annotation reflection
    public String getAnnotationValue(Method method) {
        TestAnnotation annotation = method.getAnnotation(TestAnnotation.class);
        return annotation.value();
    }

    // Bug 9: Missing annotation documentation
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface Deprecated {
        String since() default "";
        boolean forRemoval() default false;
    }

    // Bug 10: Incorrect annotation composition
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.TYPE)
    @interface CompositeAnnotation {
        Required[] required() default {};
        Validated[] validated() default {};
    }
} 