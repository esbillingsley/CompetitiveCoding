import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class PermTrans implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new PermTrans(), "whatever", 1<<26).start();
    }

    static int[] depths;

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            int n = scanner.nextInt();
            depths = new int[n];
            int[] input = new int[n];
            for (int i = 0; i < n; i++) {
                input[i] = scanner.nextInt();
            }
            countDepth(input, 0, n, 0);
            for (int i = 0; i < n; i++) {
                if (i < n-1) {
                    answers.append(depths[i] + " ");
                }
                else {
                    answers.append(depths[i]);
                }
            }
            answers.append("\n");
        }
        System.out.println(answers);
    }

    public void countDepth(int[] input, int l, int r, int depth) {
        if (l == r) {
            return;
        }
        int max = 0;
        int maxI = -1;
        for (int i = l; i < r; i++) {
            if (input[i] > max) {
                max = input[i];
                maxI = i;
            }
        }
        depths[maxI] = depth;
        countDepth(input, l, maxI, depth + 1);
        countDepth(input, maxI + 1, r, depth + 1);
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
