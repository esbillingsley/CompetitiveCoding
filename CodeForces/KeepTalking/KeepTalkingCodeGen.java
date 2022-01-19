import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;
import java.util.*;

public class KeepTalkingCodeGen
{
    public static void main(String[] args)
    {
        StringBuilder sb = new StringBuilder();
        String filePath = "KeepTalkingInstructions.txt";

        String all = readAllBytesJava7(filePath);
        String[] ifSplit = all.split("If");
        ArrayList<String> ifElseSplit = new ArrayList<>();
        for (int i = 0; i < ifSplit.length; i++) {
            ifElseSplit.addAll(Arrays.asList(ifSplit[i].split("else")));
        }
        for (int i = 0; i < ifElseSplit.size(); i++) {
            String[] words = ifElseSplit.get(i).strip().split(" ");
            if (words[0].equals("digit")) {
                if (words[3].equals("odd,")) {
                    sb.append(String.format("if (num[%s] %% 2 != 0) {\n\trotate(%s, %s);\n}", words[1], words[6], words[8]));
                    i++;
                    words = ifElseSplit.get(i).strip().split(" ");
                    sb.append(String.format("else {\n\trotate(%s, %s);\n}\n", words[2], words[4]));
                }
                else {
                    sb.append(String.format("if (num[%s] > num[%s]) {\n\trotate(%s, %s);\n}", words[1], words[6].replace(",",""), words[9], words[11]));
                    i++;
                    words = ifElseSplit.get(i).strip().split(" ");
                    sb.append(String.format("else {\n\trotate(%s, %s);\n}\n", words[2], words[4]));
                }
            }
            else {
                if (words.length == 1) {
                    continue;
                }
                sb.append(String.format("if (num[%s] + num[%s] > %s) {\n\trotate(%s, %s);\n}", words[3], words[5], words[9].replace(",",""), words[12], words[14]));
                i++;
                words = ifElseSplit.get(i).strip().split(" ");
                sb.append(String.format("else {\n\trotate(%s, %s);\n}\n", words[2], words[4]));
            }
        }
        System.out.println(sb);
    }

    private static String readAllBytesJava7(String filePath)
    {
        String content = "";

        try
        {
            content = new String ( Files.readAllBytes( Paths.get(filePath) ) );
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        return content;
    }
}
