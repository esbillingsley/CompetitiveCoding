import java.io.*;
import java.util.*;


public class PurpleOnAve implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new PurpleOnAve(), "whatever", 1<<26).start();
    }

    ArrayList<Integer>[] graph;

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        graph = new ArrayList[n+1];
        for (int i = 0; i < n; i++) {
            graph[i+1] = new ArrayList<Integer>();
        }
        for (int i = 1; i <= m; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }
        // for (int i=1; i<n+1; i++) {
        //     System.out.println(graph[i].toString());
        // }
        HashSet<Integer> visited = new HashSet<>();
        int edges = 0;
        ArrayList<Integer> next = new ArrayList<Integer>();
        boolean found = false;
        next.add(1);
        while (!found) {
            ArrayList<Integer> newNext = new ArrayList<>();
            for (int node: next) {
                if (node == n) {
                    found = true;
                }
                visited.add(node);
                for (int neighbor: graph[node]) {
                    if (!visited.contains(neighbor)) {
                        newNext.add(neighbor);
                    }
                }
            }
            next = newNext;
            if (!found) {
                edges++;
            }
            //System.out.println(next.toString());
        }
        System.out.println(edges-1);
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
