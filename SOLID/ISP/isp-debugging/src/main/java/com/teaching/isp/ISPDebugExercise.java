package com.teaching.isp;

public class ISPDebugExercise {
    // Bug 1: Worker interface with too many responsibilities
    public interface Worker {
        void work();
        void eat();
        void sleep();
        void code();
        void design();
        void test();
    }

    // Bug 2: Printer interface with unrelated methods
    public interface Printer {
        void print();
        void scan();
        void fax();
        void copy();
        void staple();
    }

    // Bug 3: Vehicle interface with mixed concerns
    public interface Vehicle {
        void start();
        void stop();
        void refuel();
        void changeOil();
        void rotateTires();
        void wash();
    }

    // Bug 4: User interface with too many features
    public interface User {
        void login();
        void logout();
        void register();
        void updateProfile();
        void deleteAccount();
        void resetPassword();
        void sendEmail();
        void uploadPhoto();
    }

    // Bug 5: Database interface with mixed operations
    public interface Database {
        void connect();
        void disconnect();
        void query();
        void update();
        void backup();
        void restore();
        void optimize();
        void index();
    }

    // Bug 6: MediaPlayer interface with too many features
    public interface MediaPlayer {
        void play();
        void pause();
        void stop();
        void record();
        void edit();
        void burn();
        void stream();
        void download();
    }

    // Bug 7: Document interface with mixed operations
    public interface Document {
        void create();
        void edit();
        void delete();
        void print();
        void share();
        void archive();
        void version();
        void lock();
    }

    // Bug 8: PaymentProcessor interface with too many methods
    public interface PaymentProcessor {
        void processCreditCard();
        void processPayPal();
        void processBankTransfer();
        void processCryptocurrency();
        void refund();
        void dispute();
        void reconcile();
        void report();
    }

    // Bug 9: NotificationService interface with mixed channels
    public interface NotificationService {
        void sendEmail();
        void sendSMS();
        void sendPush();
        void sendFax();
        void sendLetter();
        void schedule();
        void track();
        void analyze();
    }

    // Bug 10: FileHandler interface with too many operations
    public interface FileHandler {
        void read();
        void write();
        void delete();
        void move();
        void copy();
        void compress();
        void encrypt();
        void decrypt();
    }

    // Example implementations showing the problems
    public static class Developer implements Worker {
        @Override
        public void work() { /* Implementation */ }
        @Override
        public void eat() { /* Implementation */ }
        @Override
        public void sleep() { /* Implementation */ }
        @Override
        public void code() { /* Implementation */ }
        @Override
        public void design() { /* Not needed */ }
        @Override
        public void test() { /* Not needed */ }
    }

    public static class BasicPrinter implements Printer {
        @Override
        public void print() { /* Implementation */ }
        @Override
        public void scan() { /* Not supported */ }
        @Override
        public void fax() { /* Not supported */ }
        @Override
        public void copy() { /* Not supported */ }
        @Override
        public void staple() { /* Not supported */ }
    }

    public static class ElectricCar implements Vehicle {
        @Override
        public void start() { /* Implementation */ }
        @Override
        public void stop() { /* Implementation */ }
        @Override
        public void refuel() { /* Not applicable */ }
        @Override
        public void changeOil() { /* Not applicable */ }
        @Override
        public void rotateTires() { /* Implementation */ }
        @Override
        public void wash() { /* Implementation */ }
    }

    public static class GuestUser implements User {
        @Override
        public void login() { /* Implementation */ }
        @Override
        public void logout() { /* Implementation */ }
        @Override
        public void register() { /* Implementation */ }
        @Override
        public void updateProfile() { /* Not allowed */ }
        @Override
        public void deleteAccount() { /* Not allowed */ }
        @Override
        public void resetPassword() { /* Not allowed */ }
        @Override
        public void sendEmail() { /* Not allowed */ }
        @Override
        public void uploadPhoto() { /* Not allowed */ }
    }

    public static class ReadOnlyDatabase implements Database {
        @Override
        public void connect() { /* Implementation */ }
        @Override
        public void disconnect() { /* Implementation */ }
        @Override
        public void query() { /* Implementation */ }
        @Override
        public void update() { /* Not allowed */ }
        @Override
        public void backup() { /* Not allowed */ }
        @Override
        public void restore() { /* Not allowed */ }
        @Override
        public void optimize() { /* Not allowed */ }
        @Override
        public void index() { /* Not allowed */ }
    }
} 