import java.util.*;

public class GiftsFixing {

    public static void main (String[] args) {
        int listLength;
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        ArrayList<Long> answers = new ArrayList<Long>(testCases);

        for (int i=0; i<testCases; i++) {
            long moveCount = 0;
            listLength = scan.nextInt();
            long[] candies = new long[listLength];
            long[] oranges = new long[listLength];
            for (int j=0; j<listLength; j++) {
                candies[j] = scan.nextInt();
            }
            for (int j=0; j<listLength; j++) {
                oranges[j] = scan.nextInt();
            }
            long minCandy = candies[0];
            for (long candy: candies) {
                if (candy<minCandy) {
                    minCandy = candy;
                }
            }
            long minOranges = oranges[0];
            for (long orange: oranges) {
                if (orange<minOranges) {
                    minOranges = orange;
                }
            }
            for (int j=0; j<listLength; j++) {
                long candyDiff = 0;
                long orangeDiff = 0;
                if (candies[j]>minCandy) {
                    candyDiff = candies[j]-minCandy;
                }
                if (oranges[j]>minOranges) {
                    orangeDiff = oranges[j]-minOranges;
                }
                if (candyDiff>=orangeDiff) {
                    moveCount += candyDiff;
                } else {
                    moveCount += orangeDiff;
                }
            }
            answers.add(moveCount);
        }
        for (long ans:answers) {
            System.out.println(ans);
        }
    } //main
}
