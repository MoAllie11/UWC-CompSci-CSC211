package practical14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class hashPrac {
    public static void main(String[] args){
        int N = 1 <<20;

        int[] keys = new int[N];
        for (int i = 0; i < N; i++) {
            keys[i] = i;
        } //array of integers from 0 to N-1

        List<Integer> keyList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            keyList.add(keys[i]);
        }
        Collections.shuffle(keyList);

        String[][] keyValuePairs = new String[N][2]; // [key, value]

        for (int i = 0; i < N; i++) {
            String key = String.valueOf(keyList.get(i));
            String value = String.valueOf(i + 1); // numbering from 1 to N
            keyValuePairs[i][0] = key;
            keyValuePairs[i][1] = value;
        }

        int usableSize = 950_000;
        String[][] usablePairs = Arrays.copyOfRange(keyValuePairs, 0, usableSize);

    }
}
    /*long start, finish;
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
/*/