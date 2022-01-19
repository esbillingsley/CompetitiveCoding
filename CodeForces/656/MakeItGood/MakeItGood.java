import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class MakeItGood implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new MakeItGood(), "whatever", 1<<26).start();
    }

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        int tests = scanner.nextInt();

        for (int t = 0; t < tests; t++) {
            int n = scanner.nextInt();
            int[] input = new int[n];
            for (int i = 0; i < n; i++) {
                input[i] = scanner.nextInt();
            }
            if (input.length <= 2) {
                answers.append("0\n");
            }
            else {
                boolean increasing = true;
                boolean decreasing = false;
                int i = input.length - 1;
                while (i > 0) {
                    if (increasing && i > 0 && input[i] > input[i-1]) {
                        increasing = false;
                        decreasing = true;
                    }
                    else if (decreasing && i > 0 && input[i] < input[i-1]) {
                        break;
                    }
                    i--;
                }
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
