import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class PiranhaDom implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new PiranhaDom(), "whatever", 1<<26).start();
    }

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        int tests = scanner.nextInt();
        for (int t=0; t<tests; t++) {
            int n = scanner.nextInt();
            int[] fish = new int[n];
            for (int i=0; i<n; i++) {
                fish[i] = scanner.nextInt();
            }
            int min = Integer.MAX_VALUE;
            int max = Integer.MIN_VALUE;
            int domI = -1;
            for (int i=0; i<n; i++) {
                if (fish[i]>=max) {
                    max = fish[i];
                    if ((i>0 && fish[i-1]<max) || (i<n-1 && fish[i+1]<max)) {
                        domI = i+1;
                    }
                }
            }
            answers.append(domI + "\n");
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
