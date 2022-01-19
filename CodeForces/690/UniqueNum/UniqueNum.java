import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class UniqueNum implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new UniqueNum(), "whatever", 1<<26).start();
    }

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        int tests = scanner.nextInt();
        for (int t=0; t<tests; t++) {
            int n = scanner.nextInt();
            if (n>45) {
                answers.append("-1\n");
                continue;
            }
            String current = "";
            for (int i=9; i>0; i--) {
                if (n-i >= 0) {
                    n -= i;
                    current += i;
                }
            }
            String result = "";
            for (int i=current.length()-1; i>=0; i--) {
                result += current.charAt(i);
            }
            answers.append(result + "\n");
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
