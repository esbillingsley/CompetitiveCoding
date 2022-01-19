import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class Bookshelf implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new Bookshelf(), "whatever", 1<<26).start();
    }

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        int tests = scanner.nextInt();
        for (int t=0; t<tests; t++) {
            int n = scanner.nextInt();
            int[] shelf = new int[n];
            int stop = 0;
            for (int i=0; i<n; i++) {
                shelf[i] = scanner.nextInt();
                if (shelf[i] == 1) {
                    stop = i;
                }
            }
            int count = 0;
            boolean start = false;
            for (int i=0; i<stop; i++) {
                if (shelf[i]==1 && !start) {
                    start = true;
                }
                if (start && shelf[i] == 0) {
                    count++;
                }
            }
            answers.append(count+"\n");
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
