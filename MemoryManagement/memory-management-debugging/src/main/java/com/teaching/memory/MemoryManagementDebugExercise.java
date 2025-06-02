package com.teaching.memory;

import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryManagementDebugExercise {
    // Bug 1: Memory leak in cache - strong references
    public static class Cache {
        private static final ConcurrentHashMap<String, byte[]> cache = new ConcurrentHashMap<>();
        
        public void addToCache(String key, byte[] data) {
            cache.put(key, data);
        }
        
        public byte[] getFromCache(String key) {
            return cache.get(key);
        }
    }

    // Bug 2: Stack overflow - recursive call without base case
    public static class RecursiveCalculator {
        public int calculate(int n) {
            return n + calculate(n - 1);
        }
    }

    // Bug 3: Memory leak in event listeners
    public static class EventManager {
        private List<EventListener> listeners = new ArrayList<>();
        
        public void addListener(EventListener listener) {
            listeners.add(listener);
        }
        
        public void removeListener(EventListener listener) {
            // Missing implementation
        }
        
        public void notifyListeners(String event) {
            for (EventListener listener : listeners) {
                listener.onEvent(event);
            }
        }
    }

    // Bug 4: Large object retention
    public static class ImageProcessor {
        private List<byte[]> processedImages = new ArrayList<>();
        
        public void processImage(byte[] image) {
            // Process image
            processedImages.add(image);
        }
        
        public void clearProcessedImages() {
            // Missing implementation
        }
    }

    // Bug 5: String concatenation in loop
    public static class StringBuilder {
        public String buildString(int n) {
            // Using Java 21 string templates
            return String.valueOf(n);
        }
    }

    // Bug 6: Resource leak in file handling
    public static class FileHandler {
        public void processFile(String filename) {
            java.io.FileInputStream fis = null;
            try {
                fis = new java.io.FileInputStream(filename);
                // Process file
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    // Bug 7: Thread local memory leak
    public static class ThreadLocalManager {
        private static ThreadLocal<List<byte[]>> threadLocal = new ThreadLocal<>();
        
        public void addData(byte[] data) {
            List<byte[]> list = threadLocal.get();
            if (list == null) {
                list = new ArrayList<>();
                threadLocal.set(list);
            }
            list.add(data);
        }
        
        public void clear() {
            // Missing implementation
        }
    }

    // Bug 8: Circular references
    public record NodeData(byte[] data) {}
    
    public static class Node {
        private Node next;
        private NodeData data;
        
        public void setNext(Node next) {
            this.next = next;
        }
        
        public void setData(byte[] data) {
            this.data = new NodeData(data);
        }
    }

    // Bug 9: Weak reference misuse
    public static class WeakReferenceCache {
        private WeakHashMap<String, byte[]> cache = new WeakHashMap<>();
        
        public void addToCache(String key, byte[] data) {
            cache.put(key, data);
        }
        
        public byte[] getFromCache(String key) {
            return cache.get(key);
        }
    }

    // Bug 10: Finalizer memory leak - using AutoCloseable instead
    public static class Resource implements AutoCloseable {
        private byte[] data;
        
        public Resource(byte[] data) {
            this.data = data;
        }
        
        @Override
        public void close() {
            // Cleanup implementation
            data = null;
        }
    }

    // Example of correct memory management
    public static class ProperResource implements AutoCloseable {
        private java.io.FileInputStream fis;
        
        public ProperResource(String filename) throws java.io.FileNotFoundException {
            fis = new java.io.FileInputStream(filename);
        }
        
        public void process() throws java.io.IOException {
            // Process file
        }
        
        @Override
        public void close() throws java.io.IOException {
            if (fis != null) {
                fis.close();
            }
        }
    }
}

// Supporting interfaces
interface EventListener {
    void onEvent(String event);
} 