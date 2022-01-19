import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class NoDistractions implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new NoDistractions(), "whatever", 1<<26).start();
    }

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            int n = scanner.nextInt();
            char[] tasks = scanner.next().toCharArray();
            HashSet<Character> seen = new HashSet<>();
            char previous = '0';
            boolean sus = false;
            for (int i = 0; i < n; i++) {
                char task = tasks[i];
                if (i > 0) {
                    previous = tasks[i-1];
                }
                if (seen.contains(task) && task != previous) {
                    sus = true;
                    break;
                }
                else {
                    seen.add(task);
                }
            }
            if (sus) {
                answers.append("NO\n");
            }
            else {
                answers.append("YES\n");
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
