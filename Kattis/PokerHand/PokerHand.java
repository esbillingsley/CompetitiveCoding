import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class PokerHand {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String hand = scanner.nextLine();
        int[] counts = new int[14];
        for (int i=0; i<hand.length(); i+=3) {
            switch(hand.charAt(i)) {
                case 'A':
                    counts[1]++;
                    break;
                case 'T':
                    counts[10]++;
                    break;
                case 'J':
                    counts[11]++;
                    break;
                case 'Q':
                    counts[12]++;
                    break;
                case 'K':
                    counts[13]++;
                    break;
                default:
                    counts[hand.charAt(i)-'0']++;
            }
        }
        Arrays.sort(counts);
        System.out.println(counts[13]);
    }
}
