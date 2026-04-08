import java.io.*;
import java.util.Arrays;

class InsertionSort {

  private static void sort(int[] arr) {

    for (int i = 1; i < arr.length; i++) {
      int j = i - 1;
      int key = arr[i];

      while (j >= 0 && arr[j] > key) {
        arr[j + 1] = arr[j];
        j--;
      }
      arr[j + 1] = key;
    }
  }

  public static void main(String[] args) {
    int[] arr = { 2, 5, 3, 8, 6, 7, 1, 9 };
    sort(arr);

    try {
      FileWriter write = new FileWriter("InsertionSort_output.txt");

      write.write(Arrays.toString(arr));

      write.close(); // VERY IMPORTANT
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}