import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class FairDivision implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new FairDivision(), "whatever", 1<<26).start();
    }

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            int n = scanner.nextInt();
            int twoCount = 0;
            int oneCount = 0;
            int sum = 0;
            for (int i = 0; i < n; i++) {
                int candyWeight = scanner.nextInt();
                if (candyWeight == 2) {
                    twoCount++;
                }
                else {
                    oneCount++;
                }
                sum += candyWeight;
            }
            if ((twoCount % 2 == 0 && oneCount % 2 != 0)
                                || (oneCount % 2 == 0 && twoCount % 2 != 0)) {
                answers.append("NO\n");
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
