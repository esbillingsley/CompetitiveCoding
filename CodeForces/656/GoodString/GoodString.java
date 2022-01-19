import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class GoodString implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new GoodString(), "whatever", 1<<26).start();
    }

    int best;
    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        int tests = scanner.nextInt();

        for (int t = 0; t < tests; t++) {
            int n = scanner.nextInt();
            best = Integer.MAX_VALUE;
            char[] input = scanner.next().toCharArray();
            solve(input, 0, (n / 2), 'a', 0);
            solve(input, n / 2, n, 'a', 0);
            answers.append(best + "\n");
        }
        System.out.println(answers);
    }

    void solve(char[] arr, int l, int r, char curChar, int count) {
        if (l == r) {
            if (count < best) {
                best = count;
            }
            return;
        }
        for (int i = l; i <= r; i++) {
            if (arr[i] != curChar) {
                count++;
            }
        }
        solve(arr, (l + r) / 2, r, curChar++, count);
        solve(arr, l, (l + r) / 2, curChar++, count);
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
