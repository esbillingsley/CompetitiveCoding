import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class Opposites implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new Opposites(), "whatever", 1<<26).start();
    }

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        int tests = scanner.nextInt();

        for (int t = 0; t < tests; t++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int c = scanner.nextInt();
            int diff = Math.abs(a - b);
            int circleSize = diff * 2;
            if (Math.max(Math.max(a, b), c) > circleSize) {
                answers.append("-1\n");
            }
            else {
                if (c - diff > 0) {
                    answers.append(c - diff + "\n");
                }
                else {
                    answers.append(c + diff + "\n");
                }
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
