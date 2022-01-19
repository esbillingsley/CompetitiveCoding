import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class BinaryReconstruct implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new BinaryReconstruct(), "whatever", 1<<26).start();
    }

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        int tests = scanner.nextInt();

        for (int t = 0; t < tests; t++) {
            int n0 = scanner.nextInt();
            int n1 = scanner.nextInt();
            int n2 = scanner.nextInt();
            int sum = n0 + n1 + n2;
            int[] arr = new int[sum + 1];
            boolean trailing0 = false;
            for (int i = 0; i < sum; i++) {
                if (n0 > 0) {
                    n0--;
                }
                else if (n1 > 0) {
                    if (arr[i] == 0) {
                        arr[i + 1] = 1;
                    }
                    else {
                        arr[i + 1] = 0;
                    }
                    n1--;
                }
                else if (n2 > 0) {
                    if (i == 0) {
                        arr[i] = 1;
                    }
                    if (arr[i] == 0) {
                        trailing0 = true;
                        arr[i] = 1;
                        arr[i + 1] = 1;
                    }
                    else {
                        arr[i + 1] = 1;
                    }
                    n2--;
                }
            }
            if (trailing0) {
                arr[sum] = 0;
            }
            for (int i = 0; i < sum + 1; i++) {
                answers.append(arr[i]);
            }
            answers.append("\n");
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
