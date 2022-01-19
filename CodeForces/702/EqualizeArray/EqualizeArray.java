import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class EqualizeArray implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new EqualizeArray(), "whatever", 1<<26).start();
    }

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            int n = scanner.nextInt();
            HashMap<Integer, Integer> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int num = scanner.nextInt();
                if (!map.containsKey(num)) {
                    map.put(num, 1);
                }
                else {
                    map.put(num, map.get(num) + 1);
                }
            }
            ArrayList<Integer> counts = new ArrayList<>();
            int total = 0;
            for (HashMap.Entry<Integer, Integer> entry: map.entrySet()) {
                int count = entry.getValue();
                counts.add(count);
                total += count;
            }
            Collections.sort(counts);
            //System.err.println(counts.toString());
            ArrayList<Integer> moves = new ArrayList<>();
            int totCounts = counts.size();
            int runningTot = 0;
            for (int i = 0; i < counts.size(); i++) {
                int count = counts.get(i);
                moves.add(runningTot + ((total - count - runningTot) - (totCounts - i - 1) * count));
                runningTot += count;
                // System.err.printf("runningTot: %d, total: %d, count %d, totCounts: %d, i: %d%n",
                //             runningTot, total, count, totCounts, i);
            }
            Collections.sort(moves);
            //System.err.println(moves.toString());
            answers.append(moves.get(0) + "\n");
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
