import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class SpecialPerm implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new SpecialPerm(), "whatever", 1<<26).start();
    }

    int[] visited;

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        int tests = scanner.nextInt();

        for (int t = 0; t < tests; t++) {
            int n = scanner.nextInt();
            LinkedList<Integer> sol = new LinkedList<>();
            if (n < 4) {
                answers.append("-1\n");
                continue;
            }
            sol.add(3);
            sol.add(1);
            sol.add(4);
            sol.add(2);
            for (int i = 5; i <= n; i++) {
                if (i % 2 == 0) {
                    sol.addFirst(i);
                }
                else {
                    sol.add(i);
                }
            }
            for (int num: sol) {
                answers.append(num + " ");
            }
            answers.append("\n");
        }
        System.out.println(answers);
    }

    public void solve(int count, int i) {

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
