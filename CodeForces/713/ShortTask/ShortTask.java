import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class ShortTask implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new ShortTask(), "whatever", 1<<26).start();
    }

    public void run() {
        long start = System.currentTimeMillis();
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();

        HashMap<Integer, Integer> lookup = new HashMap<>();
        int[] nums = new int[6000000];

        for (int i = 1; i < 6000000; i++) {
            if (!lookup.containsKey(nums[i] + i)) {
                lookup.put(nums[i] + i, i);
            }
            for (int j = i; j < 6000000; j += i) {
                if (j < 6000000) {
                    nums[j] += i;
                }
            }
        }
        long timeTaken = System.currentTimeMillis() - start;

        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            int c = scanner.nextInt();
            Integer n = lookup.get(c);
            if (n == null) {
                answers.append(-1 + "\n");
            }
            else {
                answers.append(n + "\n");
            }
        }
        System.out.println(answers);
        System.out.println(timeTaken);
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
