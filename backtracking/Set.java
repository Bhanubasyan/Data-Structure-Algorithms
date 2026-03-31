import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Set {

  public static void setByBacktracing(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {

    result.add(new ArrayList<>(current));
    for (int i = index; i < nums.length; i++) {

      // choose
      current.add(nums[i]);

      // explore
      setByBacktracing(nums, i + 1, current, result);

      // unchoose
      current.remove(current.size() - 1);
    }

  }

  public static void main(String[] args) {
    int[] nums = { 1, 2, 3 };
    List<List<Integer>> result = new ArrayList<>();
    setByBacktracing(nums, 0, new ArrayList<>(), result);
    System.out.println(result);

    // output file

    try {
      FileWriter write = new FileWriter("outputFile.txt");

      write.write("Subsets are  : " + result);

      write.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
