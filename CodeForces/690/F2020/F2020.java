import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class F2020 implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new F2020(), "whatever", 1<<26).start();
    }

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        int tests = scanner.nextInt();
        for (int t=0; t<tests; t++) {
            int n = scanner.nextInt();
            String s = scanner.next();
            if (n<4) {
                answers.append("NO\n");
                continue;
            }
            else if (s.substring(0,4).equals("2020") ||
                                            s.substring(n-4).equals("2020")) {
                answers.append("YES\n");
                continue;
            }
            int l = 0;
            int r = 4;
            boolean found = false;
            for (int i=0; i<4; i++) {
                String test = s.substring(0,l) + s.substring(n-r);
                if (test.equals("2020")) {
                    answers.append("YES\n");
                    found = true;
                    break;
                }
                l++;
                r--;
            }
            if (!found) {
                answers.append("NO\n");
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
