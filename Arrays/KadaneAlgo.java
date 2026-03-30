
public class KadaneAlgo {

  private int maxSum(int[] arr) {
    int maxSum = -Integer.MAX_VALUE;
    int currentSum = 0;

    for (int i = 0; i < arr.length; i++) {
      currentSum += arr[i];

      if (currentSum > maxSum) {
        maxSum = currentSum;
      }

      if (currentSum < 0)
        currentSum = 0;

    }
    return maxSum;
  }

  public static void main(String[] args) {
    int[] arr = { 1, -2, 3, 4, 5, 6, -7, 8, 9, 4, 5, 6, 7, 8, 4, -5, 6, -7, 8 };
    KadaneAlgo maxSum = new KadaneAlgo();

    System.out.println(maxSum.maxSum(arr));

  }
}