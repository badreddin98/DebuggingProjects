package com.teaching.memory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class MemoryManagementDebugExerciseTest {
    // Bug 1: Cache memory leak test
    @Test
    void testCacheMemoryLeak() {
        Cache cache = new Cache();
        byte[] data = new byte[1024 * 1024]; // 1MB
        cache.addToCache("key1", data);
        cache.addToCache("key2", data);
        
        // Verify cache behavior
        assertNotNull(cache.getFromCache("key1"));
        assertNotNull(cache.getFromCache("key2"));
    }

    // Bug 2: Stack overflow test
    @Test
    void testStackOverflow() {
        RecursiveCalculator calculator = new RecursiveCalculator();
        assertThrows(StackOverflowError.class, () -> {
            calculator.calculate(1000);
        });
    }

    // Bug 3: Event listener memory leak test
    @Test
    void testEventListenerMemoryLeak() {
        EventManager manager = new EventManager();
        EventListener listener = mock(EventListener.class);
        
        manager.addListener(listener);
        manager.notifyListeners("test");
        verify(listener).onEvent("test");
        
        // Test removal
        manager.removeListener(listener);
        manager.notifyListeners("test2");
        verify(listener, times(1)).onEvent(anyString());
    }

    // Bug 4: Large object retention test
    @Test
    void testImageProcessor() {
        ImageProcessor processor = new ImageProcessor();
        byte[] image = new byte[1024 * 1024]; // 1MB
        processor.processImage(image);
        processor.clearProcessedImages();
    }

    // Bug 5: String concatenation test
    @Test
    void testStringBuilder() {
        StringBuilder builder = new StringBuilder();
        String result = builder.buildString(1000);
        assertNotNull(result);
    }

    // Bug 6: Resource leak test
    @Test
    void testFileHandler() {
        FileHandler handler = new FileHandler();
        handler.processFile("nonexistent.txt");
    }

    // Bug 7: Thread local memory leak test
    @Test
    void testThreadLocalManager() {
        ThreadLocalManager manager = new ThreadLocalManager();
        byte[] data = new byte[1024];
        manager.addData(data);
        manager.clear();
    }

    // Bug 8: Circular reference test
    @Test
    void testCircularReferences() {
        Node node1 = new Node();
        Node node2 = new Node();
        node1.setNext(node2);
        node2.setNext(node1);
        
        byte[] data = new byte[1024];
        node1.setData(data);
        node2.setData(data);
    }

    // Bug 9: Weak reference test
    @Test
    void testWeakReferenceCache() {
        WeakReferenceCache cache = new WeakReferenceCache();
        byte[] data = new byte[1024];
        cache.addToCache("key", data);
        assertNotNull(cache.getFromCache("key"));
    }

    // Bug 10: Finalizer test
    @Test
    void testResourceFinalizer() {
        byte[] data = new byte[1024];
        Resource resource = new Resource(data);
        resource = null;
        System.gc();
    }

    // Example of correct resource management test
    @Test
    void testProperResource() {
        assertThrows(java.io.FileNotFoundException.class, () -> {
            try (ProperResource resource = new ProperResource("nonexistent.txt")) {
                resource.process();
            }
        });
    }
} 