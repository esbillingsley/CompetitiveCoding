import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class ABMatrix implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new ABMatrix(), "whatever", 1<<26).start();
    }

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int[] rowCounts = new int[n];
            int[] columnCounts = new int[m];
            int[][] matrix = new int[n][m];
            int rCount = 0;
            int cCount = 0;
            int rTarget = a * n;
            int cTarget = b * m;
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < m; c++) {
                    if ((rowCounts[r] < a && columnCounts[c] < b)
                        && (rCount < rTarget && cCount < cTarget)) {
                        matrix[r][c] = 1;
                        rowCounts[r]++;
                        rCount++;
                        columnCounts[c]++;
                        cCount++;
                    }
                }
            }
            if (rCount != rTarget || cCount != cTarget) {
                answers.append("NO\n");
            }
            else {
                answers.append("YES\n");
                for (int r = 0; r < n; r++) {
                    for (int c = 0; c < m; c++) {
                        answers.append(matrix[r][c]);
                    }
                    answers.append("\n");
                }
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
