package stream_functional;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;


// test advanced stream function
//add more comments
public class TestAdvancedStreamFunctional {
	public static void main(String[] args) {
		List<Person> persons =
			    Arrays.asList(
			        new Person("Max", 18),
			        new Person("Peter", 23),
			        new Person("Pamela", 23),
			        new Person("David", 12));
		
		List<Person> filtered =
			    persons
			        .stream()
			        .filter(p -> !p.name.startsWith("P"))
			        .collect(Collectors.toList());

			System.out.println(filtered);    // [Peter, Pamela]
			
		Map<Integer, List<Person>> personByAge  = 
				persons
				.stream()
				.collect(Collectors.groupingBy(p->p.age));   //it groups persons by age, return a Map which age is the key, persons are the value 
		personByAge.forEach( (age,p) -> System.out.println("age = "+age +"; person = " + p)  );
		
		IntSummaryStatistics  ageSummary = 
				persons
				.stream()
				.collect(Collectors.summarizingInt(p -> p.age));
		System.out.println(ageSummary);
		
		Map<Integer, String> map = persons
			    .stream()
			    .collect(Collectors.toMap(
			        p -> p.age,
			        p -> p.name,
			        (name1, name2) -> name1 + "--" + name2));

		System.out.println(map);
			// {18=Max, 23=Peter;Pamela, 12=David}
		
		/**
		 * Since strings in Java are immutable, we need a helper class like StringJoiner to let 
		 * the collector construct our string. The supplier initially constructs such a StringJoiner with 
		 * the appropriate delimiter. The accumulator is used to add each persons upper-cased name to the 
		 * StringJoiner. The combiner knows how to merge two StringJoiners into one. 
		 * In the last step the finisher constructs the desired String from the StringJoiner.
		 */
		
		Collector<Person, StringJoiner, String> personNameCollector =
			    Collector.of(
			        () -> new StringJoiner(" | "),          // supplier
			        (j, p) -> j.add(p.name.toUpperCase()),  // accumulator
			        (j1, j2) -> j1.merge(j2),               // combiner
			        StringJoiner::toString);                // finisher

			String names = persons
			    .stream()
			    .collect(personNameCollector);

			System.out.println(names);  // MAX | PETER | PAMELA | DAVID
		
	}

}
