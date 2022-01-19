import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class FlexibleSpace implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new FlexibleSpace(), "whatever", 1<<26).start();
    }

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        int width = scanner.nextInt();
        int dividers = scanner.nextInt();
        ArrayList<Integer> points = new ArrayList<Integer>();
        points.add(0);
        for (int i=0; i<dividers; i++) {
            points.add(scanner.nextInt());
        }
        points.add(width);
        ArrayList<Integer> spaces = new ArrayList<Integer>();
        for (int i=0; i<points.size()-1; i++) {
            for (int j=i+1; j<points.size(); j++) {
                if (!spaces.contains(points.get(j))) {
                    spaces.add(points.get(j));
                }
                if (!spaces.contains(points.get(j) - points.get(i))) {
                    spaces.add(points.get(j) - points.get(i));
                }
            }
        }
        Collections.sort(spaces);
        for (int i=0; i<spaces.size(); i++) {
            System.out.print(spaces.get(i) + " ");
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
