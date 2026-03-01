package myCode;
import java.util.*;

public class hashTables {
    public static void main(String[] args){
        Hashtable<String,String> table = new Hashtable<>(10);//declare hashTable called table
        //note we could have Hashtable<Integer, String>
        table.put("100", "Van Dijk"); //put method fills our hashTable with keys
        table.put("123", "Salah");
        table.put("321", "Szoboszlai");
        table.put("555", "Alisson");
        table.put("777", "Ekitike");

        /*table.remove(100); //removes pairs using key as input
        table.remove(123);
        table.remove(555);
        */

        //use key.hashCode() to get hashcode value

        System.out.println("After removal: ");
        for (String key : table.keySet()){ //for loop to display all key-value pairs
            System.out.println(key.hashCode() % 10 + "\t" + key + "\t" + table.get(key));
        //key.hashCode()%10 gives us our index value in hash table
        }
        //Note after displaying that we do have collisions
    }
}
