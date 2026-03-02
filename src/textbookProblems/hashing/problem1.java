//Insert the keys E A S Y Q U T I O N in that order into an initially empty table
//of M = 5 lists, using separate chaining. Use the hash function 11 k % M to transform
//the kth letter of the alphabet into a table index.

package textbookProblems.hashing;
import java.util.LinkedList;
import java.util.*;

public class problem1 {
        static int M = 5; // table size
        static LinkedList<String>[] table = new LinkedList[M];

        public static void main(String[] args) {
            String[] keys = {"E", "A", "S", "Y", "Q", "U", "T", "I", "O", "N"};

            // Initialize each list
            for (int i = 0; i < M; i++) {
                table[i] = new LinkedList<>();
            }

            // Insert each key
            for (String key : keys) {
                int index = hash(key);
                table[index].add(key);
                System.out.println("Inserted " + key + " at index " + index);
            }

            // Display the table
            System.out.println("\nHash Table:");
            for (int i = 0; i < M; i++) {
                System.out.println(i + ": " + table[i]);
            }
        }

        // Hash function: position of letter in alphabet % M
        static int hash(String key) {
            char ch = key.charAt(0);
            int position = ch - 'A' + 1;
            return position % M;
        }
    }
