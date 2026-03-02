package practical14;
import java.util.LinkedList;

public class openHash {
    private int m; // no. of buckets
    private LinkedList<Entry>[] table;
    private int size; // no. of k/v pairs stored

    private static class Entry {
        String key;
        String value;

        Entry(String key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    public openHash(int m) {
        this.m = m;
        table = new LinkedList[m];
        for (int i = 0; i < m; i++) {
            table[i] = new LinkedList<>();
        }
        size = 0;
    }

    //scatter function
    public int hash(String key) {
        int h = key.hashCode();
        h = Math.abs(h) % m; // ensure index in [0..m-1]
        return h;
    }

    //insert method
    public void insert(String key, String value) {
        int index = hash(key);
        for (Entry e : table[index]) {
            if (e.key.equals(key)) {
                e.value = value; // update existing
                return;
            }
        }
        table[index].add(new Entry(key, value));
        size++;
    }

    //lookup method
    public String lookup(String key) {
        int index = hash(key);
        for (Entry e : table[index]) {
            if (e.key.equals(key)) {
                return e.value;
            }
        }
        return null;
    }

    //remove method
    public String remove(String key) {
        int index = hash(key);
        for (Entry e : table[index]) {
            if (e.key.equals(key)) {
                String val = e.value;
                table[index].remove(e);
                size--;
                return val;
            }
        }
        return null; // not found
    }

    public boolean isInTable(String key) {
        return lookup(key) != null;
    }

    public boolean isFull() {
        return size >= m; // full if size reaches capacity
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
