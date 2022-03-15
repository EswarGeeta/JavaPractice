import java.util.HashMap;
import java.util.Map;

public class Test {
    public static void main(String[] args) {
        HashMap<Character, Integer> chars = new HashMap<>();
        chars.put('a', 1);
        chars.put('b', 3);
        Map<Character, Integer> clonedChars = (HashMap<Character, Integer>) chars.clone();
        chars.put('c', 6);

        clonedChars.entrySet().forEach(System.out::println);
    }
}
