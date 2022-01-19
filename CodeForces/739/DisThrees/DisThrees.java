import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class DisThrees implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new DisThrees(), "whatever", 1<<26).start();
    }

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        int tests = scanner.nextInt();
        ArrayList<Integer> lookup = new ArrayList<>();
        lookup.add(0);
        for (int i = 1; i <= 1666; i++) {
            if (i % 3 != 0 && i % 10 != 3) {
                lookup.add(i);
            }
        }

        for (int t = 0; t < tests; t++) {
            int k = scanner.nextInt();
            answers.append(lookup.get(k) + "\n");
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
