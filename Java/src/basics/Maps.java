package basics;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Maps {
    public static void main(String[] args) {
        // HashMap - No order
        // LinkedHashMap - Insertion order is preserved
        // TreeMap - Elements are sorted by Key
        Map<String, Integer> languagesCount = new HashMap<>();
        // String is the Key type and Integer is the Value type
        languagesCount.put("HTML", 5);
        languagesCount.put("Java", 7);
        languagesCount.put("Python", 3);
        // Get Size -
        System.out.println(languagesCount.size());
        // This doesn't allow duplicate keys. The keys are stored as a set.
        // If you put any pair with existing key, the value will be updated.
        languagesCount.put("Python", 4);
        System.out.println(languagesCount);
        // To get value for specific key -
        System.out.println("Number of Java Courses = " + languagesCount.get("Java"));
        // Check if map contains key -
        if (languagesCount.containsKey("JavaScript"))
            System.out.println("Yes, we have JavaScript");
        else
            System.out.println("No, we don't have JavaScript");
        // Iterate on a map -
        for (Map.Entry<String, Integer> entry : languagesCount.entrySet()) {
            System.out.format("%d %s courses%n", entry.getValue(), entry.getKey());
        }
        // Another way
        for (String key : languagesCount.keySet()) {
            System.out.println("Key: " + key + ", Value: " + languagesCount.get(key));
        }
        // To list the keys only - keySet will output a set
        System.out.println(languagesCount.keySet());
        // To check the total of all values
        int totalCourses = 0;
        for (Integer value: languagesCount.values()) {
            totalCourses += value;
        }
        System.out.println(totalCourses);

        // Tree Map
        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put("Python", 3);
        treeMap.put("Java", 4);
        treeMap.put("CSS", 2);
        treeMap.put("XML", 5);
        for (Map.Entry<String, Integer> entry : treeMap.entrySet()) {
            System.out.format("%d %s courses%n", entry.getValue(), entry.getKey());
        }
        // Try the same thing with a LinkedHashMap to see the insertion order is preserved.
    }
}
