import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class ParitySum implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new ParitySum(), "whatever", 1<<26).start();
    }

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            int num = scanner.nextInt();
            int n = scanner.nextInt();
            int evenRemainder = num - ((n - 1) * 2);
            int oddRemainder = num - (n - 1);
            if (evenRemainder > 0 && evenRemainder % 2 == 0) {
                answers.append("YES\n" + evenRemainder);
                for (int i = 0; i < n - 1; i++) {
                    answers.append(" 2");
                }
                answers.append("\n");
            }
            else if (oddRemainder > 0 && oddRemainder % 2 != 0) {
                answers.append("YES\n" + oddRemainder);
                for (int i = 0; i < n - 1; i++) {
                    answers.append(" 1");
                }
                answers.append("\n");
            }
            else {
                answers.append("NO\n");
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
