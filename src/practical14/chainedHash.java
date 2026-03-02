package practical14;
import java.util.LinkedList;

public class chainedHash {
    private int m; //no. of buckets
    private LinkedList<Entry>[] table;
    private int size; //no. of k/v pairs stored

    private static class Entry{
        String key;
        String value;

        Entry(String key, String value){
            this.key = key;
            this.value = value;
        }
    }
    public chainedHash(int m){
        this.m = m;
        table = new LinkedList[m];
        for (int i=0; i<m; i++){
            table[i] = new LinkedList<>();
        }
        size = 0;
    }
    //scatter function
    public int hash(String key){
        int h = key.hashCode();
        h = Math.abs(h) % m;
        return h;
    }
    //insert method
    public void insert(String key, String value){
        int index = hash(key);
        for (Entry e : table[index]){
            if (e.key.equals(key)){
                e.value = value;
                return;
            }
        }
        table[index].addLast(new Entry(key,value));
        size++;
    }
    //lookup method
}