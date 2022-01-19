import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class MinSquare implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new MinSquare(), "whatever", 1<<26).start();
    }

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            if (a > b * 2) {
                answers.append(a * a + "\n");
            }
            else if (b > a * 2) {
                answers.append(b * b + "\n");
            }
            else if (a * 2 >= b && a <= b) {
                answers.append((a * 2) * (a * 2) + "\n");
            }
            else {
                answers.append((b * 2) * (b * 2) + "\n");
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
