import java.util.*;

public class Kitchen {

    static PriorityQueue<State> nextQ = new PriorityQueue<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        Cup[] startCups = new Cup[n];
        for (int i=0; i<n; i++) {
            if (i == 0) {
                int volume = scanner.nextInt();
                startCups[i] = new Cup(volume, volume);
            }
            else {
                startCups[i] = new Cup(scanner.nextInt(), 0);
            }
        }
        int goal = scanner.nextInt();

        State start = new State(startCups, 0);
        HashMap<String, Integer> seen = new HashMap<>();
        nextQ.add(start);
        int weight = -1;
        while (nextQ.size() !=0) {
            State next = nextQ.poll();
            if (!seen.containsKey(next.getId()) || next.getWeight() < seen.get(next.getId())) {
                seen.put(next.getId(), next.getWeight());
                if (next.getFirst() == goal) {
                    if (weight == -1 || next.getWeight() < weight) {
                        weight = next.getWeight();
                    }
                }
                else {
                    ArrayList<State> neighbors = next.getNeighbors();
                    for (State state: neighbors) {
                        nextQ.add(state);
                    }
                }
            }
        }
        if (weight > 0) {
            System.out.println(weight);
        }
        else {
            System.out.println("impossible");
        }
    }

    static class Cup {
        private int volume;
        private int current;

        public Cup(int volume, int current) {
            this.volume = volume;
            this.current = current;
        }
        public int getVolume() {
            return this.volume;
        }
        public int getCurrent() {
            return this.current;
        }
        public int extraVolume() {
            return volume - current;
        }
        public boolean isFull() {
            return this.volume == this.current;
        }
        public boolean equals(Cup that) {
            return this.current == that.current && this.volume == that.volume;
        }
        public int pour(Cup that) {
            int weight = 0;
            if (extraVolume() >= that.current) {
                weight = that.current;
                this.current += that.current;
                that.current = 0;
            }
            else {
                weight = extraVolume();
                that.current -= extraVolume();
                this.current = this.volume;
            }
            return weight;
        }
    }

    static class State implements Comparable<State> {

        private Cup[] cups;
        private int weight;

        public State(Cup[] cups, int weight) {
            this.cups = cups;
            this.weight = weight;
        }

        public int getFirst() {
            return cups[0].getCurrent();
        }

        public int getWeight() {
            return this.weight;
        }

        public ArrayList<State> getNeighbors() {
            ArrayList<State> next = new ArrayList<>();
            for (int i = 0; i < cups.length; i++) {
                for (int j = 0; j < cups.length; j++) {
                    if (i != j && !cups[j].isFull()) {
                        Cup[] newCups = new Cup[cups.length];
                        for (int k = 0; k<newCups.length; k++) {
                            newCups[k] = new Cup(cups[k].getVolume(), cups[k].getCurrent());
                        }
                        int newWeight = newCups[j].pour(newCups[i]);
                        newWeight += this.weight;
                        next.add(new State(newCups, newWeight));
                    }
                }
            }
            return next;
        }

        public String getId() {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < cups.length; i++) {
                sb.append(cups[i].getCurrent());
            }
            return sb.toString();
        }

        public boolean equals(State that) {
            for (int i = 0; i < cups.length; i++) {
                if (!this.cups[i].equals(that.cups[i])) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public int compareTo(State that) {
            return this.weight - that.weight;
        }
    }
}
