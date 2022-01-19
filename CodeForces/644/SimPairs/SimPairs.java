import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class SimPairs implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new SimPairs(), "whatever", 1<<26).start();
    }

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            int n = scanner.nextInt();
            HashSet<Integer> lookup = new HashSet<>();
            int[] nums = new int[n];
            int odds = 0;
            int evens = 0;
            for (int i = 0; i < n; i++) {
                int num = scanner.nextInt();
                if (num % 2 == 0) {
                    evens++;
                }
                else {
                    odds++;
                }
                nums[i] = num;
                lookup.add(num);
            }
            if (odds % 2 != 0) {
                boolean canMake = false;
                for (int num : nums) {
                    if (lookup.contains(num - 1) || lookup.contains(num + 1)) {
                        canMake = true;
                        break;
                    }
                }
                if (canMake) {
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
