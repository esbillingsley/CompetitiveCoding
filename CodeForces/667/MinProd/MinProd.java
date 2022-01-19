import java.io.*;
import java.util.StringTokenizer;

public class MinProd {

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();

        long testCount = scanner.nextInt();
        for (int i=0; i<testCount; i++) {
            long a = scanner.nextInt();
            long b = scanner.nextInt();
            long x = scanner.nextInt();
            long y = scanner.nextInt();
            long n = scanner.nextInt();

            long minProdA = productTest(a,b,x,y,n);
            long minProdB = productTest(b,a,y,x,n);

            if (minProdA<minProdB) {
                answers.append(minProdA+"\n");
            }
            else {
                answers.append(minProdB+"\n");
            }
        }
        System.out.println(answers);
    }

    public static long productTest(long a, long b, long x, long y, long n) {
        if ((a-x) >= n) {
            return (a-n)*b;
        }
        else if (((a-x)+(b-y))>=n){
            return (a-(a-x))*(b-(n-(a-x)));
        }
        else {
            return (x*y);
        }
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
