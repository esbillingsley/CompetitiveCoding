import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class RemoveSmallestBetter implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new RemoveSmallestBetter(), "whatever", 1<<26).start();
    }

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        int tests = scanner.nextInt();

        for (int t = 0; t < tests; t++) {
            int n = scanner.nextInt();
            ArrayList<Integer> nums = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                nums.add(scanner.nextInt());
            }
            Collections.sort(nums);
            boolean success = true;
            for (int i = 0; i < n - 1; i++) {
                if (nums.get(i + 1) - nums.get(i) > 1) {
                    success = false;
                    break;
                }
            }
            if (success) {
                answers.append("YES\n");
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
