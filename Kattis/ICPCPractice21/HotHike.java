import java.util.Scanner;

public class HotHike {

    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] temps = new int[n];
        for (int i = 0; i < n; i++) {
            temps[i] = scanner.nextInt();
        }
        int minMax = Integer.MAX_VALUE;
        int day = 1;
        for (int i=0; i< temps.length-2; i++) {
            int test = Math.max(temps[i], temps[i+2]);
            if (test < minMax) {
                minMax = test;
                day = i + 1;
            }
        }
        System.out.println(day + " " + minMax);
    }
}
