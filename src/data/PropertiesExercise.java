package data;

import java.io.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PropertiesExercise {
    public static void main(String[] args) throws Exception {
//        Properties properties = new Properties();
//
//        // Set properties (Key : Value)
//        properties.setProperty("username", "Phong");
//        properties.setProperty("password", "Password");
//
//        // Store the properties
//        properties.store(new FileOutputStream("src/data/config.properties"), "Comment here");
        createProperty();
        readProperty();
        addConfig();
    }

    public static void createProperty() throws IOException {
        Properties properties = new Properties();

        // Set properties (Key : Value)
        properties.setProperty("username", "Phong");
        properties.setProperty("password", "Password");

        // Store the properties
        properties.store(new FileOutputStream("src/data/config.properties"), "Comment here");
    }

    public static void readProperty() throws IOException {
        Properties properties = new Properties();

        properties.load(new FileInputStream("src/data/config.properties"));

        String username = properties.getProperty("username");
        String password = properties.getProperty("password");

        System.out.println(username + " : " + password);
    }

    public static void addConfig() throws IOException {
        Properties properties = new Properties();

        properties.load(new FileInputStream("src/data/config.properties"));

        properties.setProperty("username", "Username");

        properties.store(new FileOutputStream("src/data/config.properties"), "Update");
    }
}
