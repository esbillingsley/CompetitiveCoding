import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class Flip5 {

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        StringBuilder answers = new StringBuilder();

        int tests = scanner.nextInt();
        for (int i=0; i<tests; i++) {
            boolean[][] tiles = new boolean[3][3];
            for (int r=0; r<3; r++) {
                String row = scanner.next();
                for (int c=0; c<3; c++) {
                    if (row.charAt(c)=='*') {
                        tiles[r][c] = true;
                    }
                    else {
                        tiles[r][c] = false;
                    }
                }
            }
            State start = new State();
            State end = new State(tiles);
            HashSet<String> visited = new HashSet<String>();
            ArrayList<State> next = new ArrayList<State>();
            next.add(start);
            int moves = 0;
            boolean found = false;
            while (!found) {
                ArrayList<State> newNext = new ArrayList<State>();
                for (State state: next) {
                    if (state.equals(end)) {
                        answers.append(moves+"\n");
                        found = true;
                        break;
                    }
                    for (State neighbor: state.getNext()) {
                        if (!visited.contains(neighbor.getId())) {
                            visited.add(neighbor.getId());
                            newNext.add(neighbor);
                        }
                    }
                }
                moves++;
                next = newNext;
            }
        }
        System.out.println(answers);
    }


    static class State {
        private String id;
        private boolean[][] grid;

        public State() {
            this.id = "000000000";
            this.grid = new boolean[3][3];
        }

        public State(boolean[][] tiles) {
            StringBuilder ID = new StringBuilder();
            for (int r=0; r<3; r++) {
                for (int c=0; c<3; c++) {
                    if (tiles[r][c]) {
                        ID.append("1");
                    }
                    else {
                        ID.append("0");
                    }
                }
            }
            this.id = ID.toString();
            this.grid = tiles;
        }

        public String getId() {
            return id;
        }

        public ArrayList<State> getNext() {
            ArrayList<State> next = new ArrayList<State>();
            for (int r=0; r<3; r++) {
                for (int c=0; c<3; c++) {
                    next.add(makeMove(r,c));
                }
            }
            return next;
        }

        private State makeMove(int row, int column) {
            boolean[][] temp = new boolean[3][3];
            for (int r=0; r<3; r++) {
                for (int c=0; c<3; c++) {
                    temp[r][c] = this.grid[r][c];
                }
            }
            for (int r=0; r<3; r++) {
                for (int c=0; c<3; c++) {
                    if (r==row && c==column) {
                        temp[r][c] = !temp[r][c];
                    }
                    else if (r==row-1 && c==column) {
                        temp[r][c] = !temp[r][c];
                    }
                    else if (r==row+1 && c==column) {
                        temp[r][c] = !temp[r][c];
                    }
                    else if (c==column-1 && r==row) {
                        temp[r][c] = !temp[r][c];
                    }
                    else if (c==column+1 && r==row) {
                        temp[r][c] = !temp[r][c];
                    }
                }
            }
            return new State(temp);
        }

        public boolean equals(State that) {
            return this.id.equals(that.id);
        }
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
