import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class SnowRobot implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new SnowRobot(), "whatever", 1<<26).start();
    }

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            int[] counts = new int[4];
            char[] input = scanner.next().toCharArray();
            for (char ch : input) {
                switch (ch) {
                    case 'U':
                        counts[0]++;
                        break;
                    case 'L':
                        counts[1]++;
                        break;
                    case 'D':
                        counts[2]++;
                        break;
                    case 'R':
                        counts[3]++;
                        break;
                }
            }
            char[] forPrint = {'U','L','D','R'};
            int minUD = Math.min(counts[0], counts[2]);
            int minLR = Math.min(counts[1], counts[3]);
            if (minUD == 0 && minLR != 0) {
                minLR = 1;
            }
            if (minLR == 0 && minUD != 0) {
                minUD = 1;
            }
            answers.append((minUD * 2) + (minLR * 2) + "\n");
            for (int i = 0; i < counts.length; i++) {
                int toPrint = minLR;
                if (i % 2 == 0) toPrint = minUD;
                for (int j = 0; j < toPrint; j++) {
                    answers.append(forPrint[i]);
                }
            }
            answers.append("\n");
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
