package com.teaching.reflection;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

public class ReflectionDebugExerciseTest {
    private ReflectionDebugExercise exercise = new ReflectionDebugExercise();

    @Test
    void testGetClassByName() {
        assertDoesNotThrow(() -> {
            Class<?> clazz = exercise.getClassByName("java.lang.String");
            assertEquals(String.class, clazz);
        });
    }

    @Test
    void testInvokeMethod() throws Exception {
        String str = "test";
        Object result = exercise.invokeMethod(str, "length");
        assertEquals(4, result);
    }

    @Test
    void testGetFieldValue() throws Exception {
        TestClass testObj = new TestClass();
        Object value = exercise.getFieldValue(testObj, "publicField");
        assertEquals("public", value);
    }

    @Test
    void testCreateInstance() throws Exception {
        Object instance = exercise.createInstance("java.lang.String");
        assertTrue(instance instanceof String);
    }

    @Test
    void testInvokeMethodWithParams() throws Exception {
        String str = "test";
        Object result = exercise.invokeMethodWithParams(str, "substring", 1, 3);
        assertEquals("es", result);
    }

    @Test
    void testCreateArray() throws Exception {
        Object array = exercise.createArray("java.lang.String", 5);
        assertTrue(array instanceof String[]);
        assertEquals(5, ((String[]) array).length);
    }

    @Test
    void testGetAnnotations() {
        TestClass testObj = new TestClass();
        Annotation[] annotations = exercise.getAnnotations(testObj);
        assertTrue(annotations.length > 0);
    }

    @Test
    void testGetInterfaces() {
        TestClass testObj = new TestClass();
        Class<?>[] interfaces = exercise.getInterfaces(testObj);
        assertTrue(interfaces.length > 0);
    }

    @Test
    void testGetGenericTypes() {
        TestClass testObj = new TestClass();
        Type[] types = exercise.getGenericTypes(testObj);
        assertTrue(types.length > 0);
    }

    @Test
    void testCreateProxy() {
        TestInterface target = new TestClass();
        TestInterface proxy = (TestInterface) exercise.createProxy(target, TestInterface.class);
        assertNotNull(proxy);
        assertEquals("test", proxy.testMethod());
    }

    // Test classes and interfaces
    @interface TestAnnotation {}

    interface TestInterface {
        String testMethod();
    }

    @TestAnnotation
    class TestClass implements TestInterface {
        public String publicField = "public";
        private String privateField = "private";

        @Override
        public String testMethod() {
            return "test";
        }
    }
} 