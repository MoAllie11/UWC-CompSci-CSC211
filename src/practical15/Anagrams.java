//4590147
package practical15;
import java.io.*;
import java.util.*;

public class Anagrams {

    //clean word (remove punctuation except apostrophes, lowercase)
    private static String cleanWord(String w) {
        return w.replaceAll("[^a-zA-Z']", "").toLowerCase();
    }

    //generate signature (alphabetize characters)
    private static String signature(String w) {
        char[] chars = w.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}