import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class AddUp {

    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int goal = scanner.nextInt();
        scanner.nextLine();
        HashMap<Integer,Integer> lookup = new HashMap<>();
        ArrayList<Integer> cards = new ArrayList<>();
        for (int i=0; i<n; i++) {
            int num = scanner.nextInt();
            if (lookup.containsKey(num)) {
                lookup.put(num, lookup.get(num)+1);
            }
            else {
                lookup.put(num, 1);
                cards.add(num);
            }
            int flipped = flip(num);
            if (flipped != -1 && flipped != num) {
                if (lookup.containsKey(flipped)) {
                    lookup.put(flipped, lookup.get(flipped)+1);
                }
                else {
                    lookup.put(flipped, 1);
                    cards.add(flipped);
                }
            }
        }
        boolean flag = false;
        for (int card: cards) {
            if (lookup.containsKey(goal-card)) {
                if (card == (goal-card) || flip(card) == goal-card) {
                    if (lookup.get(goal-card) > 1 || lookup.get(flip(card))>1) {
                        flag = true;
                    }
                }
                else {
                    flag = true;
                }
            }
        }
        if (flag) {
            System.out.println("YES");
        }
        else{
            System.out.println("NO");
        }
    }

    public static int flip(int n) {
        String num = Integer.toString(n);
        String flipped = "";
        for (int i=num.length()-1; i>=0; i--) {
            switch(num.charAt(i)) {
                case('1'):
                    flipped += '1';
                    break;
                case('2'):
                    flipped += '2';
                    break;
                case('5'):
                    flipped += '5';
                    break;
                case('6'):
                    flipped += '9';
                    break;
                case('8'):
                    flipped += '8';
                    break;
                case('9'):
                    flipped += '6';
                    break;
                default:
                    return -1;
            }
        }
        return Integer.parseInt(flipped);
    }
}
