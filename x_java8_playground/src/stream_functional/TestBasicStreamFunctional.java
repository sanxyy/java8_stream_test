package stream_functional;

import java.util.Arrays;
import java.util.stream.Stream;

public class TestBasicStreamFunctional {

	public static void main(String[] args) {
		Stream.of("a1", "b1", "c1").findFirst().ifPresent(System.out::println);
		Stream.of("a1", "b1", "c1").forEach(x -> System.out.println(x + " "));

		Arrays.stream(new int[] { 1, 2, 3 }).map(n -> 2 * n + 1).average().ifPresent(System.out::println); // 5.0

		Arrays.stream(new int[] { 1, 2, 3, 4, 5, 6 }).filter(y -> y > 2).max().ifPresent(System.out::println);
		// Arrays.stream(new int[] {1, 2, 3}).map( x ->
		// x*x).forEach(System.out::println);
		
		Stream.of("a", "b", "c")
		.filter(x -> {                                 // intermediate operations is laziness ...
			System.out.println("inside filter " +x);    //the print will not be executed since there is no terminal operation
			return true;
		});
		
		Stream.of("a", "b", "c")
		.filter(x -> {
			System.out.println("in the filter " + x);    //check the exe results ..
			return true;
		}).forEach(System.out::println);;
		
		
		
		Stream.of("d2", "a2", "b1", "b3", "c")
	    .map(s -> {
	        System.out.println("map: " + s);
	        return s.toUpperCase();
	    })
	    .filter(s -> {
	        System.out.println("filter: " + s);     //forEach is only called once.
	        return s.startsWith("A");
	    })
	    .forEach(s -> System.out.println("forEach: " + s)); //A2 is the only element to be processed in forEach method
		
		
		Stream.of("d2", "a2", "b1", "b3", "c")
	    .sorted((s1, s2) -> {								//sort elements first
	        System.out.printf("sort: %s; %s\n", s1, s2);     
	        return s1.compareTo(s2);
	    })
	    .filter(s -> {										//filter if element starts with 'a'
	        System.out.println("filter: " + s);
	        return s.startsWith("a");
	    })
	    .map(s -> {											//apply given function to the elements of this stream
	        System.out.println("map: " + s);
	        return s.toUpperCase();
	    })
	    .forEach(s -> System.out.println("forEach: " + s));  //forEach is terminal operation and returns void
		
		
		//the below is an optimization of the function above, fewer execution steps but same result
		Stream.of("d2", "a2", "b1", "b3", "c")
	    .filter(s -> {
	        System.out.println("filter: " + s);
	        return s.startsWith("a");
	    })
	    .sorted((s1, s2) -> {
	        System.out.printf("sort: %s; %s\n", s1, s2);
	        return s1.compareTo(s2);
	    })
	    .map(s -> {
	        System.out.println("map: " + s);
	        return s.toUpperCase();
	    })
	    .forEach(s -> System.out.println("forEach: " + s));
		
	}

}
