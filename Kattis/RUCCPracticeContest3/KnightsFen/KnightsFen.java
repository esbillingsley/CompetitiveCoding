import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class KnightsFen implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new KnightsFen(), "whatever", 1<<26).start();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder answers = new StringBuilder();
        HashMap<String,Integer> visited = new HashMap<String,Integer>();
        ArrayList<State> next = new ArrayList<State>();
        next.add(new State());
        //boolean found = false;
        int moves = 0;
        while (moves<11) {
            ArrayList<State> newNext = new ArrayList<State>();
            for (State state: next) {
                if (!visited.containsKey(state.getId())) {
                    visited.put(state.getId(),moves);
                    newNext.addAll(state.getNext());
                }
            }
            next = newNext;
            moves++;
        }

        int tests = scanner.nextInt();
        scanner.nextLine();
        for (int t=0; t<tests; t++) {
            StringBuilder end = new StringBuilder();
            for (int r=0; r<5; r++) {
                end.append(scanner.nextLine());
            }
            String endString = end.toString();
            if (!visited.containsKey(endString)) {
                answers.append("Unsolvable in less than 11 move(s).\n");
            }
            else {
                answers.append("Solvable in " + visited.get(endString) + " move(s).\n");
            }
        }
        System.out.println(answers);
    }

    class State {
        int[][] board;
        String id;
        int br;
        int bc;

        public State() {
            board = new int[5][5];
            for (int r=0; r<5; r++) {
                for (int c=r; c<5; c++) {
                    if (r>2) {
                        c++;
                    }
                    if (c<5) {
                        board[r][c] = 1;
                    }
                }
            }
            board[2][2] = -1;
            id = "111110111100 110000100000";
            br = 2;
            bc = 2;
        }

        public State(int[][] board) {
            this.board = board;
            StringBuilder sb = new StringBuilder();
            for (int r=0; r<5; r++) {
                for (int c=0; c<5; c++) {
                    if (board[r][c]==1) {
                        sb.append("1");
                    }
                    else if (board[r][c]==0) {
                        sb.append("0");
                    }
                    else {
                        sb.append(" ");
                        br = r;
                        bc = c;
                    }
                }
            }
            id = sb.toString();
        }

        public String getId() {
            return this.id;
        }

        private State swap(int row, int col) {
            int[][] tempBoard = new int[5][5];
            for (int r=0; r<5; r++) {
                for (int c=0; c<5; c++) {
                    tempBoard[r][c] = board[r][c];
                }
            }
            int temp = board[row][col];
            tempBoard[br][bc] = temp;
            tempBoard[row][col] = -1;
            return new State(tempBoard);
        }

        public ArrayList<State> getNext() {
            ArrayList<State> next = new ArrayList<State>();
            for (int r=0; r<5; r++) {
                for (int c=0; c<5; c++) {
                    if (r==br && c==bc) {
                        continue;
                    }
                    else if (r+2 == br && c+1==bc) {
                        next.add(swap(r,c));
                    }
                    else if (r-2 == br && c+1==bc) {
                        next.add(swap(r,c));
                    }
                    else if (r+2 == br && c-1==bc) {
                        next.add(swap(r,c));
                    }
                    else if (r-2 == br && c-1==bc) {
                        next.add(swap(r,c));
                    }
                    else if (r+1 == br && c+2==bc) {
                        next.add(swap(r,c));
                    }
                    else if (r+1 == br && c-2==bc) {
                        next.add(swap(r,c));
                    }
                    else if (r-1 == br && c+2==bc) {
                        next.add(swap(r,c));
                    }
                    else if (r-1 == br && c-2==bc) {
                        next.add(swap(r,c));
                    }
                }
            }
            return next;
        }

        public boolean equals(State that) {
            return this.id.equals(that.id);
        }
    }
}
