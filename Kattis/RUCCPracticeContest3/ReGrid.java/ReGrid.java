import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class ReGrid implements Runnable {
    public int[][] moves;
    public int[][] map;
    public int rows;
    public int columns;

    public static void main(String [] args) {
        new Thread(null, new ReGrid(), "whatever", 1<<26).start();
    }

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        rows = scanner.nextInt();
        columns = scanner.nextInt();
        moves = new int[rows][columns];
        map = new int[rows][columns];
        for (int r=0; r<rows; r++) {
            Arrays.fill(moves[r], -1);
        }
        for (int r=0; r<rows; r++) {
            String line = scanner.next();
            for (int c=0; c<columns; c++) {
                map[r][c] = line.charAt(c) - '0';
            }
        }
        int count = 0;
        ArrayList<Point> next = new ArrayList<Point>();
        next.add(new Point(0,0));
        while (next.size()>0) {
            ArrayList<Point> newNext = new ArrayList<Point>();
            for (Point point: next) {
                if (point.getMoves() < 0) {
                    point.setMoves(count);
                    newNext.addAll(point.makeMove());
                }
            }
            next = newNext;
            count++;
        }
        System.out.println(moves[rows-1][columns-1]);
    }

    class Point {
        private int r;
        private int c;
        private int jump;

        public Point(int row, int col) {
            r = row;
            c = col;
            jump = map[r][c];
        }

        public int getMoves() {
            return moves[r][c];
        }

        public void setMoves(int count) {
            moves[r][c] = count;
        }

        public ArrayList<Point> makeMove() {
            ArrayList<Point> next = new ArrayList<Point>();
            if (r + jump < rows) {
                next.add(new Point(r+jump,c));
            }
            if (r - jump >= 0) {
                next.add(new Point(r-jump,c));
            }
            if (c + jump < columns) {
                next.add(new Point(r,c+jump));
            }
            if (c - jump >= 0) {
                next.add(new Point(r,c-jump));
            }
            return next;
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
