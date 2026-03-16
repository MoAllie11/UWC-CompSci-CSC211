//4590147

package practical16;
import java.io.*;
import java.util.*;

public class tryHeapSort {
    //clean word (remove punctuation except apostrophes, lowercase)
    private static String cleanWord(String w) {
        return w.replaceAll("[^a-zA-Z']", "").toLowerCase();
    }

    private static void swap(String[] arr, int i, int j){
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    //Bottom-up heapify
    private static void heapify(String[] arr, int n, int i){
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        if(left<n && arr[left].compareTo(arr[largest])>0) largest = left;
        if(right<n && arr[right].compareTo(arr[largest])>0) largest = right;

        if (largest != i){
            swap(arr, i, largest);
            heapify(arr, n, largest);
        }
    }
    //Build heap bottom-up
    private static void buildHeapBottomUp(String[] arr){
        int n = arr.length;
        for (int i=n/2 -1; i>=0; i--){
            heapify(arr, n, i);
        }
    }
    //Insert for top-down
    public static void insertTopDown(List<String> heap, String value){
        heap.add(value);
        int i = heap.size()-1;
        while(i>0){
            int parent = (i-1)/2;
            if(heap.get(i).compareTo(heap.get(parent))>0){
                Collections.swap(heap, i, parent);
                i = parent;
            } else break;
        }
    }
    //Heap sort
    private static void heapSort(String[] arr){
        buildHeapBottomUp(arr);
        for(int i = arr.length - 1; i>0; i--){
            swap(arr,0,i);
            heapify(arr, i, 0);
        }
    }

    //Read and clean words
    private static List<String> readWords(String filename) throws IOException {
        List<String> words = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split("\\s+");
                for (String w : tokens) {
                    w = cleanWord(w);
                    if (!w.isEmpty()) words.add(w);
                }
            }
        }
        return words;
    }
    //Main
    public static void main(String[] args) throws IOException{
        //String[] test = {"banana", "kiwi", "grape", "apple", "orange", "granadilla", "mango"};
        List <String> words = readWords("ulysses.text");
        String[] arrBU = words.toArray(new String[0]);
        //Bottom-up build and sort
        long startBU = System.nanoTime();
        heapSort(arrBU);
        long endBU = System.nanoTime();
        System.out.println("Bottom-up sorted: " + Arrays.toString(arrBU));
        System.out.println("Bottom-up time: " + (endBU - startBU) + "ns");

        //Top-down build
        List<String> heapTD = new ArrayList<>();
        long startTD = System.nanoTime();
        for(String w : words) insertTopDown(heapTD, w);
        long endTD = System.nanoTime();
        System.out.println("Top-down heap size: " + heapTD.size());
        System.out.println("Top-down build time: " + (endTD - startTD) + "ns");

        // Convert top-down heap to array and sort
        String[] arrTD = heapTD.toArray(new String[0]);
        long startSortTD = System.nanoTime();
        heapSort(arrTD);
        long endSortTD = System.nanoTime();
        System.out.println("Top-down sorted: " + Arrays.toString(arrTD));
        System.out.println("Top-down sort time: " + (endSortTD - startSortTD) + " ns");
    }
}
