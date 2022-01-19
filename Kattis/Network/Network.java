import java.io.*;
import java.util.*;


public class Network implements Runnable {
    ArrayList<Integer>[] graph;
    boolean[] connected;

    public static void main(String[] args) {
        new Thread(null, new Network(), "whatever", 1<<26).start();
    }

    public void run() {
        StringBuilder answers = new StringBuilder();
        FastScanner scanner = new FastScanner(System.in);
        int houses = scanner.nextInt();
        int cables = scanner.nextInt();

        graph = new ArrayList[houses];
        for (int i=0; i<houses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i=0; i<cables; i++) {
            int a = scanner.nextInt()-1;
            int b = scanner.nextInt()-1;
            graph[a].add(b);
            graph[b].add(a);
        }
        connected = new boolean[houses];

        checkConn(0);
        for (int i=0; i<connected.length; i++) {
            if (!connected[i]) {
                answers.append(i+1 + "\n");
            }
        }
        if (answers.length()==0) {
            System.out.println("Connected");
        }
        else {
            System.out.println(answers);
        }
    }

    public void checkConn(int house) {
       if (connected[house]==true) {
           return;
       }
       connected[house]=true;
       for (int num: graph[house]) {
           checkConn(num);
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
    }
}
