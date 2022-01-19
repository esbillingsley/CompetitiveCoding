import java.io.*;
import java.util.*;

public class Bishops {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StringBuilder answers = new StringBuilder();//realized this got left in from when I was figuring out the output, but this is the file I submitted
        while(scanner.hasNextInt()) {
            int n = scanner.nextInt();
            if (n==1) {
                System.out.println(1);
            }
            else {
                System.out.println(n+(n-2));
            }
        }
        scanner.close();
    }
}
