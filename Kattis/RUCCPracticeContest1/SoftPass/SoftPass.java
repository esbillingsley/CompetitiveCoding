import java.util.*;

public class SoftPass {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expected = scanner.nextLine();
        String actual = scanner.nextLine();
        String switchCase = "";
        for (char ch: actual.toCharArray()) {
            if (!Character.isDigit(ch)) {
                if (Character.isUpperCase(ch)) {
                    ch = Character.toLowerCase(ch);
                }
                else {
                    ch = Character.toUpperCase(ch);
                }
            }
            switchCase += ch;
        }
        if (switchCase.equals(expected)) {
            System.out.println("Yes");
        }
        else if (expected.equals(actual)) {
            System.out.println("Yes");
        }
        else if (expected.substring(1).equals(actual)
                    && Character.isDigit(expected.charAt(0))) {
            System.out.println("Yes");
        }
        else if (expected.substring(0,expected.length()-1).equals(actual)
                && Character.isDigit(expected.charAt(expected.length()-1))) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}
