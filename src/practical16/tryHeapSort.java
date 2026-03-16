//4590147

package practical16;
import java.io.*;
import java.util.*;

public class tryHeapSort {
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
    //Main
}
