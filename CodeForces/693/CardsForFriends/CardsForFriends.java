import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class CardsForFriends implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new CardsForFriends(), "whatever", 1<<26).start();
    }

    public int totalCount;

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            totalCount = 1;
            int w = scanner.nextInt();
            int h = scanner.nextInt();
            int n = scanner.nextInt();
            solve(w, h);
            if (totalCount >= n) {
                answers.append("YES\n");
            }
            else {
                answers.append("NO\n");
            }
        }
        System.out.println(answers);
    }

    public void solve(int w, int h) {
        if (w % 2 == 0) {
            totalCount *= 2;
            solve(w/2, h);
        }
        else if (h % 2 == 0) {
            totalCount *= 2;
            solve(w, h/2);
        }
        else {
            return;
        }
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
