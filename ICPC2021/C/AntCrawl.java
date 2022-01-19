import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class AntCrawl implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new AntCrawl(), "whatever", 1<<26).start();
    }

    static ArrayList<String> allPoss = new ArrayList<>();

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        String in = scanner.next();
        StringBuilder sb = new StringBuilder();
        char[] input = in.toCharArray();
        HashSet<Character> test = new HashSet<>();
        for (char ch: input) {
            if (!test.contains(ch)) {
                test.add(ch);
                sb.append(ch);
            }
        }
        permute(sb.toString(), 0, sb.length()-1);
        int bestScore = Integer.MAX_VALUE;
        for (String str: allPoss) {
            HashMap<Character, Integer> keys = new HashMap<>();
            int i = 0;
            for (char ch: str.toCharArray()) {
                keys.put(ch, i);
                i++;
            }
            int moves = 0;
            int currI = 0;
            for (char ch: input) {
                int chI = keys.get(ch);
                moves += Math.abs(currI-chI);
                currI = chI;
            }
            if(moves < bestScore) {
                bestScore = moves;
            }
        }
        System.out.println(bestScore + input.length);
    }

    public void permute(String str, int l, int r)  //https://www.geeksforgeeks.org/java-program-to-print-all-permutations-of-a-given-string/
    {
        if (l == r) {
            allPoss.add(str);
        }
        else {
            for (int i = l; i <= r; i++) {
                str = swap(str, l, i);
                permute(str, l + 1, r);
                str = swap(str, l, i);
            }
        }
    }

    public String swap(String a, int i, int j) //https://www.geeksforgeeks.org/java-program-to-print-all-permutations-of-a-given-string/
    {
        char temp;
        char[] charArray = a.toCharArray();
        temp = charArray[i];
        charArray[i] = charArray[j];
        charArray[j] = temp;
        return String.valueOf(charArray);
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
