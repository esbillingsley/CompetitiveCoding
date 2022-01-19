import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class SpyString implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new SpyString(), "whatever", 1<<26).start();
    }

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        int tests = scanner.nextInt();

        for (int t = 0; t < tests; t++) {
            int strings = scanner.nextInt();
            int n = scanner.nextInt();
            char[][] input = new char[strings][n];
            for (int i = 0; i < strings; i++) {
                input[i] = scanner.next().toCharArray();
            }
            char[] bestString = new char[n];
            for (int i = 0; i < n; i++) {
                int[] hist = new int[123];
                for (int j = 0; j < strings; j++) {
                    hist[(int) input[j][i]]++;
                }
                int max = 0;
                int bestI = 0;
                for (int k = 0; k < 123; k++) {
                    if (hist[k] > max) {
                        max = hist[k];
                        bestI = k;
                    }
                }
                bestString[i] = (char) bestI;
            }
            int[] counts = new int[strings];
            boolean canMake = true;
            for (int i = 0; i < strings; i++) {
                for (int j = 0; j < n; j++) {
                    if (input[i][j] != bestString[j]) {
                        counts[i]++;
                        if (counts[i] > 1) {
                            canMake = false;
                        }
                    }
                }
            }
            if (canMake) {
                for (int i = 0; i < n; i++) {
                    answers.append(bestString[i]);
                }
                answers.append("\n");
            }
            else {
                answers.append("-1\n");
            }
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
