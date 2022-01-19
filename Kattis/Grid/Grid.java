import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class Grid {
    public static int[][] grid;
    public static int[][] moveMap;
    public static int rows;
    public static int columns;

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        rows = scanner.nextInt();
        columns = scanner.nextInt();
        grid = new int[rows][columns];
        moveMap = new int[rows][columns];

        for (int r=0; r<rows; r++) {
            Arrays.fill(moveMap[r], -1);
            String row = scanner.next();
            for (int c=0; c<columns; c++) {
                grid[r][c] = row.charAt(c) - '0';
            }
        }
        ArrayList<Point> next = new ArrayList<Point>();
        next.add(new Point(0,0));
        int moves = 0;
        while (next.size() != 0) {
            ArrayList<Point> newNext = new ArrayList<Point>();
            for (Point point: next) {
                if (point.checkMap() == -1) {
                    point.setMap(moves);
                    newNext.addAll(point.getNext(point.getJump()));
                }
            }
            moves++;
            next = newNext;
        }
        System.out.println(moveMap[rows-1][columns-1]);
    }

    static class Point {
        private int r, c;

        public Point (int r, int c) {
            this.r = r;
            this.c = c;
        }

        public int getR() {
            return this.r;
        }

        public int getC() {
            return this.c;
        }

        public int getJump() {
            return grid[this.r][this.c];
        }

        public int checkMap() {
            return moveMap[this.r][this.c];
        }

        public void setMap(int moves) {
            moveMap[this.r][this.c] = moves;
        }

        public ArrayList<Point> getNext(int jump) {
            ArrayList<Point> next = new ArrayList<Point>();
            if (jump==0) {
                return next;
            }
            if (this.r +jump < rows) {
                next.add(new Point(r+jump, c));
            }
            if (this.r - jump >= 0) {
                next.add(new Point(r-jump, c));
            }
            if (this.c + jump < columns) {
                next.add(new Point(r, c+jump));
            }
            if (this.c - jump >= 0) {
                next.add(new Point(r, c-jump));
            }
            return next;
        }
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
