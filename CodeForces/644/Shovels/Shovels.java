import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class Shovels implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new Shovels(), "whatever", 1<<26).start();
    }

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            if (n <= k) {
                answers.append("1\n");
            }
            else {
                int answer = -1;
                int i = 2;
                while (i * i <= n) {
                    if (n % i == 0 && n / i <= k) {
                        answer = i;
                        break;
                    }
                    i++;
                }
                if (answer == -1) {
                    answers.append(n + "\n");
                }
                else {
                    answers.append(answer + "\n");
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
