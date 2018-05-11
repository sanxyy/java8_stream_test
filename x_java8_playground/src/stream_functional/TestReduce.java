package stream_functional;

import java.util.Arrays;
import java.util.List;

public class TestReduce {
	
	public static void main(String args[]) {
		List<Person> persons =
			    Arrays.asList(
			        new Person("Max", 18),
			        new Person("Peter", 23),
			        new Person("Pamela", 23),
			        new Person("David", 12));
	
		persons
	    .stream()                       //reduces a stream of elements to exactly one element of the stream
	    .reduce((p1, p2) -> p1.age > p2.age ? p1 : p2)  //find the oldest person
	    .ifPresent(System.out::println);    // Pamela
		
		Person result =
			    persons
			        .stream()
			        .reduce(new Person("", 0), (p1, p2) -> {
			            p1.age += p2.age;
			            p1.name += p2.name;
			            return p1;
			        });

			System.out.format("name=%s; age=%s\n", result.name, result.age);
			// name=MaxPeterPamelaDavid; age=76
		   
		   Integer ageSum = persons
				    .stream()
				    .reduce(0,
				        (sum, p) -> {
				            System.out.format("accumulator: sum=%s; person=%s\n", sum, p);
				            return sum += p.age;
				        },
				        (sum1, sum2) -> {
				            System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
				            return sum1 + sum2;
				        });
		   System.out.println(ageSum);  // 76
			
				// accumulator: sum=0; person=Max
				// accumulator: sum=18; person=Peter
				// accumulator: sum=41; person=Pamela
				// accumulator: sum=64; person=David
		
	}

}
