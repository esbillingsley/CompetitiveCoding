import java.util.*;
import java.lang.StringBuilder;

public class Boats {
    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        StringBuilder answers = new StringBuilder();

        for (int i=0; i<testCases; i++) {
            int listLength = scan.nextInt();

            ArrayList<Integer> weightList = new ArrayList<Integer>(listLength);
            for (int j=0; j<listLength; j++) {
                weightList.add(scan.nextInt());
            }

            ArrayList<Integer> possibleTeamWeights = new ArrayList<Integer>();
            for (int j=0; j<listLength-1; j++) {
                for (int k=j+1; k<listLength; k++) {
                    possibleTeamWeights.add(weightList.get(j)+weightList.get(k));
                }
            }
            Collections.sort(possibleTeamWeights);
            int bestTeamWeight = 0;
            int weightCount = 0;
            for (int weight: possibleTeamWeights) {
                int testWeight = Collections.frequency(possibleTeamWeights, weight);
                if (testWeight>weightCount) {
                    weightCount = testWeight;
                    bestTeamWeight = weight;
                }
            }

            int teamCount = 0;
            int j = 0;
            while (j<weightList.size()-1) {
                int k = j+1;
                while (k<weightList.size()) {
                    if (weightList.get(j)+weightList.get(k) == bestTeamWeight) {
                        teamCount++;
                        weightList.remove(j);
                        weightList.remove(k-1);
                        k = j;
                    }
                    k++;
                }
                j++;
            }
            answers.append(teamCount + "\n");
        }

    System.out.println(answers);
    }
}
