package misc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {
    public static void main(String[] args) {
        // maps - Use the map method to apply a function to all the elements of a list
        List<Integer> l1 = new ArrayList<>();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.add(4);
        // without stream
        List<Integer> squares = new ArrayList<>();
        for (Integer i: l1) {
            squares.add(i*i);
        }
        System.out.println(squares);
        // with streams
        List<Integer> cubes = l1.stream().map(x -> x*x*x).collect(Collectors.toList());
        System.out.println(cubes);

        // filter - to filter elements in a list
        List<String> vehicles = Arrays.asList("car", "motorbike", "bicycle", "truck", "tuktuk");
        // without streams
        List<String> filtered = new ArrayList<>();
        for (String i: vehicles) {
            if (i.startsWith("t")) {
                filtered.add(i);
            }
        }
        System.out.println(filtered);
        // with streams
        List<String> filtered2 = vehicles.stream().filter(x -> x.startsWith("t")).collect(Collectors.toList());
        System.out.println(filtered2);

        // sorted
        List<String> sortedVehicles = vehicles.stream().sorted().collect(Collectors.toList());
        System.out.println(sortedVehicles);

        // forEach
        vehicles.stream().forEach(x -> System.out.println(x));

        // reduce - used when you have to reduce a list to a single value
        // without streams
        int total = 0;
        for (int num : l1) {
            total += num;
        }
        System.out.println("Total of all elements is " + total);
        // with streams
        int total2 = 0;
        total2 = l1.stream().reduce(0, (ans, i) -> ans+i);
        // 0 --> identity (initial value)
        // (ans, 1) --> accumulator (ans is the ongoing partial result and i is the next element of the stream)
        System.out.println("Total of all elements is " + total2);
    }
}
