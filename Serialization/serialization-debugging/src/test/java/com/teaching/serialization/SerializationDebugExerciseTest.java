package com.teaching.serialization;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class SerializationDebugExerciseTest {
    private final SerializationDebugExercise exercise = new SerializationDebugExercise();

    @Test
    void testPerson() throws IOException, ClassNotFoundException {
        SerializationDebugExercise.Person person = new SerializationDebugExercise.Person("John", 30);
        
        // Serialize
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(person);
        oos.close();
        
        // Deserialize
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        SerializationDebugExercise.Person deserializedPerson = (SerializationDebugExercise.Person) ois.readObject();
        
        assertEquals("John", deserializedPerson.name);
        assertEquals(30, deserializedPerson.age);
    }

    @Test
    void testStudent() {
        SerializationDebugExercise.Student student = new SerializationDebugExercise.Student("Alice");
        assertThrows(NotSerializableException.class, () -> {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(student);
        });
    }

    @Test
    void testAccount() throws IOException, ClassNotFoundException {
        SerializationDebugExercise.Account account = new SerializationDebugExercise.Account("123", 1000.0);
        
        // Serialize
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(account);
        oos.close();
        
        // Deserialize
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        SerializationDebugExercise.Account deserializedAccount = (SerializationDebugExercise.Account) ois.readObject();
        
        assertEquals("123", deserializedAccount.accountNumber);
        assertEquals(1000.0, deserializedAccount.balance);
    }

    @Test
    void testEmployee() throws IOException, ClassNotFoundException {
        SerializationDebugExercise.Employee employee = new SerializationDebugExercise.Employee("Bob", 50000.0);
        
        // Serialize
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(employee);
        oos.close();
        
        // Deserialize
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        SerializationDebugExercise.Employee deserializedEmployee = (SerializationDebugExercise.Employee) ois.readObject();
        
        assertEquals("Bob", deserializedEmployee.name);
        assertEquals(0.0, deserializedEmployee.salary); // Transient field should be 0
    }

    @Test
    void testProduct() throws IOException, ClassNotFoundException {
        SerializationDebugExercise.Product product = new SerializationDebugExercise.Product("Laptop", 999.99);
        
        // Serialize
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(product);
        oos.close();
        
        // Deserialize
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        SerializationDebugExercise.Product deserializedProduct = (SerializationDebugExercise.Product) ois.readObject();
        
        assertEquals("Laptop", deserializedProduct.name);
        assertEquals(999.99, deserializedProduct.price);
    }

    @Test
    void testConfiguration() throws IOException, ClassNotFoundException {
        SerializationDebugExercise.Configuration config = new SerializationDebugExercise.Configuration("app", "value");
        
        // Serialize
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(config);
        oos.close();
        
        // Deserialize
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        SerializationDebugExercise.Configuration deserializedConfig = (SerializationDebugExercise.Configuration) ois.readObject();
        
        assertEquals("app", deserializedConfig.name);
        assertEquals("value", deserializedConfig.value);
    }

    @Test
    void testManager() throws IOException, ClassNotFoundException {
        SerializationDebugExercise.Manager manager = new SerializationDebugExercise.Manager("Charlie", 75000.0, "IT");
        
        // Serialize
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(manager);
        oos.close();
        
        // Deserialize
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        SerializationDebugExercise.Manager deserializedManager = (SerializationDebugExercise.Manager) ois.readObject();
        
        assertEquals("Charlie", deserializedManager.name);
        assertEquals("IT", deserializedManager.department);
    }

    @Test
    void testLibrary() throws IOException, ClassNotFoundException {
        SerializationDebugExercise.Library library = new SerializationDebugExercise.Library();
        library.addBook(new SerializationDebugExercise.Book("Java", "Author"));
        
        // Serialize
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(library);
        oos.close();
        
        // Deserialize
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        SerializationDebugExercise.Library deserializedLibrary = (SerializationDebugExercise.Library) ois.readObject();
        
        assertNotNull(deserializedLibrary.books);
        assertEquals(1, deserializedLibrary.books.size());
    }

    @Test
    void testNode() throws IOException, ClassNotFoundException {
        SerializationDebugExercise.Node node1 = new SerializationDebugExercise.Node("First");
        SerializationDebugExercise.Node node2 = new SerializationDebugExercise.Node("Second");
        node1.setNext(node2);
        
        // Serialize
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(node1);
        oos.close();
        
        // Deserialize
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        SerializationDebugExercise.Node deserializedNode = (SerializationDebugExercise.Node) ois.readObject();
        
        assertEquals("First", deserializedNode.data);
        assertNotNull(deserializedNode.next);
        assertEquals("Second", deserializedNode.next.data);
    }

    @Test
    void testOrder() throws IOException, ClassNotFoundException {
        SerializationDebugExercise.Order order = new SerializationDebugExercise.Order("123", 
            SerializationDebugExercise.OrderStatus.PROCESSING);
        
        // Serialize
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(order);
        oos.close();
        
        // Deserialize
        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        SerializationDebugExercise.Order deserializedOrder = (SerializationDebugExercise.Order) ois.readObject();
        
        assertEquals("123", deserializedOrder.orderId);
        assertEquals(SerializationDebugExercise.OrderStatus.PROCESSING, deserializedOrder.status);
    }
} 