import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class CandyGame implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new CandyGame(), "whatever", 1<<26).start();
    }

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        int tests = scanner.nextInt();

        for (int t = 0; t < tests; t++) {
            int n = scanner.nextInt();
            int[] candies = new int[n];
            for (int i = 0; i < n; i++) {
                candies[i] = scanner.nextInt();
            }
            int l = 0;
            int r = n - 1;
            int lCandy = 0;
            int rCandy = 0;
            int moves = 0;
            int last = 0;
            while (l <= r) {
                int eaten = 0;
                if (moves == 0) {
                    eaten = candies[l];
                    lCandy += candies[l];
                    l++;
                }
                else if (moves % 2 == 0) {
                    while (eaten <= last && l <= r) {
                        eaten += candies[l];
                        lCandy += candies[l];
                        l++;
                    }
                }
                else {
                    while (eaten <= last && l <= r) {
                        eaten += candies[r];
                        rCandy += candies[r];
                        r--;
                    }
                }
                last = eaten;
                moves++;
            }
            answers.append(moves + " " + lCandy + " " + rCandy + "\n");
        }
        System.out.println(answers);
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(Reader in) {
            br = new BufferedReader(in);
        }

        public FastScanner(InputStream in) {
            this(new InputStreamReader(in));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
        public long nextLong() {
            return Long.parseLong(next());
        }
        public double nextDouble() { return Double.parseDouble(next());}

    }
}
