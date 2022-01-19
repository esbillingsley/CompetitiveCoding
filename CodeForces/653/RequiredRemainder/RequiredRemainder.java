import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class RequiredRemainder implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new RequiredRemainder(), "whatever", 1<<26).start();
    }

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        int tests = scanner.nextInt();
        for (int t=0; t<tests; t++) {
            int x = scanner.nextInt();
            int goal = scanner.nextInt();
            int n = scanner.nextInt();
            int maxEven = n / x;
            maxEven *= x;
            if (maxEven + goal <= n) {
                answers.append(maxEven + goal + "\n");
            }
            else {
                answers.append(maxEven - Math.abs(x - goal) + "\n");
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
