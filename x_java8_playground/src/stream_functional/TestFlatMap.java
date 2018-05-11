package stream_functional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


public class TestFlatMap {
	
	class Foo {
	    String name;
	    List<Bar> bars = new ArrayList<>();

	    Foo(String name) {
	        this.name = name;
	    }
	}

	class Bar {
	    String name;

	    Bar(String name) {
	        this.name = name;
	    }
	}
	
	public void testIt() {
		List<Foo> foos = new ArrayList<>();

		// create foos List
		IntStream
		    .range(1, 4)
		    .forEach(i -> foos.add(new Foo("Foo" + i)));  //create 3 Foos object in the alist

		// create bars object within each Foos list (this results in a 3x3 object array)
		foos.forEach(f ->
		    IntStream
		        .range(1, 4)
		        .forEach(i -> f.bars.add(new Bar("Bar" + i + " <- " + f.name))));   //create 3 bars 
		
		foos.stream()
	    .flatMap(f -> f.bars.stream())    // transforms the stream of three foo objects into a stream of nine bar objects.
	    .forEach(b -> System.out.println(b.name));
	}
	
	public void testFlatMap2() {
		
	}

	
	public static void main(String[] args) {
		TestFlatMap tfmap = new TestFlatMap();
		tfmap.testIt();
	}

}
