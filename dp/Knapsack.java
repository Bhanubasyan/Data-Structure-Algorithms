public class Knapsack {

  private static int knapsack_01(int[] weight, int[] value, int W) {

    int n = weight.length;

    int[][] dp = new int[n + 1][W + 1];

    for (int i = 1; i <= n; i++) {
      for (int w = 1; w <= W; w++) {

        // skip

        dp[i][w] = dp[i - 1][w];

        // take

        if (weight[i - 1] <= w) {

          dp[i][w] = Math.max(dp[i][w], value[i - 1] + dp[i - 1][w - weight[i - 1]]);

          /*
           * 🔹 1. value[i - 1]
           * 
           * Value of the current item
           * 
           * 2. dp[i - 1][w - weight[i - 1]]
           * 
           * After taking the item, some capacity is used.
           * 
           * So:
           * 
           * remaining capacity = w - weight[i-1]
           * 
           * Now we ask:
           * 
           * “With remaining capacity, what best value could I already make using previous
           * items?”
           */

        }

      }
    }

    return dp[n][W];
  }

  public static void main(String[] args) {
    int[] weight = { 1, 3, 4 };
    int[] value = { 1, 4, 5 };
    int W = 4;

    int ans = knapsack_01(weight, value, W);
    System.out.println(ans);
  }

}
