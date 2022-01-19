import java.io.*;
import java.util.StringTokenizer;

public class TrainCancel {

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int tests = scanner.nextInt();
        StringBuilder answers = new StringBuilder();
        for (int t=0; t<tests; t++) {
            int nBottom = scanner.nextInt();
            int nLeft = scanner.nextInt();
            int[] bottom = new int[nBottom];
            int[] left = new int[nLeft];
            for (int i=0; i<nBottom; i++) {
                bottom[i] = scanner.nextInt();
            }
            for (int i=0; i<nLeft; i++) {
                left[i] = scanner.nextInt();
            }
            int bI = 0;
            int lI = 0;
            int count = 0;
            while (bI<nBottom && lI<nLeft) {
                if (bottom[bI] < left[lI]) {
                    bI++;
                }
                else if (bottom[bI] > left[lI]) {
                    lI++;
                }
                else {
                    count++;
                    bI++;
                    lI++;
                }
            }
            answers.append(count + "\n");
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
