import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class Spy implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new Spy(), "whatever", 1<<26).start();
    }

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            int common = -1;
            int seen = -1;
            for (int i = 0; i < n; i++) {
                int num = scanner.nextInt();
                if (i == 0) {
                    seen = num;
                }
                if (i > 0 && num == seen) {
                    common = num;
                }
                nums[i] = num;
            }
            if (common == -1) {
                answers.append(1 + "\n");
            }
            else {
                for (int i = 0; i < n; i++) {
                    if (nums[i] != common) {
                        answers.append(i + 1 + "\n");
                        break;
                    }
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
