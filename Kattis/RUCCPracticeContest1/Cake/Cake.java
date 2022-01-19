import java.io.*;
import java.util.StringTokenizer;

public class Cake {

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int width = scanner.nextInt();
        int n = scanner.nextInt();
        int area = 0;
        for (int i=0; i<n; i++) {
            int w = scanner.nextInt();
            int l = scanner.nextInt();
            area += w*l;
        }
        System.out.println(area/width);
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
