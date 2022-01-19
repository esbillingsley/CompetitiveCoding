import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class NewYearsNumber implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new NewYearsNumber(), "whatever", 1<<26).start();
    }

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            int n = scanner.nextInt();
            int singles = n % 10;
            n -= 2021 * singles;
            if (n < 0 || (n % 2020 != 0 && n % 2021 != 0)) {
                boolean flag = false;
                int i = 0;
                while (n > 0 && !flag) {
                    n -= 2020;
                    if (n % 2021 == 0) {
                        flag = true;
                    }
                }
                if (flag) {
                    answers.append("YES\n");
                }
                else {
                    answers.append("NO\n");
                }
            }
            else {
                answers.append("YES\n");
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
