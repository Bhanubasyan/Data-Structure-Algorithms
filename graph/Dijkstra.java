import java.util.*;

// structure class for graph 
class Pair {
  int node;
  int weight;

  Pair(int node, int weight) {
    this.node = node;
    this.weight = weight;
  }
}

public class Dijkstra {

  // dijkstra function jo as input vertices V , adj nodes matlab nodes with their
  // corrsponding weight adj , sorce node src
  public static int[] dijkstra(int V, List<List<Pair>> adj, int src) {

    // priority queue

    PriorityQueue<Pair> pq = new PriorityQueue<>(
        (a, b) -> a.weight - b.weight

    );

    // DISTANCE ARRAy bnao usko fill kro distance infinity se
    int[] dist = new int[V];

    Arrays.fill(dist, Integer.MAX_VALUE);

    // add src node in queue
    dist[src] = 0;

    pq.add(new Pair(src, 0));

    while (!pq.isEmpty()) {
      Pair p = pq.poll();
      int u = p.node;

      for (Pair nbr : adj.get(u)) {
        int v = nbr.node;
        int w = nbr.weight;

        if (dist[u] + w < dist[v]) {
          dist[v] = dist[u] + w;

          pq.add(new Pair(v, dist[v]));
        }
      }
    }

    return dist;
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    int V = sc.nextInt(); // number of vertices
    int E = sc.nextInt(); // number of edges

    List<List<Pair>> adj = new ArrayList<>();

    for (int i = 0; i < V; i++) {
      adj.add(new ArrayList<>());
    }

    // input edges
    for (int i = 0; i < E; i++) {
      int u = sc.nextInt();
      int v = sc.nextInt();
      int w = sc.nextInt();

      adj.get(u).add(new Pair(v, w));

      // for undirected graph add this also:
      adj.get(v).add(new Pair(u, w));
    }

    int src = sc.nextInt();

    int[] result = dijkstra(V, adj, src);

    // print result
    for (int i = 0; i < V; i++) {
      System.out.println("Distance to " + i + " = " + result[i]);
    }
  }
}