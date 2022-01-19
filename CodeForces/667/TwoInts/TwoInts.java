import java.io.*;
import java.util.StringTokenizer;

public class TwoInts {

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();

        int testCount = scanner.nextInt();
        for (int i = 0; i<testCount; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            int difference = Math.abs(a-b);

            if (a==b) {
                answers.append("0\n");
            }
            else if (difference%10 == 0){
                answers.append(difference/10+"\n");
            }
            else {
                answers.append((difference/10)+1+"\n");
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
