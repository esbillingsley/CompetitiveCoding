import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class UnreadMail implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new UnreadMail(), "whatever", 1<<26).start();
    }

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        HashMap<Integer, Long> cache = new HashMap<>();
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long runTotal = 0;
        int tick = 1;
        for (int i = 0; i < m; i++) {
            runTotal += n;
            int sender = scanner.nextInt();
            if (cache.containsKey(sender)) {
                runTotal -= tick-cache.get(sender);
            }
            else {
                runTotal -= tick;
            }
            cache.put(sender,tick);
            tick++;
            answers.append(runTotal + "\n");
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
