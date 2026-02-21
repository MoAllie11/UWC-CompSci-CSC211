package practical11;
import java.util.*;

public class shufflePrac {
    private static Random rand = new Random();
    //slow shuffle
    public static int[] slowShuffle(int N){
        int [] shuffled = new int[N];
        boolean[] isNotPresent = new boolean[N+1];
        Arrays.fill(isNotPresent, true);
        int count = 0;

        while (count < N-1){
            int r = rand.nextInt(N) + 1;
            if (isNotPresent[r]){
                shuffled[count] = r;
                isNotPresent[r] = false;
                count++;
            }
        }
        for (int i=1; i <= N; i++){
            if (isNotPresent[i]){
                shuffled[N-1] = i;
                break;
            }
        }
        return shuffled;
    }
    //biased shuffle
    public static int[] biasedShuffle(int N){
        int[] shuffled = new int[N];
        for (int i=0; i<N; i++){
            shuffled[i] = i+1;
        }
        for (int i=0; i<N; i++){
            int r = rand.nextInt(N);
            swap(shuffled, i, r);
        }
        return shuffled;
    }
    //unbiased shuffle
    public static int[] shuffle(int N){
        int[] shuffled = new int[N];
        for (int i=0; i<N; i++){
            shuffled[i] = i + 1;
        }
        for (int i=0; i<N; i++){
            int r = i + rand.nextInt(N-i);
            swap(shuffled, i, r);
        }
        return shuffled;
    }
    //swapper
    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    //testing N
    public static void testShuffleFrequencies(){
        int N=3;
        int trials=60000;
        System.out.println("Testing BIASED shuffle: ");
        testMethod(N, trials, true);
        System.out.println("Testing UNBIASED shuffle: ");
        testMethod(N, trials, false);
    }

    private static void testMethod(int N, int trials, boolean biased){
        Map<String, Integer> countMap = new HashMap<>();
        for (int t=0; t<trials; t++){
            int[] result = biased ? biasedShuffle(N) : shuffle(N);
            String key = "";
            for (int i=0; i<N; i++){
                key += result[i];
            }
            countMap.put(key, countMap.getOrDefault(key,0)+1);
        }
        for (String key : countMap.keySet()){
            System.out.println(key + " -> " + countMap.get(key));
        }
    }

    public static void main(String[] args){
        int N=10;
        System.out.println("Slow Shuffle: ");
        System.out.println(Arrays.toString(slowShuffle(N)));

        System.out.println("\nBiased Shuffle: ");
        System.out.println(Arrays.toString(biasedShuffle(N)));

        System.out.println("\nUnbiased Shuffle: ");
        System.out.println(Arrays.toString(shuffle(N)));

        System.out.println("\n--- Frequency Test (N=3, 60000 runs) ---");
        testShuffleFrequencies();
    }
}