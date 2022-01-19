import java.util.Scanner;

public class PhoneSwitch {

    public static void main(String [] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        if (line.startsWith("555")) {
            System.out.println(1);
        }
        else {
            System.out.println(0);
        }
    }
}
