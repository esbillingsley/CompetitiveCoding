import java.io.*;
import java.util.StringTokenizer;

public class TwoBrackets {

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        int n = scanner.nextInt();
        for (int t=0; t<n; t++) {
            String input = scanner.next();
            int moves = 0;
            int b1 = 0;
            int p1 = 0;
            for (char ch: input.toCharArray()) {
                if (ch == '[') {
                    b1++;
                }
                if (ch == ']' && b1!=0) {
                    moves++;
                    b1--;
                }
                if (ch == '(') {
                    p1++;
                }
                if (ch == ')' && p1!=0) {
                    moves++;
                    p1--;
                }
            }
            answers.append(moves + "\n");
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
