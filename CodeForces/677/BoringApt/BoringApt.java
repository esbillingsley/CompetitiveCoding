import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class BoringApt implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new BoringApt(), "whatever", 1<<26).start();
    }

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        int tests = scanner.nextInt();
        for (int t=0; t<tests; t++) {
            int count = 0;
            String n = scanner.next();
            int digit = n.charAt(0) - '0';
            if (digit>1) {
                count = (digit-1)*10;
            }
            for (int i=1; i<=n.length(); i++) {
                count += i;
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
