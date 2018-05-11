package x_java8_playground;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


/**
 * Demonstrate how to use filter and map, collection method of Stream
 * 
 * @author chensan
 *
 */
public class TestFilterMap {

	public static void main(String args[]) {

		String fileName = "c://temp//line.txt";
		List<String> list = new ArrayList<>();

		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

			//1. filter out line start with 'line 3'
			//2. convert all content to upper case, pass a toUpperCase method
			//3. convert it into a List
			list = stream
					.filter(line -> line.startsWith("line3"))
					.map(String::toUpperCase)
					.collect(Collectors.toList());

		} catch (IOException e) {
			e.printStackTrace();
		}

		list.forEach(System.out::println);

	}

}