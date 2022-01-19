import java.io.*;
import java.util.StringTokenizer;
import java.util.*;

public class Islands {
    public static char[][] map;
    public static int[][] testedMap;
    public static int columns;
    public static int rows;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        rows = scanner.nextInt();
        columns = scanner.nextInt();
        scanner.nextLine();

        map = new char[rows][columns];
        for (int r=0; r<rows; r++) {
            map[r] = scanner.nextLine().toCharArray();
        }

        testedMap = new int[rows][columns];
        for (int r=0; r<rows; r++) {
            Arrays.fill(testedMap[r],-1);
        }

        for (int r=0; r<rows; r++) {
            for (int c=0; c<columns; c++) {
                if (map[r][c]=='L') {
                    cloudConverter(r,c);
                }
            }
        }

        int islands = 0;
        for (int r=0; r<rows; r++) {
            for (int c=0; c<columns; c++) {
                if (map[r][c]=='L') {
                    sinkIsland(r,c);
                    islands++;
                }
            }
        }

        System.out.println(islands);
    }

    public static void cloudConverter(int r, int c) {
        if (r==rows || c==columns || r<0 || c<0) {
            return;
        }
        if (testedMap[r][c]==0) {
            return;
        }
        testedMap[r][c] = 0;
        if (map[r][c]=='W') {
            return;
        }
        if (map[r][c]=='C') {
            map[r][c] = 'L';
        }
        cloudConverter(r,c+1);
        cloudConverter(r,c-1);
        cloudConverter(r+1,c);
        cloudConverter(r-1,c);
        return;
    }

    public static void sinkIsland(int r, int c) {
        if (r==rows || c==columns || r<0 || c<0) {
            return;
        }
        if (testedMap[r][c]==1) {
            return;
        }
        testedMap[r][c] = 1;
        if (map[r][c]=='W') {
            return;
        }
        if (map[r][c]=='L') {
            map[r][c] = 'W';
        }
        sinkIsland(r,c+1);
        sinkIsland(r,c-1);
        sinkIsland(r+1,c);
        sinkIsland(r-1,c);
        return;
    }
}
