//4590147
package practical13;
// Code is stored as 13template.java
import java.lang.Math.*;
import java.io.*;
import java.text.*;
import java.text.DecimalFormat;
import java.util.Random;

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

    public static void main(String args[]) {

        DecimalFormat twoD = new DecimalFormat("0.00");
        DecimalFormat fourD = new DecimalFormat("0.0000");
        DecimalFormat fiveD = new DecimalFormat("0.00000");

        int[] data = generateData(N);
        Random rand = new Random();

        // Linear search timing
        double runTimeLinear = 0, runTimeLinear2 = 0;
        for (int repetition = 0; repetition < repetitions; repetition++) {
            int key = rand.nextInt(N) + 1;
            long start = System.currentTimeMillis();
            linearSearch(data, key);
            long finish = System.currentTimeMillis();
            double time = (double) (finish - start);
            runTimeLinear += time;
            runTimeLinear2 += (time * time);
        }
        double aveLinear = runTimeLinear / repetitions;
        double stdLinear = Math.sqrt(runTimeLinear2 - repetitions * aveLinear * aveLinear) / (repetitions - 1);

        // Binary search timing
        double runTimeBinary = 0, runTimeBinary2 = 0;
        for (int repetition = 0; repetition < repetitions; repetition++) {
            int key = rand.nextInt(N) + 1;
            long start = System.currentTimeMillis();
            binarySearch(data, key);
            long finish = System.currentTimeMillis();
            double time = (double) (finish - start);
            runTimeBinary += time;
            runTimeBinary2 += (time * time);
        }
        double aveBinary = runTimeBinary / repetitions;
        double stdBinary = Math.sqrt(runTimeBinary2 - repetitions * aveBinary * aveBinary) / (repetitions - 1);

        long start, finish;
        double runTime = 0, runTime2 = 0, time;
        double totalTime = 0.0;
        int n = N;
        int repetition, repetitions = 30;

        runTime = 0;
        for (repetition = 0; repetition < repetitions; repetition++) {
            start = System.currentTimeMillis();

            finish = System.currentTimeMillis();

            time = (double) (finish - start);
            runTime += time;
            runTime2 += (time * time);
        }

        double aveRuntime = runTime / repetitions;
        double stdDeviation =
                Math.sqrt(runTime2 - repetitions * aveRuntime * aveRuntime) / (repetitions - 1);

        // Print results
        System.out.println("\nStatistics\n");
        System.out.println("Linear Search Average Time = " + fiveD.format(aveLinear / 1000) + "s ± " + fourD.format(stdLinear) + "ms");
        System.out.println("Binary Search Average Time = " + fiveD.format(aveBinary / 1000) + "s ± " + fourD.format(stdBinary) + "ms");
        System.out.println("Repetitions = " + repetitions);
    }
}