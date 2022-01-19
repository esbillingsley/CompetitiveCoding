import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class SimonSays {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder answers = new StringBuilder();
        int tests = scanner.nextInt();
        scanner.nextLine();
        for(int t=0; t<tests; t++) {
            String line = scanner.nextLine();
            if (line.startsWith("Simon says")) {
                answers.append(line.substring(11) + "\n");
            }
        }
        System.out.println(answers);
    }
}
