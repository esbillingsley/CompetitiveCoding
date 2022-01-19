import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class CorruptedArray implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new CorruptedArray(), "whatever", 1<<26).start();
    }

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            int n = scanner.nextInt() + 2;

            int[] nums = new int[n];
            int max = Integer.MIN_VALUE;
            int maxIndex = -1;
            long sum = 0;
            for (int i = 0; i < n; i++) {
                int num = scanner.nextInt();
                nums[i] = num;
                if (num > max) {
                    max = num;
                    maxIndex = i;
                }
                sum += num;
            }
            sum -= max;
            int xIndex = -1;
            int sumIndex = -1;
            for(int i = 0; i < n; i++) {
                if (i == maxIndex) {
                    continue;
                }
                long testSum = sum - nums[i];
                if (testSum == nums[i]) {
                    sumIndex = i;
                    xIndex = maxIndex;
                    break;
                }
                if (testSum == max) {
                    sumIndex = maxIndex;
                    xIndex = i;
                    break;
                }
            }
            if (xIndex == -1) {
                answers.append(-1 + "\n");
            }
            else {
                for (int i = 0; i < n; i++) {
                    if (i != xIndex && i != sumIndex) {
                        answers.append(nums[i]);
                        if (i < n - 1) {
                            answers.append(" ");
                        }
                    }
                }
                answers.append("\n");
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
