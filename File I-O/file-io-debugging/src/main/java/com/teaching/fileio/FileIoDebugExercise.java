package com.teaching.fileio;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileIoDebugExercise {
    // Bug 1: No proper resource cleanup
    public String readFile(String filename) throws IOException {
        FileReader reader = new FileReader(filename);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line = bufferedReader.readLine();
        return line;
    }

    // Bug 2: No proper exception handling
    public void writeToFile(String filename, String content) {
        try {
            FileWriter writer = new FileWriter(filename);
            writer.write(content);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Bug 3: No proper file existence check
    public void copyFile(String source, String destination) throws IOException {
        FileInputStream in = new FileInputStream(source);
        FileOutputStream out = new FileOutputStream(destination);
        byte[] buffer = new byte[1024];
        int length;
        while ((length = in.read(buffer)) > 0) {
            out.write(buffer, 0, length);
        }
        in.close();
        out.close();
    }

    // Bug 4: No proper directory handling
    public void createDirectory(String path) throws IOException {
        File dir = new File(path);
        dir.mkdir();
    }

    // Bug 5: No proper file locking
    public void appendToFile(String filename, String content) throws IOException {
        FileWriter writer = new FileWriter(filename, true);
        writer.write(content);
        writer.close();
    }

    // Bug 6: No proper buffering for large files
    public List<String> readLargeFile(String filename) throws IOException {
        List<String> lines = new ArrayList<>();
        FileReader reader = new FileReader(filename);
        int character;
        StringBuilder line = new StringBuilder();
        while ((character = reader.read()) != -1) {
            if (character == '\n') {
                lines.add(line.toString());
                line = new StringBuilder();
            } else {
                line.append((char) character);
            }
        }
        reader.close();
        return lines;
    }

    // Bug 7: No proper temporary file handling
    public File createTempFile(String prefix, String suffix) throws IOException {
        File tempFile = File.createTempFile(prefix, suffix);
        return tempFile;
    }

    // Bug 8: No proper file permissions handling
    public void makeFileExecutable(String filename) {
        File file = new File(filename);
        file.setExecutable(true);
    }

    // Bug 9: No proper zip file handling
    public void createZipFile(String zipFilename, List<String> files) throws IOException {
        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFilename));
        for (String file : files) {
            FileInputStream fis = new FileInputStream(file);
            ZipEntry zipEntry = new ZipEntry(file);
            zipOut.putNextEntry(zipEntry);
            byte[] bytes = new byte[1024];
            int length;
            while ((length = fis.read(bytes)) >= 0) {
                zipOut.write(bytes, 0, length);
            }
            fis.close();
        }
        zipOut.close();
    }

    // Bug 10: No proper file watching
    public void watchDirectory(String directory) throws IOException {
        Path path = Paths.get(directory);
        WatchService watchService = FileSystems.getDefault().newWatchService();
        path.register(watchService, StandardWatchEventKinds.ENTRY_CREATE);
        WatchKey key = watchService.take();
        for (WatchEvent<?> event : key.pollEvents()) {
            System.out.println("Event kind:" + event.kind() + ". File affected: " + event.context() + ".");
        }
    }
} 