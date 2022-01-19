import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class Mult2Div6 implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new Mult2Div6(), "whatever", 1<<26).start();
    }

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            int n = scanner.nextInt();
            boolean impossible = false;
            int i = 0;
            while (n != 1) {
                if (n <= 10 && n % 3 != 0) {
                    impossible = true;
                    break;
                }
                if (n % 6 == 0) {
                    n = n / 6;
                }
                else {
                    n = n * 2;
                }
                i++;
            }
            if (impossible) {
                answers.append(-1 + "\n");
            }
            else {
                answers.append(i + "\n");
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
