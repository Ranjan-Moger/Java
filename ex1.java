
package assignment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 *
 * @author Ranjan
 */
public class ex1 {
    
    public static void main(String[] args)
    {
        
      String[] myArray = new String[]{"ranjan","moger","virat","dhoni","ramakrishna"};
        System.out.println("Original Array : ");
        for(String n : myArray)
        {
            System.out.print(n+" ");
        }
        System.out.println();
        //Map
      String[] myNewArray = Arrays.stream(myArray)
                .map(s -> s.toUpperCase())
                .toArray(String[]::new);
       
        System.out.println("After Map :");
        for(String n : myNewArray)
        {
            System.out.print(n+" ");
        }
        System.out.println();
        
        //filter
      String[] myAnotherArray = Arrays.stream(myNewArray)
                .filter(s -> s.length() > 5)
                .toArray(String[]::new);
        System.out.println("After Filter : "); 
        for(String n : myAnotherArray)
        {
            System.out.print(n+" ");
        }
        System.out.println();
        
        //reduce
        System.out.println("After Reduce : ");
        String s = Arrays.stream(myAnotherArray)
                .reduce("", (a,b) -> a+b);
        
        System.out.println(s);
       
    }
    
}
