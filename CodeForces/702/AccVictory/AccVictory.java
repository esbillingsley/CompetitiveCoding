import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class AccVictory implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new AccVictory(), "whatever", 1<<26).start();
    }

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            int n = scanner.nextInt();
            int[] results = new int[n];
            ArrayList<Player> players = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                long tokens = scanner.nextLong();
                players.add(new Player(i+1, tokens));
            }
            Collections.sort(players);
            long total = 0;
            int wrongI = -1;
            for (int i = 0; i < n - 1; i++) {
                Player p1 = players.get(i);
                Player p2 = players.get(i + 1);
                if (p1.getTokens() + total < p2.getTokens()) {
                    wrongI = i;
                }
                total += p1.getTokens();
            }
            int count = n;
            if (wrongI != -1) {
                for (int i = 0; i <= wrongI; i++) {
                    results[players.get(i).getPlayerNum() - 1] = -1;
                    count--;
                }
            }
            answers.append(count + "\n");
            for (int i = 0; i < n; i++) {
                if (results[i] == 0) {
                    answers.append(i + 1 + " ");
                }
            }
            answers.append("\n");
        }
        System.out.println(answers);
    }

    class Player implements Comparable<Player> {
        private int playerNum;
        private long tokens;

        public Player(int num, long tokens) {
            this.playerNum = num;
            this.tokens = tokens;
        }

        public int getPlayerNum() {
            return this.playerNum;
        }

        public long getTokens() {
            return this.tokens;
        }

        @Override
        public int compareTo(Player that) {
            int result = (int) (this.tokens - that.tokens);
            return result;
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
