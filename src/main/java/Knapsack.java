public class Knapsack {

    public static int knapsackRecursive(int maxWeight, int[] weights, int[] values) {
        return knapsackRecursive(maxWeight, weights, values, 0);
    }

    private static int knapsackRecursive(int maxWeight, int[] weights, int[] values, int i) {
        if (i == weights.length || maxWeight <= 0) {
            return 0;
        }

        if (maxWeight < weights[i]) {
            return knapsackRecursive(maxWeight - weights[i], weights, values, i+1);
        }

        // There are 2 ways. Either include or exclude current object. Return the max of these 2 choices.
        int valueIncluding = values[i] + knapsackRecursive(maxWeight - weights[i], weights, values, i+1);
        int valueExcluding = knapsackRecursive(maxWeight, weights, values, i+1);

        if (valueExcluding < valueIncluding ) {
            return valueIncluding;
        } else {
            return valueExcluding;
        }
    }

    public static void main(String[] args) {
//        int[] values = { 1, 8, 18, 22, 28};
//        int[] weights = {1, 3,5,7,8};
        int[] values = { 8, 1, 18, 28, 22};
        int[] weights = {3, 1,5, 8, 7};
        int maxWeight = 11;

        System.out.println("Result : "  + knapsackRecursive(maxWeight, weights, values));

    }
}
