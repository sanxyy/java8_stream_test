package x_java8_playground;
import java.util.Arrays;
import java.util.stream.Stream;


/**
 * 
 * How flatMap() works :

{ {1,2}, {3,4}, {5,6} } -> flatMap -> {1,2,3,4,5,6}

{ {'a','b'}, {'c','d'}, {'e','f'} } -> flatMap -> {'a','b','c','d','e','f'}

 * 
 * 
 * 
 * @author chensan
 *
 */

public class TestFlatMap {
    public static void main(String[] args) {

        String[][] data = new String[][]{{"a", "b"}, {"c", "d"}, {"e", "f"},{"a","a"}};

        //this get a Stream<String[]>     {{"a", "b"}, {"c", "d"}, {"e", "f"}}
        Stream<String[]> temp = Arrays.stream(data);

        //this gets a Stream<String>  {"a","b","c","d","e","f"}
        Stream<String> stringStream = temp.flatMap(x -> Arrays.stream(x));        
        // this leaves only "a" character
        Stream<String> stream = stringStream.filter( x -> "a".equals(x.toString()) );
        System.out.println(stream.count());
        //stream.forEach(System.out::println);
        
        //stream.forEach(System.out::println);
        
    }

}
