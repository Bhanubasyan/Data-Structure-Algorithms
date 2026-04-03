import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class QuickSort {

  public static void quickSort(int[] arr, int low, int high) {
    if (low < high) {
      int pivot = partiTion(arr, low, high);

      quickSort(arr, low, pivot - 1); // left
      quickSort(arr, pivot + 1, high);// right
    }
  }

  private static int partiTion(int[] arr, int low, int high) {
    int pivot = arr[high];

    int i = low - 1;

    for (int j = low; j < high; j++) {
      if (arr[j] < pivot) {
        i++;

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
      }
    }
    int temp = arr[i + 1];
    arr[i + 1] = arr[high];
    arr[high] = temp;
    return i + 1;
  }

  public static void main(String[] args) {
    int[] arr = { 5, 2, 8, 3, 1 };

    quickSort(arr, 0, arr.length - 1);
    try {
      FileWriter write = new FileWriter("output.txt");

      for (int x : arr) {
        write.write(x + " ");
        System.out.println(x + "  ");
      }
      write.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}