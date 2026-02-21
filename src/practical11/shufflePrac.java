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
}