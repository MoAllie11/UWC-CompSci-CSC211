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

    public static void main(String[] args) {
        //use Set to avoid duplicates
        Map<String, Set<String>> anagramDict = new HashMap<>();

        //read file
        try (BufferedReader br = new BufferedReader(new FileReader("ulysses.text"))) {
            String line;
            while ((line = br.readLine()) != null) {
                //split into words
                String[] words = line.split("\\s+");
                for (String w : words) {
                    w = cleanWord(w);
                    if (!w.isEmpty()) {
                        //generate signature
                        String key = signature(w);

                        //group words by signature (unique only)
                        anagramDict.computeIfAbsent(key, k -> new HashSet<>()).add(w);
                    }
                }
            }
        }
    }
}