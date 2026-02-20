package loggersys;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {

    // Singleton instance
    private static volatile Logger instance;

    // File writer
    private PrintWriter writer;
    private String fileName;

    // Private constructor (default file)
    private Logger() {
        this.fileName = "default_log.txt";
        openFile(this.fileName);
    }

    //  Double-checked locking Singleton
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    // Open file helper
    private void openFile(String fileName) {
        try {
            writer = new PrintWriter(
                    new BufferedWriter(
                            new FileWriter(fileName, true))); // append mode
        } catch (IOException e) {
            System.err.println("Error opening file: " + e.getMessage());
        }
    }

    // Write log message
    public synchronized void write(String message) {
        if (writer != null) {
            writer.println(message);
            writer.flush(); // ensure immediate write
        }
    }

    //Change file dynamically
    public synchronized void setFileName(String newFileName) {
        close();
        this.fileName = newFileName;
        openFile(this.fileName);
    }

    // Close file safely
    public synchronized void close() {
        if (writer != null) {
            writer.close();
            writer = null;
        }
    }
}