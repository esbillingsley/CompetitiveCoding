import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class StoneGame implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new StoneGame(), "whatever", 1<<26).start();
    }

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            int n = scanner.nextInt();
            int minI = -1;
            int maxI = -1;
            for (int i = 0; i < n; i++) {
                int num = scanner.nextInt();
                if (num == 1) {
                    minI = i;
                }
                if (num == n) {
                    maxI = i;
                }
            }
            int leftI = Math.min(minI, maxI);
            int rightI = Math.max(minI, maxI);
            int leftGap = leftI + 1;
            int rightGap = n - rightI;
            int between = rightI - leftI;

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
