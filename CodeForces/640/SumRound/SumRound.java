import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class SumRound implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new SumRound(), "whatever", 1<<26).start();
    }

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        int tests = scanner.nextInt();

        for (int t = 0; t < tests; t++) {
            char[] num = scanner.next().toCharArray();
            int count = 0;
            String answer = "";
            for (int i = 0; i < num.length; i++) {
                if (num[i] != '0') {
                    count++;
                    answer += num[i];
                    for (int j = i + 1; j < num.length; j++) {
                        answer += '0';
                    }
                    answer += " ";
                }
            }
            answers.append(count + "\n" + answer + "\n");
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
