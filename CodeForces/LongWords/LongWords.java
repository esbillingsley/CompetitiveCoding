import java.io.*;
import java.util.StringTokenizer;

public class LongWords {

    public static void main(String[] args) {
        StringBuilder answers = new StringBuilder();
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        for (int i=0; i<n; i++) {
            String word = scanner.next();
            if (word.length() > 10) {
                answers.append(word.charAt(0));
                answers.append(word.length()-2);
                answers.append(word.charAt(word.length()-1) + "\n");
            }
            else {
                answers.append(word + "\n");
            }
        }
        System.out.print(answers);
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
