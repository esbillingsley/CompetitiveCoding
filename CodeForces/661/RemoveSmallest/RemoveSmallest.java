import java.util.*;

public class RemoveSmallest {

    public static void main (String[] args) {
        int listLength;
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        ArrayList<String> answers = new ArrayList<String>(testCases);

        for (int i=0; i<testCases; i++) {
            listLength = scan.nextInt();
            ArrayList<Integer> numList = new ArrayList<Integer>(listLength);
            for (int k=0; k<listLength; k++) {
                numList.add(scan.nextInt());
            }
            Collections.sort(numList);
            if (listLength==1) {
                answers.add("YES");
            } else {
                int j = 0;
                while (j<numList.size()-1) {
                    int firstNum = numList.get(j);
                    int secondNum = numList.get(j+1);
                    if (Math.abs(firstNum-secondNum)==1 || firstNum==secondNum) {
                        if (firstNum<secondNum) {
                            numList.remove(j);
                            j--;
                        } else {
                            numList.remove(j+1);
                            j--;
                        }
                    }
                    j++;
                }

                if (numList.size()==1) {
                    answers.add("YES");
                } else {
                    answers.add("NO");
                }

            }
        }
        for (String ans: answers) {
            System.out.println(ans);
        }
    } //main
}
