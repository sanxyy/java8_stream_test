package stream_functional;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;




public class Misc {

	public static void main(String[] args) {	
		
		List<String> misc = Arrays.asList("a","b","","d");
		//Stream<String> s = 
		List<String> nonEmpty =	misc.stream().filter(s -> !s.isEmpty()).collect(Collectors.toList());
		//nonEmpty.forEach(System.out::println);
		
		List<Integer> intList = Arrays.asList(1,2,2,2,3,4,5);
		intList.stream().map( i-> (i*i)).distinct().collect(Collectors.toList()).forEach(System.out::println);
		
		System.out.println("Random IntStream ");
		Random r = new Random();
		r.ints().limit(10).forEach(System.out::println);
		
		System.out.println("Random Sorted stream");
		Random r1 = new Random();		
		r1.ints(1,100).limit(10).sorted().forEach(System.out::println);
		
		System.out.println("xxxxxxxxxxxxxx parallel stream ");
		Random r2 = new Random();		
		int maxLength = 1000000;
		//Integer[] spam  = new Integer[maxLength];
		List<Integer> spma = new LinkedList<Integer>();
		r2.ints(1,1000).limit(maxLength).forEach(x -> spma.add(x));
		//Arrays.asList(spam);
		spma.parallelStream()
		.filter(y -> y<1000 )
		.map(y -> y*y).
		collect(Collectors.toList()).forEach(System.out::println);
		
		
	}

}
