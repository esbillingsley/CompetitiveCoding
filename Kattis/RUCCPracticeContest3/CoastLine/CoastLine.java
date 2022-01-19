import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class CoastLine implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new CoastLine(), "whatever", 1<<26).start();
    }

    public int coast;
    public int rows;
    public int columns;
    public int[][] grid;

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        rows = scanner.nextInt();
        columns = scanner.nextInt();
        grid = new int[rows+2][columns+2];
        for (int r=1; r<rows+1; r++) {
            String line = scanner.next();
            for (int c=1; c<columns+1; c++) {
                grid[r][c] = line.charAt(c-1) - '0';
            }
        }
        coverWater(0,0);
        System.out.println(coast);
    }

    public void coverWater(int r, int c) {
        if (!isValid(r,c)) return;
        if (r+1<rows+1 && grid[r+1][c]==1) {
            coast++;
        }
        if (r-1>=0 && grid[r-1][c]==1) {
            coast++;
        }
        if (c+1<columns+1 && grid[r][c+1]==1) {
            coast++;
        }
        if (c-1>=0 && grid[r][c-1]==1) {
            coast++;
        }
        grid[r][c] = -1;
        coverWater(r+1,c);
        coverWater(r-1,c);
        coverWater(r,c+1);
        coverWater(r,c-1);
    }

    public boolean isValid(int r, int c) {
        return r<rows+2 && r>=0 && c<columns+2 && c>=0 && grid[r][c]==0;
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
