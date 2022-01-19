import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class Cannons implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new Cannons(), "whatever", 1<<26).start();
    }

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            int n = scanner.nextInt();
            char[][] grid = new char[n][n];
            for (int i = 0; i < n; i++) {
                grid[i] = scanner.next().toCharArray();
            }
            boolean canMake = true;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == '1') {
                        if ((i+1 < n && grid[i + 1][j] != '1') &&
                            (j+1 < n && grid[i][j + 1] != '1')) {
                            canMake = false;
                        }
                    }
                }
            }
            if (canMake) {
                answers.append("YES\n");
            }
            else {
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
