import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class HonestCoach implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new HonestCoach(), "whatever", 1<<26).start();
    }

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            int n = scanner.nextInt();
            ArrayList<Integer> athletes = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                athletes.add(scanner.nextInt());
            }
            Collections.sort(athletes);
            int last = athletes.get(0);
            int diff = Integer.MAX_VALUE;
            for (int i = 1; i < n; i++) {
                int current = athletes.get(i);
                if (current - last < diff) {
                    diff = current - last;
                }
                last = current;
            }
            answers.append(diff + "\n");
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
