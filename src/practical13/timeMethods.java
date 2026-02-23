//4590147
package practical13;
// Code is stored as 13template.java
import java.lang.Math.*;
import java.io.*;
import java.text.*;

public class timeMethods{
    public static int N = 32654; //max key range
    public static int repetitions = 30;

    static int[] generateData(int n) {
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = i + 1; // sorted for binary search
        }
        return data;
    }

    // Linear search
    static boolean linearSearch(int[] arr, int key) {
        for (int value : arr) {
            if (value == key) return true;
        }
        return false;
    }

    // Binary search
    static boolean binarySearch(int[] arr, int key) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == key) return true;
            else if (arr[mid] < key) low = mid + 1;
            else high = mid - 1;
        }
        return false;
    }

    public static void main(String args[]){

        DecimalFormat twoD = new DecimalFormat("0.00");
        DecimalFormat fourD = new DecimalFormat("0.0000");
        DecimalFormat fiveD = new DecimalFormat("0.00000");

        long start, finish;
        double runTime = 0, runTime2 = 0, time;
        double totalTime = 0.0;
        int n = N;
        int repetition, repetitions = 30;

        runTime = 0;
        for(repetition = 0; repetition < repetitions; repetition++) {
            start = System.currentTimeMillis();

            // call the procedures to time here:
            linearsearch (...);
            binarysearch (...);
            // Figure out how to alter this guideline here,

            finish = System.currentTimeMillis();

            time = (double)(finish - start);
            runTime += time;
            runTime2 += (time*time); }

        double aveRuntime = runTime/repetitions;
        double stdDeviation =
                Math.sqrt(runTime2 - repetitions*aveRuntime*aveRuntime)/(repetitions-1);

        System.out.printf("\n\n\fStatistics\n");
        System.out.println("________________________________________________");
        System.out.println("Total time   =           " + runTime/1000 + "s.");
        System.out.println("Total time\u00b2  =           " + runTime2);
        System.out.println("Average time =           " + fiveD.format(aveRuntime/1000)
                + "s. " + '\u00B1' + " " + fourD.format(stdDeviation) + "ms.");
        System.out.println("Standard deviation =     " + fourD.format(stdDeviation));
        System.out.println("n            =           " + n);
        System.out.println("Average time / run =     " + fiveD.format(aveRuntime/n*1000)
                + '\u00B5' + "s. ");

        System.out.println("Repetitions  =             " + repetitions);
        System.out.println("________________________________________________");
        System.out.println();
        System.out.println(); }	}

static void oneofyourMethods(int n,
                             yourMethodParameter1,
                             yourMethodParameter2, . . . ) {
// The declarations and body of your method / s
// The final statement of this code.} }
