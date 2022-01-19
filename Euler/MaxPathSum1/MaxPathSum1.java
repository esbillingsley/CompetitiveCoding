import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MaxPathSum1 {
    public static int[][] pyramid;
    public static int[][] maxArr;

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int rows = scanner.nextInt();

        pyramid = new int[rows][];
        for (int r=0; r<rows; r++) {
            pyramid[r] = new int[r+1];
            for (int c=0; c<pyramid[r].length; c++) {
                pyramid[r][c] = scanner.nextInt();
            }
        }

        maxArr = new int[rows][];
        for (int r=0; r<rows; r++) {
            if (r==rows-1) {
                maxArr[r] = new int[r+1];
                for (int j=0; j<maxArr[r].length; j++) {
                    maxArr[r][j] = pyramid[r][j];
                }
            }
            else {
                maxArr[r] = new int[r+1];
                Arrays.fill(maxArr[r],-1);
            }
        }

        System.out.println(maxPath(0,0));
    }

    public static int maxPath(int r, int c) {
        if (maxArr[r][c]!=-1) {
            return maxArr[r][c];
        }
        if (c==maxArr[r].length-1) {
            maxArr[r][c] = pyramid[r][c] + maxPath(r+1,c);
            return maxArr[r][c];
        }
        maxArr[r][c] = pyramid[r][c] + Math.max(maxPath(r+1,c), maxPath(r+1,c+1));
        return maxArr[r][c];
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
