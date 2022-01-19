import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class MissingNum implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new MissingNum(), "whatever", 1<<26).start();
    }

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        String str = scanner.next();
        int i=0;
        int num = 1;
        while (num<=n) {
            if (!str.substring(i).startsWith(Integer.toString(num))) {
                break;
            }
            if (i>=9) {
                i++;
            }
            i++;
            num++;
        }
        System.out.println(num);
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
