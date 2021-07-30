import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordBreak {
    static String wordsInString = "i like sam sung samsung mobile ice cream icecream man go mango";
    public static Set<String> dict = new HashSet<>(Arrays.asList(wordsInString.split(" ")));

    public static void main(String[] args) {
        String input = "ilikeicecreamsam";
        System.out.println(canBreakIntoWords(input));
    }

    private static boolean canBreakIntoWords(String input) {
        if(input == null || input.isEmpty())
            return true;
        String word;
        for(int i =1; i <= input.length(); i++) {
            word = input.substring(0, i);
            if(dict.contains(word)) {
                String remaining = input.substring(i);
                if(remaining.length() != 0) {
                    boolean result = canBreakIntoWords(remaining);
                    if(result)
                        return true;
                } else {
                    return true;
                }
            }
        }
        return false;
    }
}
