import java.io.*;
import java.util.StringTokenizer;

public class CheckerBoard {

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        char[][] grid = new char[n][n];
        for (int r=0; r<n; r++) {
            String line = scanner.next();
            for (int c=0; c<n; c++) {
                grid[r][c] = line.charAt(c);
            }
        }
        System.out.println(result(grid, n));
    }

    public static int result(char[][] grid, int n) {
        for (int r=0; r<n; r++) {
            int brCount = 0;
            int wrCount = 0;
            int run = 1;
            char last = grid[r][0];
            for (int c=0; c<n; c++) {
                if (grid[r][c]=='B') {
                    brCount++;
                }
                if (grid[r][c]=='W') {
                    wrCount++;
                }
                if (c!=0 && grid[r][c]==last) {
                    run++;
                    if (run==3) {
                        return 0;
                    }
                }
                else {
                    last = grid[r][c];
                    run = 1;
                }
            }
            if (brCount!=wrCount) {
                return 0;
            }
        }
        for (int c=0; c<n; c++) {
            int bcCount = 0;
            int wcCount = 0;
            int run = 1;
            char last = grid[0][c];
            for (int r=0; r<n; r++) {
                if (grid[r][c]=='B') {
                    bcCount++;
                }
                if (grid[r][c]=='W') {
                    wcCount++;
                }
                if (r!=0 && grid[r][c]==last) {
                    run++;
                    if (run==3) {
                        return 0;
                    }
                }
                else {
                    last = grid[r][c];
                    run = 1;
                }
            }
            if (bcCount!=wcCount) {
                return 0;
            }
        }
        return 1;
    }

    static class FastScanner {
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
    }
}
