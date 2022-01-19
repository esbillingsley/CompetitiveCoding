import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class ABPalindrome implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new ABPalindrome(), "whatever", 1<<26).start();
    }

    public void run() {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();
        int tests = scanner.nextInt();
        for (int t = 0; t < tests; t++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            char[] input = scanner.next().toCharArray();

            int aCount = 0;
            int bCount = 0;
            for (int i = 0; i < input.length; i++) {
                if (input[i] == '0') {
                    aCount++;
                }
                if (input[i] == '1') {
                    bCount++;
                }
            }

            int l = 0;
            int r = input.length - 1;
            boolean possible = true;
            while (l <= r) {
                if (input[l] == '?' && input[r] != '?') {
                    if (input[r] == '0') {
                        if (aCount >= a) {
                            possible = false;
                            break;
                        }
                        aCount++;
                    }
                    else {
                        if (bCount >= b) {
                            possible = false;
                            break;
                        }
                        bCount++;
                    }
                    input[l] = input[r];
                }
                else if (input[l] != '?' && input[r] == '?') {
                    if (input[l] == '0') {
                        if (aCount >= a) {
                            possible = false;
                            break;
                        }
                        aCount++;
                    }
                    else {
                        if (bCount >= b) {
                            possible = false;
                            break;
                        }
                        bCount++;
                    }
                    input[r] = input[l];
                }
                else if (input[l] == '?' && input[r] == '?') {
                    if (l == r) {
                        if (aCount < a) {
                            input[l] = '0';
                            aCount++;
                        }
                        else if (bCount < b) {
                            input[l] = '1';
                            bCount++;
                        }
                        else {
                            possible = false;
                            break;
                        }
                    }
                    else if (aCount < a - 1) {
                        input[l] = '0';
                        input[r] = '0';
                        aCount += 2;
                    }
                    else if (bCount < b - 1) {
                        input[l] = '1';
                        input[r] = '1';
                        bCount += 2;
                    }
                    else {
                        possible = false;
                        break;
                    }
                }
                else if (input[l] != input[r]) {
                    possible = false;
                    break;
                }
                l++;
                r--;
            }

            if (aCount != a || bCount != b || !possible) {
                answers.append(-1 + "\n");
            }
            else {
                for (char c: input) {
                    answers.append(c);
                }
                answers.append("\n");
            }
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
