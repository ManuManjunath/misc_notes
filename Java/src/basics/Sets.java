package basics;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Sets {

    public static void main(String[] args) {
        System.out.println("Sets........");
        Set<String> langSet = new HashSet<>(5); // Optional to add initial capacity, but recommended in order to save memory
        langSet.add("HTML");
        langSet.add("CSS");
        langSet.add("JavaScript");
        // Won't matter if you re add one of the elements -
        langSet.add("CSS");
        System.out.println(java.util.Arrays.toString(langSet.toArray()));
        System.out.println(langSet.size());
        // To check if an element is present in a set
        System.out.println(langSet.contains("CSS"));

        Set<Integer> divisibleBy2 = new HashSet<>(java.util.Arrays.asList(2, 4, 6, 8, 10));
        Set<Integer> divisibleBy3 = new HashSet<>(java.util.Arrays.asList(3, 6, 9));
        // Intersect
        Set<Integer> intersect = new HashSet<>(divisibleBy2);
        intersect.retainAll(divisibleBy3);
        System.out.println(java.util.Arrays.toString(intersect.toArray()));
        // Union
        Set<Integer> union = new HashSet<>(divisibleBy2);
        union.addAll(divisibleBy3);
        for (Integer nn : union) {
            System.out.println(nn);
        }
        // To remove values
        divisibleBy2.remove(10);
        // To have a sorted set, use TreeSet
        TreeSet<String> ts = new TreeSet<String>();
        ts.add("B");
        ts.add("C");
        ts.add("A");
        System.out.println(ts);
        System.out.println(java.util.Arrays.toString(ts.toArray()));

        // Converting a hash set to a tree set
        Set<String> sortedSet = new TreeSet<>(langSet);
        System.out.println(java.util.Arrays.toString(sortedSet.toArray()));
    }
}
