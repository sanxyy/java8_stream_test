package x_java8_playground;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * 
 * demonstrate how to use the Optional class in JDK 8
 * @author chensan
 *
 */

public class TestOptional {

    static Optional<String> getNickName(String name) {
        Map<String, String> nickNames = new HashMap<>();
        nickNames.put("Justin", "caterpillar");
        nickNames.put("Monica", "momor");
        nickNames.put("Irene", "hamimi");
        String nickName = nickNames.get(name);
        //Return Optional object with empty value if not found
        return nickName == null ? Optional.empty() : Optional.of(nickName);
    }
	
	public static void main(String[] args) {

        Optional<String> nickName = getNickName("Irene");
        //Optional<String> nickName = getNickName("Dude");
        
        // the orElse method returns a 'default value' if the Optional object is empty  
        System.out.println(nickName.orElse("default value"));
        
        //check if the value presented
        
        if(nickName.isPresent()) {
        	System.out.println(nickName.get());
        }
        
        
        

	}

}
