import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class UniqueBid implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new UniqueBid(), "whatever", 1<<26).start();
    }

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            int n = scanner.nextInt();
            ArrayList<Bid> bids = new ArrayList<>();
            HashMap<Integer, Integer> seen = new HashMap<Integer, Integer>();
            for (int i = 1; i <= n; i++) {
                int bid = scanner.nextInt();
                bids.add(new Bid(bid, i));
                if (!seen.containsKey(bid)) {
                    seen.put(bid, 1);
                }
                else {
                    seen.put(bid, seen.get(bid) + 1);
                }
            }
            Collections.sort(bids);
            boolean found = false;
            int i = 0;
            while (!found && i < n) {
                if (seen.get(bids.get(i).getBid()) == 1) {
                    found = true;
                    answers.append(bids.get(i).getIndex() + "\n");
                }
                i++;
            }
            if (!found) {
                answers.append(-1 + "\n");
            }
        }
        System.out.println(answers);
    }

    public class Bid implements Comparable<Bid> {
        private int bid;
        private int index;

        public Bid(int bid, int index) {
            this.bid = bid;
            this.index = index;
        }

        public int getBid() {
            return this.bid;
        }

        public int getIndex() {
            return this.index;
        }

        @Override
        public int compareTo(Bid that) {
            return this.bid - that.bid;
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
