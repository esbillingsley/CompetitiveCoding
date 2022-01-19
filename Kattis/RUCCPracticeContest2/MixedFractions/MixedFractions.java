import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class MixedFractions implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new MixedFractions(), "whatever", 1<<26).start();
    }

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        boolean moreTests = true;
        while(moreTests) {
            int numer = scanner.nextInt();
            int denom = scanner.nextInt();
            if (numer == 0 && denom ==0) {
                moreTests = false;
                continue;
            }
            int whole = numer/denom;
            int rem = numer%denom;
            answers.append(whole + " " + rem + " / " + denom + "\n");
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
