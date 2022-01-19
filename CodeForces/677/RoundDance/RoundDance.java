import java.io.*;
import java.util.*;
import java.util.StringTokenizer;
import java.math.BigInteger;

public class RoundDance implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new RoundDance(), "whatever", 1<<26).start();
    }

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        BigInteger result = factorial(n);
        result = result.divide(BigInteger.valueOf(n*(n/2)));
        System.out.println(result);
    }

    public BigInteger factorial(int n) {
        BigInteger factorial = BigInteger.valueOf(1);
        for (int i = n; n>0; n--) {
            factorial = factorial.multiply(BigInteger.valueOf(n));
        }
        return factorial;
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
