package practical14;
import java.util.LinkedList;

public class openHash {
    private int m; //no. of buckets
    private LinkedList<Entry>[] table;

    private static class Entry{ //Inner class for k/v pairs
        String key;
        String value;

        Entry(String key, String value){
            this.key = key;
            this.value = value;
        }
    }
    public openHash(int m){
        this.m = m;
        table = new LinkedList[m];
        for (int i=0; i<m; i++){
            table[i] = new LinkedList<>();
        }
    }
}
