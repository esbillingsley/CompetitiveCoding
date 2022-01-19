import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class SpecialElement implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new SpecialElement(), "whatever", 1<<26).start();
    }

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        int tests = scanner.nextInt();

        for (int t = 0; t < tests; t++) {
            HashMap<Long, Long> nums = new HashMap<>();
            int n = scanner.nextInt();
            long[] partials = new long[n];
            long currentSum = 0;
            for (int i = 0; i < n; i++) {
                long num = scanner.nextLong();
                currentSum += num;
                if (!nums.containsKey(num)) {
                    nums.put(num, 1L);
                }
                else {
                    nums.put(num, nums.get(num) + 1L);
                }
                partials[i] = currentSum;
            }
            long count = 0;
            for (int i = 1; i < n; i++) {
                long num = partials[i];
                if (nums.containsKey(num)) {
                    count += nums.get(num);
                    nums.put(num, 0L);
                }
            }
            for (int i = 0; i < n - 2; i++) {
                for (int j = i + 2; j < n; j++) {
                    long sum = partials[j] - partials[i];
                    if (nums.containsKey(sum)) {
                        count += nums.get(sum);
                        nums.put(sum, 0L);
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
