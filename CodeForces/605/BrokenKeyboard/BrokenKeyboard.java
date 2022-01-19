import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class BrokenKeyboard implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new BrokenKeyboard(), "whatever", 1<<26).start();
    }

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        char[] str = scanner.next().toCharArray();
        char[] keys = new char[k];
        for (int i = 0; i < k; i++) {
            keys[i] = scanner.next().charAt(0);
        }
        HashSet<Character> lookup = new HashSet<>();
        for (char ch: keys) {
            lookup.add(ch);
        }
        long sum = 0;
        long currentRun = 0;
        for (char ch: str) {
            if (lookup.contains(ch)) {
                currentRun++;
            }
            else {
                sum += (currentRun * (currentRun + 1)) / 2;
                currentRun = 0;
            }
        }
        sum += (currentRun * (currentRun + 1)) / 2;
        System.out.println(sum);
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
