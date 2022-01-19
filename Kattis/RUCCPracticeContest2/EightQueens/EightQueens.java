import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class EightQueens implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new EightQueens(), "whatever", 1<<26).start();
    }

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        boolean[][] board = new boolean[8][8];
        boolean badRow = false;
        int queens = 0;
        for (int r=0; r<8; r++) {
            String row = scanner.next();
            int rCount = 0;
            for (int c=0; c<8; c++) {
                if (row.charAt(c) == '*') {
                    board[r][c] = true;
                    rCount++;
                    queens++;
                }
            }
            if (rCount>1) {
                badRow = true;
            }
        }
        if (queens!=8 || badRow || badCol(board) || badDiag(board)) {
            System.out.println("invalid");
        }
        else {
            System.out.println("valid");
        }
    }

    public boolean badCol(boolean[][] board) {
        for (int c=0; c<8; c++) {
            int cCount = 0;
            for (int r=0; r<8; r++) {
                if (board[r][c]) {
                    cCount++;
                }
            }
            if (cCount>1) {
                return true;
            }
        }
        return false;
    }

    public boolean badDiag(boolean[][] board) {
        for (int r=0; r<8; r++) {
            for (int c=0; c<8; c++) {
                if (board[r][c]) {
                    if (checkDiag(board, r, c)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean checkDiag(boolean[][] board, int r, int c) {
        int row = r+1;
        int col = c+1;
        while (row<8 && col<8) {
            if (board[row][col]) {
                return true;
            }
            row++;
            col++;
        }
        row = r+1;
        col = c-1;
        while (row<8 && col>=0) {
            if (board[row][col]) {
                return true;
            }
            row++;
            col--;
        }
        return false;
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
