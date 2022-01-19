import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class Stars implements Runnable {

    public boolean[][] grid;
    public int[][] tested;
    public int rows;
    public int columns;

    public static void main(String [] args) {
        new Thread(null, new Stars(), "whatever", 1<<26).start();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        int test = 1;
        while (scanner.hasNextLine()) {
            rows = scanner.nextInt();
            columns = scanner.nextInt();
            grid = new boolean[rows][columns];
            tested = new int[rows][columns];
            for (int r=0; r<rows; r++) {
                String line = scanner.next();
                for (int c=0; c<columns; c++) {
                    if (line.charAt(c)=='-') {
                        grid[r][c] = true;
                    }
                }
            }
            int stars = 0;
            for (int r=0; r<rows; r++) {
                for (int c=0; c<columns; c++) {
                    if (grid[r][c]) {
                        blackOut(r,c);
                        stars++;
                    }
                }
            }
            System.out.printf("Case %d: %d\n",test,stars);
            test++;
        }
    }

    public void blackOut(int r, int c) {
        if (r==rows || c==columns || r<0 || c<0) {
            return;
        }
        if (tested[r][c]==1) {
            return;
        }
        tested[r][c] = 1;
        if (!grid[r][c]) {
            return;
        }
        else {
            grid[r][c] = false;
        }
        blackOut(r,c+1);
        blackOut(r,c-1);
        blackOut(r+1,c);
        blackOut(r-1,c);
        return;
    }
}
