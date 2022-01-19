import java.util.Scanner;

public class RPS {

    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        int rounds = scanner.nextInt();
        scanner.nextLine();
        char[] sven = scanner.nextLine().toCharArray();
        int friends = scanner.nextInt();
        scanner.nextLine();
        char[][] opponents = new char[friends][rounds];
        for (int i = 0; i < friends; i++) {
            opponents[i] = scanner.nextLine().toCharArray();
        }
        int score = 0;
        for (int c=0; c<rounds; c++) {
            char svens = sven[c];
            for (int r=0; r<friends; r++) {
                score += getPoints(svens, opponents[r][c]);
            }
        }
        char[] options = {'R','P','S'};
        int bestScore = 0;
        for (int c=0; c<rounds; c++) {
            int roundScore = 0;
            for (char ch: options) {
                int testScore = 0;
                for (int r=0; r<friends; r++) {
                    testScore += getPoints(ch, opponents[r][c]);
                }
                if (testScore > roundScore) {
                    roundScore = testScore;
                }
            }
            bestScore += roundScore;
        }
        System.out.println(score + "\n" + bestScore);
    }

    public static int getPoints(char ch1, char ch2) {
        if (ch1 == 'R') {
            if (ch2 == 'P') {
                return 0;
            }
            if (ch2 =='R') {
                return 1;
            }
            return 2;
        }
        else if (ch1 == 'P') {
            if (ch2 == 'S') {
                return 0;
            }
            if (ch2 =='P') {
                return 1;
            }
            return 2;
        }
        else {
            if (ch2 == 'R') {
                return 0;
            }
            if (ch2 =='S') {
                return 1;
            }
            return 2;
        }
    }
}
