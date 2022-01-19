import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class CubeSum implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new CubeSum(), "whatever", 1<<26).start();
    }

    public void run() {
        HashSet<Long> lookup = new HashSet<Long>();
        long[] cubes = new long[10000];
        for (int i = 1; i < 10000; i++) {
            long cube = (long) Math.pow(i,3);
            cubes[i] = cube;
            lookup.add(cube);
        }
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            long target = scanner.nextLong();
            boolean found = false;
            int i = 1;
            while (!found && i < 10000) {
                if (lookup.contains(target - cubes[i])) {
                    found = true;
                }
                i++;
            }
            if (found) {
                answers.append("YES\n");
            }
            else {
                answers.append("NO\n");
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
