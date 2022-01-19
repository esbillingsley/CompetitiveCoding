public class SubStrings {

    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        int testCases = scan.nextInt();
        ArrayList<String> answers = new ArrayList<String>();

        for (int i=0; i<testCases; i++) {
            int listLength = scan.nextInt();

            int[] binaryList = new int[listLength];
            for (int j=0; j<listLength; j++) {
                binaryList.add(scan.nextInt());
            }

            String answer = "1 ";
            int subCount = 1;
            int lastSubDigit;
            for (int j=1; j<listLength; j++) {
                if (binaryList[j-1]!=binaryList[j]) {
                    answer += String.format("%d ",subCount);
                } else {
                    lastSubDigit = binaryList[j-1];
                    subCount++;
                    answer += String.format("%d ",subCount);
                }
            }

        }
        for (int ans: answers) {
            System.out.println(ans);
        }
    } //main
}
