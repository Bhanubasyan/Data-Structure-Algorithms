import java.util.*;

public class FirstGraph {

  public static void main(String[] args) {
    int v = 6;
    List<List<Integer>> adj = new ArrayList<>();

    for (int i = 0; i < v; i++) {
      adj.add(new ArrayList<>());
    }

    adj.get(0).add(1);
    adj.get(1).add(2);
    adj.get(5).add(0);
    adj.get(5).add(3);
    adj.get(3).add(4);
    adj.get(4).add(2);

    for (int i = 0; i < v; i++) {
      System.out.println(i + " -> " + adj.get(i));
    }
  }
}