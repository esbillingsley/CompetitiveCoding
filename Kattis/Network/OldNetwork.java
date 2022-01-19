import java.io.*;
import java.util.*;


public class Network implements Runnable {
    ArrayList<Integer>[] graph;
    boolean[] connected;

    public static void main(String[] args) {
        new Thread(null, new Network(), "whatever", 1<<26).start();
    }

    public void run() {

    }
    }
