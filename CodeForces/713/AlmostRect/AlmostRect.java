import java.io.*;
import java.util.*;
import java.util.StringTokenizer;
import java.awt.Point;

public class AlmostRect implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new AlmostRect(), "whatever", 1<<26).start();
    }

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            int n = scanner.nextInt();
            char[][] grid = new char[n][n];
            Point p1 = null;
            Point p2 = null;
            for (int r = 0; r < n; r++) {
                grid[r] = scanner.next().toCharArray();
                for (int c = 0; c < n; c++) {
                    if (grid[r][c] == '*') {
                        if (p1 == null) {
                            p1 = new Point(r,c);
                        }
                        else {
                            p2 = new Point(r, c);
                        }
                    }
                }
            }
            if (p1.x == p2.x) {
                if (p1.x == 0) {
                    grid[p1.x + 1][p1.y] = '*';
                    grid[p2.x + 1][p2.y] = '*';
                }
                else {
                    grid[p1.x - 1][p1.y] = '*';
                    grid[p2.x - 1][p2.y] = '*';
                }
            }
            else if (p1.y == p2.y) {
                if (p1.y == 0) {
                    grid[p1.x][p1.y + 1] = '*';
                    grid[p2.x][p2.y + 1] = '*';
                }
                else {
                    grid[p1.x][p1.y - 1] = '*';
                    grid[p2.x][p2.y - 1] = '*';
                }
            }
            else {
                grid[p1.x][p2.y] = '*';
                grid[p2.x][p1.y] = '*';
            }
            for (int r = 0; r < n; r++) {
                for (int c = 0; c < n; c++) {
                    answers.append(grid[r][c]);
                }
                answers.append("\n");
            }
            // cases:
            // different rows and columns
            //same row
            // same column
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
