import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Result {

  /*
   * Complete the 'getWays' function below.
   *
   * The function is expected to return a LONG_INTEGER.
   * The function accepts following parameters:
   *  1. INTEGER n
   *  2. LONG_INTEGER_ARRAY c
   */

  public static long getWays(int n, List<Long> c) {
    // Write your code here

    return 0;
  }
}

public class Solution {
  public static void main(String[] args) throws IOException {
    int n = 10;
    List<Long> c = Arrays.asList(2l,5l,3l,6l);
    c.sort(Comparator.comparing(Long::longValue));
    System.out.println(c);
//    c.stream().sorted();
//    long ways = Result.getWays(n, c);
  }
}
