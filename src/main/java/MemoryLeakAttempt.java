import java.util.ArrayList;
import java.util.List;

public class MemoryLeakAttempt {
    public static void main(String[] args) {
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < 10000000 ; i++) {
            try {
//                if(i%40 == 0)
                    Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            strings.add("item" + i);
            System.out.println(Runtime.getRuntime().freeMemory());
        }
    }
}
