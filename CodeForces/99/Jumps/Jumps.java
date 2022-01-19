import java.io.*;
import java.util.*;

public class Jumps {

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        int n = scanner.nextInt();
        for (int t=0; t<n; t++) {
            int x = scanner.nextInt();
            int y = 0;
            int k = 1;
            while (x - y > k) {
                y += k;
                k++;
            }
            if (x - y != k - 1) {
                k--;
            }
            k++;
            answers.append(k + "\n");
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
