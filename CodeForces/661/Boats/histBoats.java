import java.util.*;
import java.lang.StringBuilder;

public class Boats {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        StringBuilder answers = new StringBuilder();
        for (int i=0; i<testCases; i++) {
            int listLength = scan.nextInt();
            int[] histogram = new int[104];

            for (int j = 0; j < listLength; j++) {
                histogram[scan.nextInt()]++;
            }

            int best = 0;
            for (int w = 0; w <= 102; w++) {

                int sum = 0;
                for (int k = 0; k * 2 < w; k++) {
                    sum += Integer.min(counts[k], counts[w-k]);
                }

                // w is multiple of 2, special
                if (w % 2 == 0) {
                    sum += counts[w/2]/2;
                }
                best = Integer.max(best, sum);
            }
            answers.append(teamCount + "\n");
        }

    System.out.println(answers);
    }
}
