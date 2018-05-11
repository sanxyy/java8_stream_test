package x_java8_playground;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TestFlashMap2 {
	 public static void main(String[] args) {

	        Student obj1 = new Student();
	        obj1.setName("mkyong");
	        obj1.addBook("Java 8 in Action");
	        obj1.addBook("Spring Boot in Action");
	        obj1.addBook("Effective Java (2nd Edition)");

	        Student obj2 = new Student();
	        obj2.setName("zilap"); 
	        obj2.addBook("Learning Python, 5th Edition");
	        obj2.addBook("Effective Java (2nd Edition)");

	        List<Student> list = new ArrayList<>();
	        list.add(obj1);
	        list.add(obj2);
	        
	        
	        List<String> collect =
	                list.stream()
	                        .map(x -> x.getBook())      //Stream<Set<String>>  , get 2 String sets
	                        .flatMap(x -> x.stream())   //Stream<String>  , get a flat map which contains 5 books
	                        .distinct()   //get a stream contains distinct element (5 books -> 4 books)
	                        .collect(Collectors.toList());

	        collect.forEach(x -> System.out.println(x));
	    }

	}


