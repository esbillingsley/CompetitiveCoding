import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class FavSeq implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new FavSeq(), "whatever", 1<<26).start();
    }

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        int tests = scanner.nextInt();
        for (int t = 0; t<tests; t++) {
            int n = scanner.nextInt();
            int[] nums = new int[n];
            for (int i=0; i<n; i++) {
                nums[i] = scanner.nextInt();
            }
            int l = 0;
            int r = n-1;
            int i = 0;
            while (l<=r) {
                if (i%2==0) {
                    answers.append(nums[l]+" ");
                    l++;
                }
                else {
                    answers.append(nums[r]+" ");
                    r--;
                }
                i++;
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
