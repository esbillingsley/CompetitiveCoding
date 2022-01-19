import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class Ratings implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new Ratings(), "whatever", 1<<26).start();
    }

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        int judges = scanner.nextInt();
        int scores = scanner.nextInt();
        int total = 0;
        for (int i=0; i<scores; i++) {
            total+=scanner.nextInt();
        }
        int leftOver = judges - scores;
        System.out.printf("%f %f\n", (total+(leftOver*-3.0))/judges, (total+(leftOver*3.0))/judges);

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
