import java.util.Scanner;

public class Tetration {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double n = scanner.nextDouble();
        System.out.printf("%.6f",Math.pow(n, 1.0/n));
    }
}
