import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class SumPerm implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new SumPerm(), "whatever", 1<<26).start();
    }

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            int n = scanner.nextInt();
            int l = scanner.nextInt();
            int r = scanner.nextInt();
            int s = scanner.nextInt();
            int sliceSize = r - l + 1;

            ArrayList<Integer> slice = new ArrayList<>();
            int currentSum = 0;
            for (int i = 1; i <= sliceSize; i++) {
                slice.add(i);
                currentSum += i;
            }

            int remaining = s;
            int lastHighest = n;
            for (int i = sliceSize - 1; i >= 0; i--) {
                int highest = remaining - currentSum - slice.get(i);
                if (highest < lastHighest) {
                    remaining -= highest;
                    currentSum += highest - slice.get(i);
                    slice.set(i, highest);
                }
                lastHighest = slice.get(i);
            }
            for (int i = 0; i < sliceSize; i++) {
                answers.append(slice.get(i));
            }
            answers.append("\n");
            // if (remaining == 0) {
            //     StringBuilder sb = new StringBuilder();
            //     for (int i = 1; i <= n; i++) {
            //         if (!slice.contains(i)) {
            //             sb.append(i);
            //         }
            //     }
            //     String result = sb.toString();
            //     answers.append(result.substring(0,l));
            //     for (int i = 0; i < sliceSize; i++) {
            //         answers.append(slice.get(i));
            //     }
            //     answers.append(result.substring(l) + "\n");
            // }
            // else {
            //     answers.append(-1 + "\n");
            // }
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
