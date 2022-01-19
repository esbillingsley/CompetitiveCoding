import java.io.*;
import java.util.StringTokenizer;

public class Ants {

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        int tests = scanner.nextInt();
        for (int t=0; t<tests; t++) {
            int len = scanner.nextInt();
            int num = scanner.nextInt();
            int[] ants = new int[num];
            for (int i=0; i<num; i++) {
                ants[i] = scanner.nextInt();
            }
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            int minDiff = Integer.MAX_VALUE;
            for (int ant: ants) {
                int diff = Math.abs(ant-(len-ant));
                if (diff<minDiff) {
                    minDiff = diff;
                    min = Math.min(ant, len-ant);
                }
                if (ant > max) {
                    max = ant;
                }
                if (len-ant > max) {
                    max = len-ant;
                }
            }
            answers.append(min + " " + max + "\n");
        }
        System.out.println(answers);
    }

    static class FastScanner {
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
    }
}
