package basics;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Lists {

    public static void main(String[] args) {
        System.out.println("Lists........");
        List<String> langList = new ArrayList<>(5); // Optional to add the Initial capacity
        langList.add("Java");
        langList.add("Python");
        langList.add("Go");
        langList.add("Kotlin");
        langList.add("Scala");
        // You can continue adding even after 5 elements
        langList.add("Groovy");
        langList.add("JavaScript");
        // To get a specific element
        System.out.println(langList.get(3));
        System.out.println("Size of list -");
        System.out.println(langList.size());
        System.out.println("For loop on list -");
        for (String lang : langList) {
            System.out.println(lang);
        }
        System.out.println("For with if -");
        for (String lang : langList) {
            if (lang.contains("Java")) {
                System.out.println(lang);
            }
        }
        System.out.println("To get specific items from a list - Indexes start from 0");
        System.out.println(langList.get(2));
        System.out.println("To get index of an element");
        System.out.println(langList.indexOf("Python"));
        // To remove
        langList.remove(5);
        langList.remove("Scala");
        System.out.println(langList);
        // One of the reasons a List is preferred over using regular Arrays is that Arrays do not resize
        // To get the list data in an array format -
        // Object[] langArray = langList.toArray();
        String[] langArray = langList.toArray(new String[0]);
        System.out.println(langArray);
        // To get a sublist
        List<String> someLangs = langList.subList(0, 3);
        // (0 is inclusive and 3 is not)
        // Sublists are a view to the main list.
        // If you change a value of a sublist, it also modifies the original list
        System.out.println(someLangs);
        someLangs.set(0, "C++");
        System.out.println(someLangs);
        System.out.println(langList);

        System.out.println("Linked Lists........");
        LinkedList<String> ll = new LinkedList<>();
        // Adding elements
        ll.add("A"); // Adds to the list
        ll.addFirst("B"); // Adds to the 0th position
        ll.addLast("C"); // Adds to the last position
        ll.add(2, "D"); // Adds at 2nd index
        System.out.println(ll);
        // Removing elements
        ll.remove(3); // Removes 3rd index
        ll.remove("A"); // Removes element if you specify element
        ll.removeFirst(); // Removes the 1st element
        ll.removeLast(); // Removes the last element
        System.out.println(ll);


    }
}
