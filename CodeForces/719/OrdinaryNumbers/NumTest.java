/**
* NumTest.java - description
*
*
* @author - Evan Billingsley
* @version - date
*/

import java.util.Scanner;

public class NumTest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int count = 0;
        for (int i = 1; i <= num; i++) {
            boolean ordinary = true;
            char[] digits = String.valueOf(i).toCharArray();
            char digit = digits[0];
            for (char ch: digits) {
                if (ch != digit) {
                    ordinary = false;
                    break;
                }
            }
            if (ordinary) {
                count++;
            }
        }
        System.out.println(count);
    } //main
}
