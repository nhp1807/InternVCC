package data;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PropertiesExercise {
    public static void main(String[] args) throws Exception {
        // create reader object
        FileReader reader = new FileReader("src/data/db.properties");
        // create properties object
        Properties properties = new Properties();
        properties.load(reader);
        // show file info
        System.out.println(properties.getProperty("user"));
        System.out.println(properties.getProperty("password"));

        // get system properties
//        Properties properties = System.getProperties();
//        Set set = properties.entrySet();
//        // show system properties
//        Iterator itr = set.iterator();
//        while (itr.hasNext()) {
//            Map.Entry entry = (Map.Entry) itr.next();
//            System.out.println(entry.getKey() + " = " + entry.getValue());
//        }

        // create properties object
//        Properties properties = new Properties();
        // add property into properties object
        properties.setProperty("user", "admin");
        properties.setProperty("password", "admin123");
        // write properties to a file
        properties.store(new FileWriter("src/data/info.properties"), "Comment here");
    }
}
