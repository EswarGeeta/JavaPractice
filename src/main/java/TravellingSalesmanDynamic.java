import java.util.ArrayList;
import java.util.List;

public class TravellingSalesmanDynamic {
    public static void main(String[] args) {
        int[][] weightedGraph = new int[][]{{0, 10, 15, 20},
                {10, 0, 35, 25},
                {15, 35, 0, 30},
                {20, 25, 30, 0}};

        List<Integer> cycle = tsPath(weightedGraph);
    }

    public static List<Integer> tsPath(int[][] weightedGraph) {
        return new ArrayList<>();
    }
}
