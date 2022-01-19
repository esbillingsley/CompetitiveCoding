import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class InfiniteTable implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new InfiniteTable(), "whatever", 1<<26).start();
    }

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        int tests = scanner.nextInt();

        for (int t = 0; t < tests; t++) {
            int k = scanner.nextInt();
            int startingCol = (int) Math.ceil(Math.sqrt(k));
            int startingNum = (int) Math.pow(startingCol - 1, 2) + 1;
            int endingNum = startingCol * startingCol;
            int switchNum = ((endingNum - startingNum) / 2) + startingNum;

            if (k < switchNum) {
                answers.append((k - startingNum + 1) + " " + startingCol +"\n");
            }
            else if (k > switchNum) {
                answers.append(startingCol + " " + ((endingNum - k) + 1) + "\n");
            }
            else {
                answers.append(startingCol + " " + startingCol + "\n");
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
