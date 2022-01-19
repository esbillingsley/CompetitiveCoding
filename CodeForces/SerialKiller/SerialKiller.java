import java.io.*;
import java.util.*;
import java.util.StringTokenizer;

public class SerialKiller implements Runnable {
    public static void main(String [] args) {
        new Thread(null, new SerialKiller(), "whatever", 1<<26).start();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder answers = new StringBuilder();
        ArrayList<String> currentPair = new ArrayList<>();
        String start = scanner.nextLine();
        answers.append(start + "\n");
        for (String name: start.split(" ")) {
            currentPair.add(name);
        }
        int n = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < n; i++) {
            String line = scanner.nextLine();
            String[] names = line.split(" ");
            currentPair.remove(currentPair.indexOf(names[0]));
            currentPair.add(names[1]);
            answers.append(currentPair.get(0) + " " + currentPair.get(1) + "\n");
        }
        System.out.println(answers);
    }

}
