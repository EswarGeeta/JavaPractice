import java.util.Arrays;

public class MinimumPlatforms {

    public static void main(String[] args) {
        int[] arrTimes = new int[]{900, 940, 950, 1100, 1500, 1800};
        int[] depTimes = new int[]{910, 1200, 1120, 1130, 1900, 2000};

        System.out.println(getMinPlatforms(arrTimes, depTimes));
    }

    private static int getMinPlatforms(int[] arrTimes, int[] depTimes) {
        Arrays.sort(arrTimes);
        Arrays.sort(depTimes);

        // Complete it if time permits

        return 0;
    }
}
