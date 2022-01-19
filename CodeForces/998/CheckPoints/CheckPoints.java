import java.io.*;
import java.util.StringTokenizer;

public class CheckPoints {

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int tests = scanner.nextInt();
        for (int t=0; t<tests; t++) {
            StringBuilder answer = new StringBuilder();
            long k = scanner.nextLong();
            if (k%2 !=0) {
                answer.append(-1 + "\n");
            }
            else {
                answer.append(k/2 + "\n");
                for (long i=0; i<k/2; i++) {
                    answer.append(1 + " ");
                }
                answer.append("\n");
            }
            System.out.println(answer);
        }
    }

    static class FastScanner {
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
