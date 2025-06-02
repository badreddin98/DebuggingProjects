package com.teaching.ocp;

import java.util.ArrayList;
import java.util.List;

public class OCPDebugExercise {
    // Bug 1: Shape calculator with hardcoded shapes
    public static class ShapeCalculator {
        public double calculateArea(String shape, double... dimensions) {
            if (shape.equals("circle")) {
                return Math.PI * dimensions[0] * dimensions[0];
            } else if (shape.equals("rectangle")) {
                return dimensions[0] * dimensions[1];
            } else if (shape.equals("triangle")) {
                return 0.5 * dimensions[0] * dimensions[1];
            }
            throw new IllegalArgumentException("Unknown shape: " + shape);
        }
    }

    // Bug 2: Payment processor with hardcoded payment methods
    public static class PaymentProcessor {
        public void processPayment(String paymentMethod, double amount) {
            if (paymentMethod.equals("credit_card")) {
                System.out.println("Processing credit card payment: " + amount);
            } else if (paymentMethod.equals("paypal")) {
                System.out.println("Processing PayPal payment: " + amount);
            } else if (paymentMethod.equals("bank_transfer")) {
                System.out.println("Processing bank transfer: " + amount);
            } else {
                throw new IllegalArgumentException("Unsupported payment method: " + paymentMethod);
            }
        }
    }

    // Bug 3: Report generator with hardcoded formats
    public static class ReportGenerator {
        public void generateReport(String format, String data) {
            if (format.equals("pdf")) {
                System.out.println("Generating PDF report: " + data);
            } else if (format.equals("excel")) {
                System.out.println("Generating Excel report: " + data);
            } else if (format.equals("csv")) {
                System.out.println("Generating CSV report: " + data);
            } else {
                throw new IllegalArgumentException("Unsupported format: " + format);
            }
        }
    }

    // Bug 4: Notification service with hardcoded channels
    public static class NotificationService {
        public void sendNotification(String channel, String message) {
            if (channel.equals("email")) {
                System.out.println("Sending email: " + message);
            } else if (channel.equals("sms")) {
                System.out.println("Sending SMS: " + message);
            } else if (channel.equals("push")) {
                System.out.println("Sending push notification: " + message);
            } else {
                throw new IllegalArgumentException("Unsupported channel: " + channel);
            }
        }
    }

    // Bug 5: Discount calculator with hardcoded discount types
    public static class DiscountCalculator {
        public double calculateDiscount(String type, double amount) {
            if (type.equals("percentage")) {
                return amount * 0.1; // 10% discount
            } else if (type.equals("fixed")) {
                return 50.0; // $50 discount
            } else if (type.equals("seasonal")) {
                return amount * 0.2; // 20% seasonal discount
            } else {
                throw new IllegalArgumentException("Unsupported discount type: " + type);
            }
        }
    }

    // Bug 6: Data exporter with hardcoded export formats
    public static class DataExporter {
        public void exportData(String format, List<String> data) {
            if (format.equals("json")) {
                System.out.println("Exporting as JSON: " + data);
            } else if (format.equals("xml")) {
                System.out.println("Exporting as XML: " + data);
            } else if (format.equals("yaml")) {
                System.out.println("Exporting as YAML: " + data);
            } else {
                throw new IllegalArgumentException("Unsupported format: " + format);
            }
        }
    }

    // Bug 7: Log formatter with hardcoded log levels
    public static class LogFormatter {
        public String formatLog(String level, String message) {
            if (level.equals("info")) {
                return "[INFO] " + message;
            } else if (level.equals("error")) {
                return "[ERROR] " + message;
            } else if (level.equals("debug")) {
                return "[DEBUG] " + message;
            } else {
                throw new IllegalArgumentException("Unsupported log level: " + level);
            }
        }
    }

    // Bug 8: Data validator with hardcoded validation rules
    public static class DataValidator {
        public boolean validate(String type, String data) {
            if (type.equals("email")) {
                return data.contains("@");
            } else if (type.equals("phone")) {
                return data.matches("\\d{10}");
            } else if (type.equals("zipcode")) {
                return data.matches("\\d{5}");
            } else {
                throw new IllegalArgumentException("Unsupported validation type: " + type);
            }
        }
    }

    // Bug 9: File compressor with hardcoded compression types
    public static class FileCompressor {
        public void compressFile(String type, String file) {
            if (type.equals("zip")) {
                System.out.println("Compressing as ZIP: " + file);
            } else if (type.equals("rar")) {
                System.out.println("Compressing as RAR: " + file);
            } else if (type.equals("7z")) {
                System.out.println("Compressing as 7Z: " + file);
            } else {
                throw new IllegalArgumentException("Unsupported compression type: " + type);
            }
        }
    }

    // Bug 10: Data transformer with hardcoded transformation types
    public static class DataTransformer {
        public String transform(String type, String data) {
            if (type.equals("uppercase")) {
                return data.toUpperCase();
            } else if (type.equals("lowercase")) {
                return data.toLowerCase();
            } else if (type.equals("capitalize")) {
                return data.substring(0, 1).toUpperCase() + data.substring(1);
            } else {
                throw new IllegalArgumentException("Unsupported transformation type: " + type);
            }
        }
    }
} 