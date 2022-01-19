import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class SeqTrans implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new SeqTrans(), "whatever", 1<<26).start();
    }

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            int n = scanner.nextInt();
            HashMap<Integer, Spans> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int num = scanner.nextInt();
                if (map.containsKey(num)) {
                    if (i - map.get(num).getLastIndex() > 1) {
                        map.get(num).addSpan();
                        map.get(num).setLastIndex(i);
                    }
                }
                else {
                    map.put(num, new Spans(num, 1));
                }
            }
            ArrayList<Spans> spans = new ArrayList<>();
            for (Spans value : map.values()) {
                spans.add(value);
            }
            Collections.sort(spans);
            answers.append(spans.get(0).getSpans() + "\n");
        }
        System.out.println(answers);
    }

    class Spans implements Comparable <Spans> {
        private int lastIndex;
        private int spans;

        public Spans (int lastIndex, int spans) {
            this.lastIndex = lastIndex;
            this.spans = spans;
        }

        public int getLastIndex() {
            return this.lastIndex;
        }

        public int getSpans() {
            return this.spans;
        }

        public void addSpan() {
            this.spans++;
        }

        @Override
        public int compareTo(Spans that) {
            return this.spans - that.spans;
        }
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
