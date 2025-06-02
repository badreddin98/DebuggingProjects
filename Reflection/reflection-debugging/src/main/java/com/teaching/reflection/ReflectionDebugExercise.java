package com.teaching.reflection;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

public class ReflectionDebugExercise {
    // Bug 1: No proper exception handling
    public Class<?> getClassByName(String className) {
        return Class.forName(className);
    }

    // Bug 2: No proper method access
    public Object invokeMethod(Object obj, String methodName) throws Exception {
        Method method = obj.getClass().getMethod(methodName);
        return method.invoke(obj);
    }

    // Bug 3: No proper field access
    public Object getFieldValue(Object obj, String fieldName) throws Exception {
        Field field = obj.getClass().getField(fieldName);
        return field.get(obj);
    }

    // Bug 4: No proper constructor handling
    public Object createInstance(String className) throws Exception {
        Class<?> clazz = Class.forName(className);
        return clazz.newInstance();
    }

    // Bug 5: No proper parameter handling
    public Object invokeMethodWithParams(Object obj, String methodName, Object... params) throws Exception {
        Method method = obj.getClass().getMethod(methodName);
        return method.invoke(obj, params);
    }

    // Bug 6: No proper array handling
    public Object createArray(String className, int size) throws Exception {
        Class<?> clazz = Class.forName(className);
        return Array.newInstance(clazz, size);
    }

    // Bug 7: No proper annotation handling
    public Annotation[] getAnnotations(Object obj) {
        return obj.getClass().getAnnotations();
    }

    // Bug 8: No proper interface handling
    public Class<?>[] getInterfaces(Object obj) {
        return obj.getClass().getInterfaces();
    }

    // Bug 9: No proper generic type handling
    public Type[] getGenericTypes(Object obj) {
        return obj.getClass().getGenericInterfaces();
    }

    // Bug 10: No proper proxy handling
    public Object createProxy(Object target, Class<?>... interfaces) {
        return Proxy.newProxyInstance(
            target.getClass().getClassLoader(),
            interfaces,
            (proxy, method, args) -> method.invoke(target, args)
        );
    }
} 