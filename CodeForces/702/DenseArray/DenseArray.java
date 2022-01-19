import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class DenseArray implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new DenseArray(), "whatever", 1<<26).start();
    }

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = scanner.nextInt();
            }
            int count = 0;
            for (int i = 0; i < n-1; i++) {
                int small = Math.min(nums[i], nums[i+1]);
                int large = Math.max(nums[i], nums[i+1]);
                if (large > small * 2) {
                    int testNum = small;
                    while (testNum * 2 < large) {
                        testNum *= 2;
                        count++;
                    }
                }
            }
            answers.append(count + "\n");
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
